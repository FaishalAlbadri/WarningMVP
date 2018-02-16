package com.faishalbadri.hijab.repository.news.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoNews;
import com.faishalbadri.hijab.repository.news.NewsDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import com.faishalbadri.hijab.util.server.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsDataRemote implements NewsDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "newsfeed?page=";
  private static final String URL_SLIDER = Server.BASE_URL_REVAMP + "newsfeed/popular";
  private Context context;
  private RequestQueue requestQueue;


  public NewsDataRemote(Context context) {
    this.context = context;
    requestQueue = Volley.newRequestQueue(context);
  }

  @Override
  public void getNewsResult(int PAGE, @NonNull NewsGetCallback newsGetCallback) {
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL + PAGE),
        response -> {
          final PojoNews pojoNews = new Gson().fromJson(response, PojoNews.class);
          Log.i("response", response);
          try {
            if (pojoNews.getNews().toString().equals("[]")) {
              newsGetCallback.onErrorNews("Data Null");
            } else {
              newsGetCallback.onSuccesNews(pojoNews.getNews(), "Succes");
            }
          } catch (Exception e) {

          }
        }, error -> {
      if (PAGE == 1) {
        newsGetCallback.onErrorNews(context.getResources().getString(R
            .string.caption_error_internet_acces));
      } else if (PAGE > 1) {
        newsGetCallback.onErrorNews("Data Pagination Error");
      }
    }) {
      @Override
      public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Authorization", DataUser.getInstance().getUserApiKey());
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }

  @Override
  public void getSliderResult(@NonNull SliderGetCallback sliderGetCallback) {
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL_SLIDER),
        response -> {
          final PojoNews pojoNews = new Gson().fromJson(response, PojoNews.class);
          try {
            if (pojoNews == null) {
              sliderGetCallback.onErrorSlider("Data Null");
            } else {
              sliderGetCallback.onSuccesSlider(pojoNews.getNews(), "Succes");
            }
          } catch (Exception e) {

          }
        }, error -> sliderGetCallback.onErrorSlider(context.getResources().getString(R
        .string.caption_error_internet_acces))) {
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
