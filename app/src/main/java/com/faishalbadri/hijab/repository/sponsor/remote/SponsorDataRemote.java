package com.faishalbadri.hijab.repository.sponsor.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.data.PojoSponsor;
import com.faishalbadri.hijab.repository.sponsor.SponsorDataResource;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by faishal on 15/11/17.
 */

public class SponsorDataRemote implements SponsorDataResource {

  private static final String URL = Server.BASE_URL + "getTbSponsored.php";
  Context context;


  public SponsorDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getSponsorResult(@NonNull SponsorGetCallback sponsorGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Request.Method.GET, String.valueOf(URL),
        response -> {
          try {
            if (String.valueOf(new JSONObject(response).getString("msg"))
                .equals("Data Semua sponsor")) {
              Log.i("response", response);
              try {
                final PojoSponsor pojoSponsor = new Gson().fromJson(response, PojoSponsor.class);
                sponsorGetCallback.onSuccesSponsor(pojoSponsor.getSponsor(), "Success");
              } catch (Exception e) {

              }
            } else {
              sponsorGetCallback.onErrorSponsor("Error");
            }
          } catch (JSONException e) {
          }
        }, error -> sponsorGetCallback.onErrorSponsor(String.valueOf(error)));

    requestQueue.add(stringRequest);
  }
}
