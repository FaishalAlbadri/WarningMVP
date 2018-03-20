package com.faishalbadri.hijab.repository.news_popular.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.api.APIClient;
import com.faishalbadri.hijab.api.APIInterface;
import com.faishalbadri.hijab.data.news.NewsItem;
import com.faishalbadri.hijab.data.news.NewsResponse;
import com.faishalbadri.hijab.repository.news_popular.NewsPopularDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsPopularDataRemote implements NewsPopularDataResource {

  private Context context;

  public NewsPopularDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getNewsPopularResult(@NonNull NewsPopularGetCallback newsPopularGetCallback) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<NewsResponse> newsResponseCall = apiInterface.getNews("newsfeed/popular",
        DataUser.getInstance().getUserApiKey());
    newsResponseCall.enqueue(new Callback<NewsResponse>() {
      @Override
      public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
        try {
          if (response.body().getNews() == null) {
            newsPopularGetCallback.onErrorNewsPopular("Data Null");
          } else {
            NewsResponse newsResponse = response.body();
            List<NewsItem> items = newsResponse.getNews();
            newsPopularGetCallback.onSuccesNewsPopular(items, "Succes");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<NewsResponse> call, Throwable t) {
        newsPopularGetCallback.onErrorNewsPopular(
            context.getResources().getString(R.string.caption_error_internet_acces));
      }
    });
  }
}
