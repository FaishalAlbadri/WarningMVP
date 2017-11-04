package com.faishalbadri.hijab.repository.video_perkat.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoVideoPerkat;
import com.faishalbadri.hijab.repository.video_perkat.VideoPerkatDataResource;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public class VideoPerkatRemote implements VideoPerkatDataResource{

  private Context context;
  private static final String URL_VIDEO_PERKAT = Server.BASE_URL+"getTbVideoPerKategori.php";

  public VideoPerkatRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getAccountResult(String id, @NonNull VideoPerkatGetDataCallBack videoPerkatGetDataCallBack) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(
        Method.POST, String.valueOf(URL_VIDEO_PERKAT), response -> {
      try {
        if (String.valueOf(new JSONObject(response).getString("msg")).equals("Data Semua Video")) {
          try {
            Log.i("Response",response);
            PojoVideoPerkat pojoVideoPerkat = new Gson().fromJson(response,PojoVideoPerkat.class);
            videoPerkatGetDataCallBack.onSuccessVideoPerkat(pojoVideoPerkat.getVideo(),context.getString(
                R.string.text_succes));
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else {
          videoPerkatGetDataCallBack.onError(context.getString(R.string.text_error));
        }
      } catch (JSONException e) {

      } catch (Exception e) {

      }

    }, error -> videoPerkatGetDataCallBack.onError(String.valueOf(error)))
    {
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
