package com.faishalbadri.hijab.repository.event_by_city.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoEvent;
import com.faishalbadri.hijab.repository.event_by_city.EventByCityDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import com.faishalbadri.hijab.util.server.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faishal on 11/6/17.
 */

public class EventByCityDataRemote implements EventByCityDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "event/";
  private Context context;


  public EventByCityDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getEventByCityResult(String id_city_event,
      @NonNull EventByCityGetCallback eventByCityGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL + id_city_event),
        response -> {
          Log.i("response", response);
          final PojoEvent pojoEvent = new Gson().fromJson(response, PojoEvent.class);
          try {
            if (pojoEvent == null) {
              eventByCityGetCallback.onErrorEventByCity("Error");
            } else {
              eventByCityGetCallback.onSuccesEventByCity(pojoEvent.getEvent(), "Ok");
            }
          } catch (Exception e) {

          }
        }, error -> eventByCityGetCallback.onErrorEventByCity(
        context.getResources().getString(R.string.caption_error_internet_acces))) {
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
