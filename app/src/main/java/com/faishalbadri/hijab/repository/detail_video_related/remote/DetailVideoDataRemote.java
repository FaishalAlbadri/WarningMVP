package com.faishalbadri.hijab.repository.detail_video_related.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.data.PojoVideo;
import com.faishalbadri.hijab.repository.detail_video_related.DetailVideoDataResource;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by fikriimaduddin on 11/6/17.
 */

public class DetailVideoDataRemote implements DetailVideoDataResource {

  private static final String URL_VIDEO = Server.BASE_URL + "getVideoLimit.php";
  private Context context;

  public DetailVideoDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getDetailVideo(@NonNull DetailVideoGetDataCallBack detailVideoGetDataCallBack) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Request.Method.GET, String.valueOf(URL_VIDEO),
        response -> {
          try {
            if (String.valueOf(new JSONObject(response).getString("msg"))
                .equals("Data Semua Video")) {
              try {
                final PojoVideo pojoVideo = new Gson().fromJson(response, PojoVideo.class);
                detailVideoGetDataCallBack.onSuccessDetailVideo(pojoVideo.getVideo(), "Success");
              } catch (Exception e) {
                e.printStackTrace();
              }
            }
          } catch (JSONException e) {
          }
        }
        , error -> detailVideoGetDataCallBack.onError(String.valueOf(error)));
    requestQueue.add(stringRequest);
  }
}
