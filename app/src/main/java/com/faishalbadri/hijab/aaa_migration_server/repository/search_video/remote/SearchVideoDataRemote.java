package com.faishalbadri.hijab.aaa_migration_server.repository.search_video.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoVideo;
import com.faishalbadri.hijab.aaa_migration_server.repository.search_video.SearchVideoDataResource;
import com.faishalbadri.hijab.aaa_migration_server.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchVideoDataRemote implements SearchVideoDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "videos/find";
  Context context;

  public SearchVideoDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getSearchVideoResult(String key,
      @NonNull SearchVideoGetCallback searchVideoGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.POST, String.valueOf(URL),
        response -> {
          Log.i("response", response);
          final PojoVideo pojoVideo = new Gson().fromJson(response, PojoVideo.class);
          try {
            if (pojoVideo == null) {
              searchVideoGetCallback.onWrongSearchVideo("Null");
            } else {
              searchVideoGetCallback.onSuccesSearchVideo(pojoVideo.getVideos(), "Ok");
            }
          } catch (Exception e) {

          }
        }, error -> searchVideoGetCallback.onErrorSearchVideo(String.valueOf(error))) {

      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("query", key);
        return params;
      }

      @Override
      public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Authorization", "57b44757920f9b2544cd57f1d998e7f7");
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }
}
