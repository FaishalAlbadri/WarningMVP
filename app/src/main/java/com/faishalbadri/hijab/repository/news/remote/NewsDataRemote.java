package com.faishalbadri.hijab.repository.news.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.data.PojoNews;
import com.faishalbadri.hijab.data.PojoVideo;
import com.faishalbadri.hijab.repository.news.NewsDataResource;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsDataRemote implements NewsDataResource {

  Context context;
  private static final String URL = Server.BASE_URL+"getTbIsiNew.php";


  public NewsDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getNewsResult(@NonNull NewsGetCallback newsGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Request.Method.GET, String.valueOf(URL), response -> {
          try {
            if (String.valueOf(new JSONObject(response).getString("msg")).equals("Data Semua Isi")) {
              try {
                final PojoNews pojoNews = new Gson().fromJson(response, PojoNews.class);
                newsGetCallback.onSuccesNews(pojoNews.getIsi(), "Success");
              } catch (Exception e) {

              }
            }else {
              newsGetCallback.onErrorNews("Error");
            }
          } catch (JSONException e) {
          }
        }, error -> newsGetCallback.onErrorNews(String.valueOf(error)));

    requestQueue.add(stringRequest);
  }
}
