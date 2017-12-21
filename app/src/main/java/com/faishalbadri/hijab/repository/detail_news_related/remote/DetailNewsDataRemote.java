package com.faishalbadri.hijab.repository.detail_news_related.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.data.PojoNews;
import com.faishalbadri.hijab.repository.detail_news_related.DetailNewsDataResource;
import com.faishalbadri.hijab.aaa_migration_server.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
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
  public void getDetailNewsPopularResult(String id_isi,
      @NonNull DetailNewsPopularGetCallback detailNewsPopularGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.POST, String.valueOf(URL),
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
        }, error -> detailNewsPopularGetCallback.onErrorDetailNewsPopular(String.valueOf(error))) {
      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<>();
        params.put("id_isi", id_isi);
        return params;
      }
    };

    requestQueue.add(stringRequest);
  }
}
