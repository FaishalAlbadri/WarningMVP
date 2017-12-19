package com.faishalbadri.hijab.revamp.repository.event.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.revamp.data.PojoEvent;
import com.faishalbadri.hijab.revamp.repository.event.EventDataResource;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faishal on 11/6/17.
 */

public class EventDataRemote implements EventDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "event";
  Context context;

  public EventDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getEventResult(@NonNull EventGetCallback eventGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL),
        response -> {
          Log.i("response", response);
          final PojoEvent pojoEvent = new Gson()
              .fromJson(response, PojoEvent.class);
          try {
            if (pojoEvent == null) {
              eventGetCallback.onErrorEvent("Error");
            } else {
              eventGetCallback
                  .onSuccesEvent(pojoEvent.getEvent(), "Ok");
            }
          } catch (Exception e) {

          }
        }, error -> eventGetCallback.onErrorEvent(String.valueOf(error))) {
      @Override
      public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Authorization", "57b44757920f9b2544cd57f1d998e7f7");
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }
}
