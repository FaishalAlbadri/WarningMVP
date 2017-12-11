package com.faishalbadri.hijab.repository.city_event.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoCityEvent;
import com.faishalbadri.hijab.repository.city_event.EventCityDataResource;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by faishal on 11/6/17.
 */

public class EventCityDataRemote implements EventCityDataResource {

  private static final String URL = Server.BASE_URL + "getTbCityEvent.php";
  Context context;

  public EventCityDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getEventCityResult(@NonNull EventCityGetCallback eventCityGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(
        Method.GET, String.valueOf(URL), new Listener<String>() {
      @Override
      public void onResponse(String response) {
        try {
          if (String.valueOf(new JSONObject(response).getString("msg"))
              .equals("Data Semua city Event")) {
            try {
              PojoCityEvent pojoCityEvent = new Gson().fromJson(response, PojoCityEvent.class);
              eventCityGetCallback.onSuccesEventCity(pojoCityEvent.getCity_event(),
                  context.getString(R.string.text_succes));
            } catch (Exception e) {
              e.printStackTrace();
            }
          } else {
            eventCityGetCallback.onErrorEventCity(context.getString(R.string.text_error));
          }
        } catch (JSONException e) {

        } catch (Exception e) {

        }

      }
    }, new ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        eventCityGetCallback.onErrorEventCity(String.valueOf(error));
      }
    });
    requestQueue.add(stringRequest);
  }
}
