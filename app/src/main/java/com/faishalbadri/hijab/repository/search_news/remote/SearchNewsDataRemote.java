package com.faishalbadri.hijab.repository.search_news.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoNews;
import com.faishalbadri.hijab.repository.search_news.SearchNewsDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import com.faishalbadri.hijab.util.server.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchNewsDataRemote implements SearchNewsDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "newsfeed/find";
  Context context;

  public SearchNewsDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getSearchNewsResult(String key,
      @NonNull SearchNewsGetCallback searchNewsGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.POST, String.valueOf(URL),
        response -> {
          final PojoNews pojoNews = new Gson().fromJson(response, PojoNews.class);
          try {
            if (pojoNews == null) {
              searchNewsGetCallback.onWrongSearchNews("Null");
            } else {
              searchNewsGetCallback
                  .onSuccesSearchNews(pojoNews.getNews(), "Ok");
            }
          } catch (Exception e) {

          }
        }, error -> searchNewsGetCallback.onErrorSearchNews(context.getResources().getString(R
        .string.caption_error_internet_acces))) {

      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("query", key);
        return params;
      }

      @Override
      public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Authorization", DataUser.getInstance().getUserApiKey());
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }
}
