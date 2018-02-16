package com.faishalbadri.hijab.repository.video.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoVideo;
import com.faishalbadri.hijab.repository.video.VideoDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import com.faishalbadri.hijab.util.server.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class VideoDataRemote implements VideoDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "videos?page=";
  private Context context;
  private RequestQueue requestQueue;

  public VideoDataRemote(Context context) {
    this.context = context;
    requestQueue = Volley.newRequestQueue(context);
  }

  @Override
  public void getVideoList(int PAGE, @NonNull VideoGetCallBack videoGetCallBack) {
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL + PAGE),
        response -> {
          final PojoVideo pojoVideo = new Gson().fromJson(response, PojoVideo.class);
          try {
            if (pojoVideo.getVideos().toString().equals("[]")) {
              videoGetCallBack.onErrorVideo("Data Null");
            } else {
              videoGetCallBack.onSuccessVideo(pojoVideo.getVideos(), "Ok");
            }
          } catch (Exception e) {

          }
        }, error -> {
      if (PAGE == 1) {
        videoGetCallBack
            .onErrorVideo(context.getResources().getString(R.string.caption_error_internet_acces));
      } else if (PAGE > 1) {
        videoGetCallBack.onErrorVideo("Data Pagination Error");
      }
    }) {
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
