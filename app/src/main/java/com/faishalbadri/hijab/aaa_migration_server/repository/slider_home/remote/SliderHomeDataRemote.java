package com.faishalbadri.hijab.aaa_migration_server.repository.slider_home.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoSlider;
import com.faishalbadri.hijab.aaa_migration_server.repository.slider_home.SliderHomeDataResource;
import com.faishalbadri.hijab.aaa_migration_server.util.ApiKey;
import com.faishalbadri.hijab.aaa_migration_server.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faishal on 20/12/17.
 */

public class SliderHomeDataRemote implements SliderHomeDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "slider";
  Context context;

  public SliderHomeDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getSliderHomeResult(@NonNull SliderHomeGetCallback sliderHomeGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL),
        response -> {
          Log.i("response", response);
          final PojoSlider pojoSlider = new Gson().fromJson(response, PojoSlider.class);
          try {
            if (pojoSlider == null) {
              sliderHomeGetCallback.onErrorSliderHome("Error");
            } else {
              sliderHomeGetCallback
                  .onSuccesSliderHome(pojoSlider.getSlider(), "Ok");
            }
          } catch (Exception e) {

          }
        }, error -> sliderHomeGetCallback.onErrorSliderHome(String.valueOf(error))) {
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
