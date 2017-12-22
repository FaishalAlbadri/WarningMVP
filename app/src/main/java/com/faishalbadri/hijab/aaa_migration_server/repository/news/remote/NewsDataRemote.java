package com.faishalbadri.hijab.aaa_migration_server.repository.news.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoNews;
import com.faishalbadri.hijab.aaa_migration_server.repository.news.NewsDataResource;
import com.faishalbadri.hijab.aaa_migration_server.util.ApiKey;
import com.faishalbadri.hijab.aaa_migration_server.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsDataRemote implements NewsDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "newsfeed";
  private static final String URL_SLIDER = Server.BASE_URL_REVAMP + "newsfeed/popular";
  Context context;


  public NewsDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getNewsResult(@NonNull NewsGetCallback newsGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL),
        response -> {
          final PojoNews pojoNews = new Gson().fromJson(response, PojoNews.class);
          try {
            if (pojoNews == null) {
              newsGetCallback.onErrorNews("Data Null");
            } else {
              newsGetCallback.onSuccesNews(pojoNews.getNews(), "Succes");
              Log.i("response", response);
            }
          } catch (Exception e) {

          }
        }, error -> newsGetCallback.onErrorNews(String.valueOf(error))) {
      @Override
      public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Authorization", ApiKey.getInstance(context).getApiKey());
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }

  @Override
  public void getSliderResult(@NonNull SliderGetCallback sliderGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL),
        response -> {
          final PojoNews pojoNews = new Gson().fromJson(response, PojoNews.class);
          try {
            if (pojoNews == null) {
              sliderGetCallback.onErrorSlider("Data Null");
            } else {
              sliderGetCallback.onSuccesSlider(pojoNews.getNews(), "Succes");
              Log.i("response", response);
            }
          } catch (Exception e) {

          }
        }, error -> sliderGetCallback.onErrorSlider(String.valueOf(error))) {
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
