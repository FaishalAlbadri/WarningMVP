package com.faishalbadri.hijab.repository.register.remote;

import android.content.Context;
import android.support.annotation.NonNull;
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

  Context context;
  private static final String URL = Server.BASE_URL + "register.php";

  public RegisterDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getRegisterResult(final String username, final String email, final String password,
      @NonNull final RegisterGetCallback registerGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(
        Method.POST, String.valueOf(URL), new Listener<String>() {
      @Override
      public void onResponse(String response) {
        try {
          if (String.valueOf(new JSONObject(response).getString("msg")).equals("Register berhasil, silakan login")) {
            try {
              registerGetCallback.onSuccesRegister(context.getString(R.string.text_succes));
            } catch (Exception e) {
              e.printStackTrace();
            }
          } else {
            Toast.makeText(context, "Masukkan data yang valid\nNama atau Email Sudah Terpakai", Toast.LENGTH_SHORT).show();
            registerGetCallback.onWrongRegister(context.getString(R.string.text_error));
          }
        } catch (JSONException e) {

        } catch (Exception e) {

        }

      }
    }, new ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        registerGetCallback.onErrorRegister(String.valueOf(error));
      }
    }) {
      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        params.put("email", email);
        params.put("password", password);
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }
}
