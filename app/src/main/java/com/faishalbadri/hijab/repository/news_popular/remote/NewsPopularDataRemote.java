package com.faishalbadri.hijab.repository.news_popular.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoNews;
import com.faishalbadri.hijab.repository.news_popular.NewsPopularDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import com.faishalbadri.hijab.util.server.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsPopularDataRemote implements NewsPopularDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "newsfeed/popular";
  private Context context;
  private RequestQueue requestQueue;


  public NewsPopularDataRemote(Context context) {
    this.context = context;
    requestQueue = Volley.newRequestQueue(context);
  }

  @Override
  public void getNewsPopularResult(@NonNull NewsPopularGetCallback newsPopularGetCallback) {
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL),
        response -> {
          final PojoNews pojoNews = new Gson().fromJson(response, PojoNews.class);
          try {
            if (pojoNews == null) {
              newsPopularGetCallback.onErrorNewsPopular("Data Null");
            } else {
              newsPopularGetCallback.onSuccesNewsPopular(pojoNews.getNews(), "Succes");
            }
          } catch (Exception e) {

          }
        }, error -> newsPopularGetCallback.onErrorNewsPopular(
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
