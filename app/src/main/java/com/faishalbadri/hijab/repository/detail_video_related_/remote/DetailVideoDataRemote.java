package com.faishalbadri.hijab.repository.detail_video_related_.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.repository.detail_video_related_.DetailVideoDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import com.faishalbadri.hijab.util.server.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fikriimaduddin on 11/6/17.
 */

public class DetailVideoDataRemote implements DetailVideoDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "videos?limit=";
  private Context context;
  private RequestQueue requestQueue;

  public DetailVideoDataRemote(Context context) {
    this.context = context;
    requestQueue = Volley.newRequestQueue(context);
  }

  @Override
  public void getDetailVideo(String limit, @NonNull DetailVideoGetDataCallBack
      detailVideoGetDataCallBack) {
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL + limit),
        response -> {
          final PojoVideo pojoVideo = new Gson().fromJson(response, PojoVideo.class);
          try {
            if (pojoVideo.getVideos().toString().equals("[]")) {
              detailVideoGetDataCallBack.onError("Error");
            } else {
              detailVideoGetDataCallBack.onSuccessDetailVideo(pojoVideo.getVideos(), "Ok");
            }
          } catch (Exception e) {

          }
        }, error -> detailVideoGetDataCallBack
        .onError(context.getResources().getString(R.string.caption_error_internet_acces))) {
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
