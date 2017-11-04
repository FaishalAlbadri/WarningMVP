package com.faishalbadri.hijab.repository.video.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.data.PojoVideo;
import com.faishalbadri.hijab.repository.video.VideoDataResource;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class VideoDataRemote implements VideoDataResource {

  private Context context;
  private static final String URL_CATEGORY_VIDEO = Server.BASE_URL+"getVideo.php";

  public VideoDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getVideoList(@NonNull VideoGetCallBack videoGetCallBack) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Request.Method.GET, String.valueOf(URL_CATEGORY_VIDEO),
        response -> {
          try {
            if (String.valueOf(new JSONObject(response).getString("msg")).equals("Data Semua Video")) {
              try {
                final PojoVideo pojoVideo = new Gson().fromJson(response, PojoVideo.class);
                videoGetCallBack.onSuccessVideo(pojoVideo.getVideo(), "Success");
              } catch (Exception e) {
                e.printStackTrace();
              }
            }
          } catch (JSONException e) {
          }
        }
        , error -> videoGetCallBack.onErrorVideo(String.valueOf(error)));
    requestQueue.add(stringRequest);
  }
}
