package com.faishalbadri.hijab.repository.slider_home.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoSlider;
import com.faishalbadri.hijab.repository.slider_home.SliderHomeDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import com.faishalbadri.hijab.util.server.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faishal on 20/12/17.
 */

public class SliderHomeDataRemote implements SliderHomeDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "slider";
  private Context context;
  private RequestQueue requestQueue;

  public SliderHomeDataRemote(Context context) {
    this.context = context;
    requestQueue = Volley.newRequestQueue(context);
  }

  @Override
  public void getSliderHomeResult(@NonNull SliderHomeGetCallback sliderHomeGetCallback) {
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL),
        response -> {
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
        }, error -> sliderHomeGetCallback.onErrorSliderHome(context.getResources().getString(R
        .string.caption_error_internet_acces))) {
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
