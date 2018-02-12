package com.faishalbadri.hijab.repository.event.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoEvent;
import com.faishalbadri.hijab.repository.event.EventDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import com.faishalbadri.hijab.util.server.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faishal on 11/6/17.
 */

public class EventDataRemote implements EventDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "event?page=";
  private Context context;
  private RequestQueue requestQueue;


  public EventDataRemote(Context context) {
    this.context = context;
    requestQueue = Volley.newRequestQueue(context);
  }

  @Override
  public void getEventResult(int PAGE, @NonNull EventGetCallback eventGetCallback) {
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL + PAGE),
        response -> {
          final PojoEvent pojoEvent = new Gson()
              .fromJson(response, PojoEvent.class);
          try {
            if (pojoEvent.getEvent().toString().equals("[]")) {
              eventGetCallback.onErrorEvent("Data Null");
            } else {
              eventGetCallback
                  .onSuccesEvent(pojoEvent.getEvent(), "Ok");
            }
          } catch (Exception e) {

          }
        }, error -> eventGetCallback
        .onErrorEvent(context.getResources().getString(R.string.caption_error_internet_acces))) {
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
