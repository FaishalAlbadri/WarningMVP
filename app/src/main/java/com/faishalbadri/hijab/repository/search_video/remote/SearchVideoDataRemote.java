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
import com.faishalbadri.hijab.revamp.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchVideoDataRemote implements SearchVideoDataResource {

  private static final String URL = Server.BASE_URL + "searchVideo.php";
  Context context;

  public SearchVideoDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getSearchVideoResult(String key,
      @NonNull SearchVideoGetCallback searchVideoGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.POST, String.valueOf(URL), response -> {
      try {
        if (String.valueOf(new JSONObject(response).getString("msg")).equals("Data Semua Search")) {
          try {
            PojoVideo pojoVideo = new Gson().fromJson(response, PojoVideo.class);
            searchVideoGetCallback
                .onSuccesSearchVideo(pojoVideo.getVideo(), context.getString(R.string.text_succes));
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else {
          searchVideoGetCallback.onWrongSearchVideo(context.getString(R.string.text_error));
        }
      } catch (JSONException e) {

      } catch (Exception e) {

      }

    }, error -> searchVideoGetCallback.onErrorSearchVideo(String.valueOf(error))) {
      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<>();
        params.put("key", key);
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }
}
