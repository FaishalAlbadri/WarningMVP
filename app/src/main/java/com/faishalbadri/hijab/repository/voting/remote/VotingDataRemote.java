package com.faishalbadri.hijab.repository.voting.remote;

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
import com.faishalbadri.hijab.data.PojoVoting;
import com.faishalbadri.hijab.repository.voting.VotingDataResource;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;

/**
 * Created by faishal on 11/2/17.
 */

public class VotingDataRemote implements VotingDataResource {

  private static final String URL = Server.BASE_URL + "getTbVoting.php";
  Context context;


  public VotingDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getVotingResult(@NonNull VotingGetCallback votingGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL),
        new Listener<String>() {
          @Override
          public void onResponse(String response) {
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
          }
        }, new ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        votingGetCallback.onErrorVoting(String.valueOf(error));
      }
    });
    requestQueue.add(stringRequest);
  }
}
