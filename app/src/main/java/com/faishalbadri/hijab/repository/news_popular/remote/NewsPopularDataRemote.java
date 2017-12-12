package com.faishalbadri.hijab.repository.news_popular.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.data.PojoNews;
import com.faishalbadri.hijab.repository.news_popular.NewsPopularDataResource;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsPopularDataRemote implements NewsPopularDataResource {

  private static final String URL = Server.BASE_URL + "getTbPopuler.php";
  Context context;


  public NewsPopularDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getNewsPopularResult(@NonNull NewsPopularGetCallback newsPopularGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Request.Method.GET, String.valueOf(URL),
        response -> {
          try {
            if (String.valueOf(new JSONObject(response).getString("msg"))
                .equals("Data Semua Isi Populer")) {
              try {
                final PojoNews pojoNews = new Gson().fromJson(response, PojoNews.class);
                newsPopularGetCallback.onSuccesNewsPopular(pojoNews.getIsi(), "Success");
              } catch (Exception e) {

              }
            } else {
              newsPopularGetCallback.onErrorNewsPopular("Error");
            }
          } catch (JSONException e) {
          }
        }, error -> newsPopularGetCallback.onErrorNewsPopular(String.valueOf(error)));

    requestQueue.add(stringRequest);
  }
}
