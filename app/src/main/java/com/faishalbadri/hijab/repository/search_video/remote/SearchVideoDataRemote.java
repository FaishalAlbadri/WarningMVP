package com.faishalbadri.hijab.repository.search_video.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoVideo;
import com.faishalbadri.hijab.repository.search_video.SearchVideoDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import com.faishalbadri.hijab.util.server.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchVideoDataRemote implements SearchVideoDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "videos/find";
  private Context context;
  private RequestQueue requestQueue;

  public SearchVideoDataRemote(Context context) {
    this.context = context;
    requestQueue = Volley.newRequestQueue(context);
  }

  @Override
  public void getSearchVideoResult(String key,
      @NonNull SearchVideoGetCallback searchVideoGetCallback) {
    StringRequest stringRequest = new StringRequest(Method.POST, String.valueOf(URL),
        response -> {
          final PojoVideo pojoVideo = new Gson().fromJson(response, PojoVideo.class);
          try {
            if (pojoVideo.getVideos() == null) {
              searchVideoGetCallback.onWrongSearchVideo("Null");
            } else {
              searchVideoGetCallback.onSuccesSearchVideo(pojoVideo.getVideos(), "Ok");
            }
          } catch (Exception e) {

          }
        }, error -> searchVideoGetCallback.onErrorSearchVideo(context.getResources().getString(R
        .string.caption_error_internet_acces))) {

      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("query", key);
        return params;
      }

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
