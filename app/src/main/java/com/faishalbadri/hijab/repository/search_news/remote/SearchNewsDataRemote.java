package com.faishalbadri.hijab.repository.search_news.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.api.APIClient;
import com.faishalbadri.hijab.api.APIInterface;
import com.faishalbadri.hijab.data.news.NewsItem;
import com.faishalbadri.hijab.data.news.NewsResponse;
import com.faishalbadri.hijab.repository.search_news.SearchNewsDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchNewsDataRemote implements SearchNewsDataResource {

  Context context;

  public SearchNewsDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getSearchNewsResult(String key,
      @NonNull SearchNewsGetCallback searchNewsGetCallback) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<NewsResponse> newsResponseCall = apiInterface.searchNews(key, DataUser.getInstance()
        .getUserApiKey());
    newsResponseCall.enqueue(new Callback<NewsResponse>() {
      @Override
      public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
        try {
          if (response.body().getNews() == null) {
            searchNewsGetCallback.onWrongSearchNews("Null");
          } else {
            NewsResponse newsResponse = response.body();
            List<NewsItem> items = newsResponse.getNews();
            searchNewsGetCallback.onSuccesSearchNews(items, "Ok");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<NewsResponse> call, Throwable t) {
        searchNewsGetCallback.onErrorSearchNews(context.getResources().getString(R
            .string.caption_error_internet_acces));
      }
    });
  }
}
