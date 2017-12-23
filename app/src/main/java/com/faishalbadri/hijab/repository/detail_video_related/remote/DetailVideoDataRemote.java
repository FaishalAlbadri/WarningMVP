package com.faishalbadri.hijab.repository.detail_video_related.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.data.PojoVideo;
import com.faishalbadri.hijab.repository.detail_video_related.DetailVideoDataResource;
import com.faishalbadri.hijab.util.ApiKey;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fikriimaduddin on 11/6/17.
 */

public class DetailVideoDataRemote implements DetailVideoDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "videos?limit=";
  private Context context;

  public DetailVideoDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getDetailVideo(String limit, @NonNull DetailVideoGetDataCallBack
      detailVideoGetDataCallBack) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL + limit),
        response -> {
          Log.i("response", response);
          final PojoVideo pojoVideo = new Gson().fromJson(response, PojoVideo.class);
          try {
            if (pojoVideo == null) {
              detailVideoGetDataCallBack.onError("Error");
            } else {
              detailVideoGetDataCallBack.onSuccessDetailVideo(pojoVideo.getVideos(), "Ok");
            }
          } catch (Exception e) {

          }
        }, error -> detailVideoGetDataCallBack.onError(String.valueOf(error))) {
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
