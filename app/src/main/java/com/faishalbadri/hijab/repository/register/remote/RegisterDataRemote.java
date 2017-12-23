package com.faishalbadri.hijab.repository.register.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.repository.register.RegisterDataResource;
import com.faishalbadri.hijab.util.Server;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by faishal on 10/30/17.
 */

public class RegisterDataRemote implements RegisterDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "user/new";
  Context context;

  public RegisterDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getRegisterResult(final String username, final String email, final String password,
      final String verify_code, @NonNull final RegisterGetCallback registerGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(
        Method.POST, String.valueOf(URL), new Listener<String>() {
      @Override
      public void onResponse(String response) {
        try {
          if (String.valueOf(new JSONObject(response).getString("message"))
              .equals("You're successfully registered")) {
            try {
              registerGetCallback.onSuccesRegister(context.getString(R.string.text_succes));
            } catch (Exception e) {
              e.printStackTrace();
            }
          } else {
            Toast.makeText(context, "Masukkan data yang valid\nNama atau Email Sudah Terpakai",
                Toast.LENGTH_SHORT).show();
            registerGetCallback.onWrongRegister(context.getString(R.string.text_error));
          }
        } catch (JSONException e) {

        } catch (Exception e) {

        }

      }
    }, error -> {
      registerGetCallback.onErrorRegister(String.valueOf(error));
    }) {
      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        params.put("email", email);
        params.put("password", password);
        params.put("verify_code", verify_code);
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }
}
