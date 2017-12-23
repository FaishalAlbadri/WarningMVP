package com.faishalbadri.hijab.repository.video_by_category.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.data.PojoVideo;
import com.faishalbadri.hijab.repository.video_by_category.VideoByCategoryDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import com.faishalbadri.hijab.util.server.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public class VideoByCategoryRemote implements VideoByCategoryDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "videos/";
  private Context context;

  public VideoByCategoryRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getVideoByCategoryGetDataCallBack(String id,
      @NonNull VideoByCategoryGetDataCallBack videoByCategoryGetDataCallBack) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL + id),
        response -> {
          Log.i("response", response);
          final PojoVideo pojoVideo = new Gson().fromJson(response, PojoVideo.class);
          try {
            if (pojoVideo == null) {
              videoByCategoryGetDataCallBack.onErrorVideoByCategory("Error");
            } else {
              videoByCategoryGetDataCallBack.onSuccessVideoByCategory(pojoVideo.getVideos(), "Ok");
            }
          } catch (Exception e) {

          }
        }, error -> videoByCategoryGetDataCallBack.onErrorVideoByCategory(String.valueOf(error))) {
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
