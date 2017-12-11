package com.faishalbadri.hijab.repository.detail_news_related.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.data.PojoNews;
import com.faishalbadri.hijab.repository.detail_news_related.DetailNewsDataResource;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by fikriimaduddin on 11/8/17.
 */

public class DetailNewsDataRemote implements DetailNewsDataResource {

  private static final String URL = Server.BASE_URL + "getTbIsiNewRelated.php";
  Context context;

  public DetailNewsDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getDetailNewsPopularResult(
      @NonNull DetailNewsPopularGetCallback detailNewsPopularGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Request.Method.GET, String.valueOf(URL),
        response -> {
          try {
            if (String.valueOf(new JSONObject(response).getString("msg"))
                .equals("Data Semua Isi")) {
              try {
                final PojoNews pojoNews = new Gson().fromJson(response, PojoNews.class);
                detailNewsPopularGetCallback
                    .onSuccesDetailNewsPopular(pojoNews.getIsi(), "Success");
              } catch (Exception e) {

              }
            } else {
              detailNewsPopularGetCallback.onErrorDetailNewsPopular("Error");
            }
          } catch (JSONException e) {
          }
        }, error -> detailNewsPopularGetCallback.onErrorDetailNewsPopular(String.valueOf(error)));

    requestQueue.add(stringRequest);
  }
}
