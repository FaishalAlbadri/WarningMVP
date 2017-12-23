package com.faishalbadri.hijab.repository.voting.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.data.PojoVoting;
import com.faishalbadri.hijab.repository.voting.VotingDataResource;
import com.faishalbadri.hijab.util.ApiKey;
import com.faishalbadri.hijab.util.server.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faishal on 11/2/17.
 */

public class VotingDataRemote implements VotingDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "voting";
  Context context;


  public VotingDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getVotingResult(@NonNull VotingGetCallback votingGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL),
        response -> {
          final PojoVoting pojoVoting = new Gson().fromJson(response, PojoVoting.class);
          try {
            if (pojoVoting == null) {
              votingGetCallback.onDataVotingNull("Data Voting Null");
            } else {
              votingGetCallback.onSuccesVoting(pojoVoting.getVoting(), "Succes");
              Log.i("response", response);
            }
          } catch (Exception e) {

          }
        }, error -> votingGetCallback.onErrorVoting(String.valueOf(error))){
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
