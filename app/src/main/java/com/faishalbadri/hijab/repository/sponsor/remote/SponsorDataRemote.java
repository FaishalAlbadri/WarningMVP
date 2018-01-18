package com.faishalbadri.hijab.repository.sponsor.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoSponsor;
import com.faishalbadri.hijab.repository.sponsor.SponsorDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import com.faishalbadri.hijab.util.server.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faishal on 15/11/17.
 */

public class SponsorDataRemote implements SponsorDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "sponsor";
  private Context context;
  private RequestQueue requestQueue;


  public SponsorDataRemote(Context context) {
    this.context = context;
    requestQueue = Volley.newRequestQueue(context);
  }

  @Override
  public void getSponsorResult(@NonNull SponsorGetCallback sponsorGetCallback) {
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL),
        response -> {
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
        }, error -> sponsorGetCallback.onErrorSponsor(context.getResources().getString(R
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
