package com.faishalbadri.hijab.repository.verify_code.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.repository.verify_code.VerifyCodeDataResource;
import com.faishalbadri.hijab.util.Server;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faishal on 23/12/17.
 */

public class VerifyCodeDataRemote implements VerifyCodeDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "verifycode";
  Context context;

  public VerifyCodeDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getVerifyCodeResult(String user_id, String verify_code,
      @NonNull VerifyCodeGetCallback verifyCodeGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.POST, String.valueOf(URL), response -> {
      try {
        verifyCodeGetCallback.onSuccesVerifyCode("succes");
      } catch (Exception e) {

      }
    }, error -> verifyCodeGetCallback.onErrorVerifyCode(String.valueOf(error))) {

      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("user_id", user_id);
        params.put("verify_code", verify_code);
        return params;
      }

    };
    requestQueue.add(stringRequest);
  }
}