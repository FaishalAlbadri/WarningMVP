package com.faishalbadri.hijab.aaa_migration_server.repository.city_event.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoCityEvent;
import com.faishalbadri.hijab.aaa_migration_server.repository.city_event.EventCityDataResource;
import com.faishalbadri.hijab.aaa_migration_server.util.ApiKey;
import com.faishalbadri.hijab.aaa_migration_server.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faishal on 11/6/17.
 */

public class EventCityDataRemote implements EventCityDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "event_city";
  Context context;

  public EventCityDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getEventCityResult(@NonNull EventCityGetCallback eventCityGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL),
        response -> {
          Log.i("response", response);
          final PojoCityEvent pojoCityEvent = new Gson().fromJson(response, PojoCityEvent.class);
          try {
            if (pojoCityEvent == null) {
              eventCityGetCallback.onErrorEventCity("Error");
            } else {
              eventCityGetCallback.onSuccesEventCity(pojoCityEvent.getEvent_city(), "Ok");
            }
          } catch (Exception e) {

          }
        }, error -> eventCityGetCallback.onErrorEventCity(String.valueOf(error))) {
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
