package com.faishalbadri.hijab.repository.event.remote;

import static java.lang.String.valueOf;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoCategory;
import com.faishalbadri.hijab.data.PojoEvent;
import com.faishalbadri.hijab.repository.event.EventDataResource;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by faishal on 11/6/17.
 */

public class EventDataRemote implements EventDataResource {

  Context context;
  private static final String URL = Server.BASE_URL + "getTbEvent.php";

  public EventDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getEventResult(@NonNull EventGetCallback eventGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.GET, valueOf(URL), new Listener<String>() {
      @Override
      public void onResponse(String response) {
        try {
          if (valueOf(new JSONObject(response).getString("msg")).equals("Data Semua Event")) {
            try {
              PojoEvent pojoEvent = new Gson().fromJson(response,PojoEvent.class);
              eventGetCallback.onSuccesEvent(pojoEvent.getEvent(),context.getString(R.string.text_succes));
            } catch (Exception e) {
              e.printStackTrace();
            }
          } else {
            eventGetCallback.onErrorEvent(context.getString(R.string.text_error));
          }
        } catch (JSONException e) {

        } catch (Exception e) {

        }

      }
    }, new ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        eventGetCallback.onErrorEvent(valueOf(error));
      }
    });
    requestQueue.add(stringRequest);
  }
}
