package com.faishalbadri.hijab.repository.detail_news_related.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.api.APIClient;
import com.faishalbadri.hijab.api.APIInterface;
import com.faishalbadri.hijab.data.news.NewsItem;
import com.faishalbadri.hijab.data.news.NewsResponse;
import com.faishalbadri.hijab.repository.detail_news_related.DetailNewsDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fikriimaduddin on 11/8/17.
 */

public class DetailNewsDataRemote implements DetailNewsDataResource {

  private Context context;

  public DetailNewsDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getDetailNewsPopularResult(String id_isi,
      @NonNull DetailNewsPopularGetCallback detailNewsPopularGetCallback) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<NewsResponse> newsResponseCall = apiInterface
        .getNews("newsfeed?limit=4", DataUser.getInstance().getUserApiKey());
    newsResponseCall.enqueue(new Callback<NewsResponse>() {
      @Override
      public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
        try {
          if (response.body().getNews().toString().equals("[]")) {
            detailNewsPopularGetCallback.onErrorDetailNewsPopular("Data Null");
          } else {
            NewsResponse newsResponse = response.body();
            List<NewsItem> items = newsResponse.getNews();
            detailNewsPopularGetCallback.onSuccesDetailNewsPopular(items, "Succes");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<NewsResponse> call, Throwable t) {
        detailNewsPopularGetCallback.onErrorDetailNewsPopular(
            context.getResources().getString(R.string.caption_error_internet_acces));
      }
    });
  }

  @Override
  public void getViewResult(String id_news, @NonNull viewGetCallback viewGetCallback) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<NewsResponse> newsResponseCall = apiInterface.getNews("newsfeed/detail/" + id_news,
        DataUser
            .getInstance().getUserApiKey());
    newsResponseCall.enqueue(new Callback<NewsResponse>() {
      @Override
      public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
        try {
          if (response.body().getNews() == null) {
            viewGetCallback.onError("Data Null");
          } else {
            NewsResponse newsResponse = response.body();
            List<NewsItem> items = newsResponse.getNews();
            viewGetCallback.onSuccesView(items, "Succes");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<NewsResponse> call, Throwable t) {
        viewGetCallback
            .onError(context.getResources().getString(R.string.caption_error_internet_acces));
      }
    });
  }
}
