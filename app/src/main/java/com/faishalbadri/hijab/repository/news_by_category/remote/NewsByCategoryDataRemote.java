package com.faishalbadri.hijab.repository.news_by_category.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.data.PojoNews;
import com.faishalbadri.hijab.repository.news_by_category.NewsByCategoryDataResource;
import com.faishalbadri.hijab.util.ApiKey;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsByCategoryDataRemote implements NewsByCategoryDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "newsfeed/";
  Context context;

  public NewsByCategoryDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getNewsByCategoryGetDataCallBack(String id,
      @NonNull NewsByCategoryGetDataCallBack newsByCategoryGetDataCallBack) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL + id),
        response -> {
          final PojoNews pojoNews = new Gson().fromJson(response, PojoNews.class);
          try {
            if (pojoNews == null) {
              newsByCategoryGetDataCallBack.onErrorNewsByCategory("Data Null");
            } else {
              newsByCategoryGetDataCallBack.onSuccessNewsByCategory(pojoNews.getNews(), "Succes");
              Log.i("response", response);
            }
          } catch (Exception e) {

          }
        }, error -> newsByCategoryGetDataCallBack.onErrorNewsByCategory(String.valueOf(error))) {
      @Override
      public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Authorization", ApiKey.getInstance(context).getApiKey());
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }
}