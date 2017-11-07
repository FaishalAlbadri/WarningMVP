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
import com.faishalbadri.hijab.data.PojoVideo;
import com.faishalbadri.hijab.repository.event_by_city.EventByCityDataResource;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by faishal on 11/6/17.
 */

public class EventByCityDataRemote implements EventByCityDataResource {

  private Context context;
  private static final String URL = Server.BASE_URL+"getTbEventPerCity.php";

  public EventByCityDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getEventByCityResult(String id_city_event,
      @NonNull EventByCityGetCallback eventByCityGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.POST, String.valueOf(URL), response -> {
      try {
        if (String.valueOf(new JSONObject(response).getString("msg")).equals("Data Semua Event")) {
          try {
            Log.i("Response",response);
            PojoEvent pojoEvent = new Gson().fromJson(response,PojoEvent.class);
            eventByCityGetCallback.onSuccesEventByCity(pojoEvent.getEvent(),context.getString(R.string.text_succes));
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else {
          eventByCityGetCallback.onErrorEventByCity(context.getString(R.string.text_error));
        }
      } catch (JSONException e) {

      } catch (Exception e) {

      }

    }, error -> eventByCityGetCallback.onErrorEventByCity(String.valueOf(error)))
    {
      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<>();
        params.put("id_city_event", id_city_event);
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }
}