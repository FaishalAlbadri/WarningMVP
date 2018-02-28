package com.faishalbadri.hijab.repository.detail_news_related_.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoNews;
import com.faishalbadri.hijab.repository.detail_news_related_.DetailNewsDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import com.faishalbadri.hijab.util.server.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fikriimaduddin on 11/8/17.
 */

public class DetailNewsDataRemote implements DetailNewsDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "newsfeed?limit=4";
  private static final String URL_VIEW = Server.BASE_URL_REVAMP + "newsfeed/detail/";
  private Context context;
  private RequestQueue requestQueue;

  public DetailNewsDataRemote(Context context) {
    this.context = context;
    requestQueue = Volley.newRequestQueue(context);
  }

  @Override
  public void getDetailNewsPopularResult(String id_isi,
      @NonNull DetailNewsPopularGetCallback detailNewsPopularGetCallback) {
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL),
        response -> {
          final PojoNews pojoNews = new Gson().fromJson(response, PojoNews.class);
          try {
            if (pojoNews.getNews().toString().equals("[]")) {
              detailNewsPopularGetCallback.onErrorDetailNewsPopular("Data Null");
            } else {
              detailNewsPopularGetCallback.onSuccesDetailNewsPopular(pojoNews.getNews(), "Succes");
            }
          } catch (Exception e) {

          }
        }, error -> detailNewsPopularGetCallback
        .onErrorDetailNewsPopular(
            context.getResources().getString(R.string.caption_error_internet_acces))) {
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
  public void getViewResult(String id_news, @NonNull viewGetCallback viewGetCallback) {
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL_VIEW + id_news),
        response -> {
          final PojoNews pojoNews = new Gson().fromJson(response, PojoNews.class);
          try {
            if (pojoNews.getNews() == null) {
              viewGetCallback.onError("Data Null");
            } else {
              viewGetCallback.onSuccesView(pojoNews.getNews(), "Succes");
            }
          } catch (Exception e) {

          }
        }, error -> viewGetCallback
        .onError(
            context.getResources().getString(R.string.caption_error_internet_acces))) {
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
