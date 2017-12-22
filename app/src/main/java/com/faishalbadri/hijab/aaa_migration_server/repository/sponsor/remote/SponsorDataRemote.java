package com.faishalbadri.hijab.aaa_migration_server.repository.sponsor.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoSponsor;
import com.faishalbadri.hijab.aaa_migration_server.repository.sponsor.SponsorDataResource;
import com.faishalbadri.hijab.aaa_migration_server.util.ApiKey;
import com.faishalbadri.hijab.aaa_migration_server.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faishal on 15/11/17.
 */

public class SponsorDataRemote implements SponsorDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "sponsor";
  Context context;


  public SponsorDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getSponsorResult(@NonNull SponsorGetCallback sponsorGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL),
        response -> {
          Log.i("response", response);
          final PojoSponsor pojoSponsor = new Gson().fromJson(response, PojoSponsor.class);
          try {
            if (pojoSponsor == null) {
              sponsorGetCallback.onErrorSponsor("Error");
            } else {
              sponsorGetCallback
                  .onSuccesSponsor(pojoSponsor.getSponsor(), "Ok");
            }
          } catch (Exception e) {

          }
        }, error -> sponsorGetCallback.onErrorSponsor(String.valueOf(error))) {
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
