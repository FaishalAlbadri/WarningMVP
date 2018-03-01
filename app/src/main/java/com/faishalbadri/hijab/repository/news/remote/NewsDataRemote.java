package com.faishalbadri.hijab.repository.news.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.api.APIClient;
import com.faishalbadri.hijab.api.APIInterface;
import com.faishalbadri.hijab.data.news.NewsItem;
import com.faishalbadri.hijab.data.news.NewsResponse;
import com.faishalbadri.hijab.repository.news.NewsDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsDataRemote implements NewsDataResource {

  private Context context;

  public NewsDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getNewsResult(int PAGE, @NonNull NewsGetCallback newsGetCallback) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<NewsResponse> newsResponseCall = apiInterface
        .getNews("newsfeed?page=", DataUser.getInstance().getUserApiKey());
    newsResponseCall.enqueue(new Callback<NewsResponse>() {
      @Override
      public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
        try {
          if (response.body().getNews().toString().equals("[]")) {
            newsGetCallback.onErrorNews("Data Null");
          } else {
            NewsResponse newsResponse = response.body();
            List<NewsItem> items = newsResponse.getNews();
            newsGetCallback.onSuccesNews(items, "Succes");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<NewsResponse> call, Throwable t) {
        if (PAGE == 1) {
          newsGetCallback.onErrorNews(context.getResources().getString(R
              .string.caption_error_internet_acces));
        } else if (PAGE > 1) {
          newsGetCallback.onErrorNews("Data Pagination Error");
        }
      }
    });
  }

  @Override
  public void getSliderResult(@NonNull SliderGetCallback sliderGetCallback) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<NewsResponse> newsResponseCall = apiInterface.getNews("newsfeed/popular",
        DataUser.getInstance().getUserApiKey());
    newsResponseCall.enqueue(new Callback<NewsResponse>() {
      @Override
      public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
        try {
          if (response.body().getNews() == null) {
            sliderGetCallback.onErrorSlider("Data Null");
          } else {
            NewsResponse newsResponse = response.body();
            List<NewsItem> items = newsResponse.getNews();
            sliderGetCallback.onSuccesSlider(items, "Succes");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<NewsResponse> call, Throwable t) {
        sliderGetCallback
            .onErrorSlider(context.getResources().getString(R.string.caption_error_internet_acces));
      }
    });
  }
}
