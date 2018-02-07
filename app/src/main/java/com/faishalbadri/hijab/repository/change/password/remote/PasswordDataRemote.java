package com.faishalbadri.hijab.repository.change.password.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.repository.change.password.PasswordDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import com.faishalbadri.hijab.util.server.Server;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faishal on 06/02/18.
 */

public class PasswordDataRemote implements PasswordDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "user/change/password";
  private Context context;
  private RequestQueue requestQueue;

  public PasswordDataRemote(Context context) {
    this.context = context;
    requestQueue = Volley.newRequestQueue(context);
  }

  @Override
  public void getPasswordResult(String password, @NonNull PasswordGetCallback passwordGetCallback) {
    StringRequest stringRequest = new StringRequest(Method.POST, String.valueOf(URL), response -> {
      try {
        passwordGetCallback.onResponse("succes");
      } catch (Exception e) {

      }
    }, error -> passwordGetCallback.onResponse(String.valueOf(error))) {

      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("user_id", DataUser.getInstance().getUserId());
        params.put("password", password);
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }
}
