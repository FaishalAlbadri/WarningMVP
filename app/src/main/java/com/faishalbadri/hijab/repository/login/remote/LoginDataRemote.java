package com.faishalbadri.hijab.repository.login.remote;

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
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoUser;
import com.faishalbadri.hijab.repository.login.LoginDataResource;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by faishal on 10/30/17.
 */

public class LoginDataRemote implements LoginDataResource {

  private static final String URL = Server.BASE_URL + "login.php";
  Context context;

  public LoginDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getLoginResult(final String email, final String password,
      @NonNull final LoginGetCallback loginGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(
        Method.POST, String.valueOf(URL), new Listener<String>() {
      @Override
      public void onResponse(String response) {
        Log.i("response", response);
        try {
          if (String.valueOf(new JSONObject(response).getString("msg")).equals("login berhasil")) {
            try {
              final PojoUser pojoUser = new Gson().fromJson(response, PojoUser.class);
              for (int a = 0; a < pojoUser.getUser().size(); a++) {
                String id = pojoUser.getUser().get(a).getId_user();
                String username = pojoUser.getUser().get(a).getUsername();
                String image = pojoUser.getUser().get(a).getImg_user();
                loginGetCallback
                    .onSuccesLogin(context.getString(R.string.text_succes), id, username, image);
              }
            } catch (Exception e) {
              e.printStackTrace();
            }
          } else {
            Toast.makeText(context, "Wrong Email or Password", Toast.LENGTH_SHORT).show();
            loginGetCallback.onWrongLogin(context.getString(R.string.text_wrong_login));
          }
        } catch (JSONException e) {

        } catch (Exception e) {

        }

      }
    }, new ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        loginGetCallback.onErrorLogin(String.valueOf(error));
      }
    }) {
      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("email", email);
        params.put("password", password);
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }
}
