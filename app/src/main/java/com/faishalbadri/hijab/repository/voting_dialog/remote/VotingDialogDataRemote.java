package com.faishalbadri.hijab.repository.voting_dialog.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.data.PojoSession;
import com.faishalbadri.hijab.repository.voting_dialog.VotingDialogDataResource;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by faishal on 11/2/17.
 */

public class VotingDialogDataRemote implements VotingDialogDataResource {

  Context context;
  private String urlLike = Server.BASE_URL + "like.php";
  private String urlUnlike = Server.BASE_URL + "unlike.php";
  private String urlSession = Server.BASE_URL + "getTbSession.php";

  public VotingDialogDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getResulVotingDialogGetSession(String id_user, String id_voting,
      @NonNull VotingDialogGetSessionGetCallback votingDialogGetSessionGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.POST, String.valueOf(urlSession), new Listener<String>() {
          @Override
          public void onResponse(String response) {
            try {
              if (String.valueOf(new JSONObject(response).getString("msg")).equals("Data Semua Session")) {
                try {
                  PojoSession pojoSession = new Gson().fromJson(response,PojoSession.class);
                  Log.i("response",response);
                  for (int a = 0; a < pojoSession.getSession().size(); a++) {
                    String id_session = pojoSession.getSession().get(a).getId_session();
                    String status_session = pojoSession.getSession().get(a).getSession_status();
                    votingDialogGetSessionGetCallback.onSuccesVotingDialogGetSession("Succes",id_session,status_session);
                  }

                } catch (Exception e) {
                  e.printStackTrace();
                }
              } else {
                votingDialogGetSessionGetCallback.onSuccesVotingDialogGetSessionNull("Succes Null");
              }
            } catch (JSONException e) {

            } catch (Exception e) {

            }

          }
        }, new ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        Toast.makeText(context, "Check Your Internet Connection", Toast.LENGTH_SHORT).show();
        votingDialogGetSessionGetCallback.onErrorVotingDialogGetSession(String.valueOf(error));
      }
    }) {
      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id_user", id_user);
        params.put("id_voting", id_voting);
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }

  @Override
  public void getResulVotingDialogLike(String id_voting, String id_user,
      @NonNull VotingDialogLikeGetCallback votingDialogLikeGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.POST, String.valueOf(urlLike),
        new Listener<String>() {
          @Override
          public void onResponse(String response) {
            try {
              if (String.valueOf(new JSONObject(response).getString("msq")).equals("berhasil update voting") && String.valueOf(new JSONObject(response).getString("msq")).equals("berhasil update voting")) {
                try {
                  votingDialogLikeGetCallback.onSuccesVotingDialogLike("succes");
                } catch (Exception e) {
                  e.printStackTrace();
                }
              } else {
                votingDialogLikeGetCallback.onErrorVotingDialogLike("Failed");
              }
            } catch (JSONException e) {

            } catch (Exception e) {

            }

          }
        }, new ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        Toast.makeText(context, "Failed to like image", Toast.LENGTH_SHORT).show();
        votingDialogLikeGetCallback.onErrorVotingDialogLike(String.valueOf(error));
      }
    }) {
      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id_voting", id_voting);
        params.put("id_user", id_user);
        params.put("id_session", "");
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }

  @Override
  public void getResulVotingDialogUnlike(String id_voting, String id_session,
      @NonNull VotingDialogUnlikeGetCallback votingDialogUnlikeGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.POST, String.valueOf(urlUnlike),
        new Listener<String>() {
          @Override
          public void onResponse(String response) {
            try {
              if (String.valueOf(new JSONObject(response).getString("msq")).equals("berhasil delete voting") && String.valueOf(new JSONObject(response).getString("msq")).equals("berhasil update voting")) {
                try {
                  votingDialogUnlikeGetCallback.onSuccesVotingDialogUnlike("succes");
                } catch (Exception e) {
                  e.printStackTrace();
                }
              } else {
                votingDialogUnlikeGetCallback.onErrorVotingDialogUnlike("Failed");
              }
            } catch (JSONException e) {

            } catch (Exception e) {

            }

          }
        }, new ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        Toast.makeText(context, "Failed to unlike image", Toast.LENGTH_SHORT).show();
        votingDialogUnlikeGetCallback.onErrorVotingDialogUnlike(String.valueOf(error));
      }
    }) {
      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id_voting", id_voting);
        params.put("id_session", id_session);
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }
}
