package com.faishalbadri.hijab.repository.voting_dialog.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.data.PojoSession;
import com.faishalbadri.hijab.repository.voting_dialog.VotingDialogDataResource;
import com.faishalbadri.hijab.util.ApiKey;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faishal on 11/2/17.
 */

public class VotingDialogDataRemote implements VotingDialogDataResource {

  Context context;
  private String urlRate = Server.BASE_URL_REVAMP + "voting/vote";
  private String urlSession = Server.BASE_URL_REVAMP + "session";

  public VotingDialogDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getResulVotingDialogGetSession(String id_user, String id_voting,
      @NonNull VotingDialogGetSessionGetCallback votingDialogGetSessionGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.POST, String.valueOf(urlSession),
        response -> {
          votingDialogGetSessionGetCallback.onSuccesVotingDialogGetSessionNull("Null");
          Log.i("response session", response);
          final PojoSession pojoSession = new Gson().fromJson(response, PojoSession.class);
          try {
            if (pojoSession == null) {
              votingDialogGetSessionGetCallback.onSuccesVotingDialogGetSessionNull("Null");
            } else {
              for (int a = 0; a < pojoSession.getSession().size(); a++) {
                String id_session = pojoSession.getSession().get(a).getSession_id();
                String status_session = pojoSession.getSession().get(a).getSession_status();
                votingDialogGetSessionGetCallback
                    .onSuccesVotingDialogGetSession("Succes", id_session, status_session);
              }
            }
          } catch (Exception e) {

          }
        }, error -> votingDialogGetSessionGetCallback
        .onErrorVotingDialogGetSession(String.valueOf(error))) {

      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("user_id", id_user);
        params.put("voting_id", id_voting);
        return params;
      }

      @Override
      public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Authorization", ApiKey.getInstance(context).getApiKey());
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }

  @Override
  public void getResulVotingDialogVotingRate(String voting_id, String user_id, String type,
      String voting_session_id,
      @NonNull VotingDialogVotingRateGetCallback votingDialogVotingRateGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.POST, String.valueOf(urlRate),
        response -> {
      Log.i("response rate", response);
          try {
            votingDialogVotingRateGetCallback.onSuccesVotingDialogVotingRate("Ok");
          } catch (Exception e) {

          }
        }, error -> votingDialogVotingRateGetCallback
        .onErrorVotingDialogVotingRate(String.valueOf(error))) {

      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("user_id", user_id);
        params.put("voting_id", voting_id);
        params.put("type", type);
        params.put("voting_session_id", voting_session_id);
        return params;
      }

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
