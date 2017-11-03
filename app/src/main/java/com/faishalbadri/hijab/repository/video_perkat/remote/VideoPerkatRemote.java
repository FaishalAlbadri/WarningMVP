package com.faishalbadri.hijab.repository.video_perkat.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.data.PojoVideoPerkat;
import com.faishalbadri.hijab.repository.video_perkat.VideoPerkatDataResource;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public class VideoPerkatRemote implements VideoPerkatDataResource{

  private Context context;
  private static final String URL_EBOOK = Server.BASE_URL+"getTbVideoPerKategori.php";

  public VideoPerkatRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getAccountResult(String id, @NonNull VideoPerkatGetDataCallBack videoPerkatGetDataCallBack) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.POST, String.valueOf(URL_EBOOK),
        response -> {
          final PojoVideoPerkat pojoVideoPerkat = new Gson().fromJson(response, PojoVideoPerkat.class);
          Log.i("response", response);
          if (pojoVideoPerkat == null) {
            videoPerkatGetDataCallBack.onError("Internal Server error");
          } else {
            videoPerkatGetDataCallBack.onSuccessVideoPerkat(pojoVideoPerkat.getVideo(), "Data Semua Ebook");
            Log.i(pojoVideoPerkat.getVideo().toString(), "Data Semua Ebook");
          }
        }, error -> videoPerkatGetDataCallBack.onError(String.valueOf(error))) {
      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<>();
        params.put("id_kategori", id);
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }
}
