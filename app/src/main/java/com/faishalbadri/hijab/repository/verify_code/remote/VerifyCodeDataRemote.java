package com.faishalbadri.hijab.repository.verify_code.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.repository.verify_code.VerifyCodeDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import com.faishalbadri.hijab.util.server.Server;
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
  public void getVerifyCodeResult(@NonNull VerifyCodeGetCallback verifyCodeGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.POST, String.valueOf(URL), response -> {
      Log.i("response", response);
      try {
        verifyCodeGetCallback.onSuccesVerifyCode("succes");
      } catch (Exception e) {

      }
    }, error -> verifyCodeGetCallback.onErrorVerifyCode(String.valueOf(error))) {

      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("user_id", DataUser.getInstance().getUserId());
        params.put("verify_code", DataUser.getInstance().getUserVerifyCode());
        return params;
      }

    };
    requestQueue.add(stringRequest);
  }
}