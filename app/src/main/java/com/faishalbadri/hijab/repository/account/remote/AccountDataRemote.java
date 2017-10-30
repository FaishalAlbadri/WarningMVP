package com.faishalbadri.hijab.repository.account.remote;

import android.content.Context;
import android.media.MediaSync;
import android.media.MediaSync.OnErrorListener;
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
import com.faishalbadri.hijab.repository.account.AccountDataResource;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by fikriimaduddin on 10/30/17.
 */

public class AccountDataRemote implements AccountDataResource{

  Context context;
  private static final String URL = Server.BASE_URL+ "getUser.php";

  public AccountDataRemote(Context context) {
    this.context = context;
  }


  @Override
  public void getAccountResult(final String email, @NonNull final AccountGetCallback accountGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.POST, String.valueOf(URL), new Listener<String>() {
      @Override
      public void onResponse(String response) {
        final PojoUser pojoUser = new Gson().fromJson(response, PojoUser.class);
        Log.i("response", response);
        if (pojoUser == null) {
          accountGetCallback.onError("No Account");
        } else {
          for (int a = 0; a < pojoUser.getUser().size(); a++) {
            String username = pojoUser.getUser().get(a).getUsername();
            String image = pojoUser.getUser().get(a).getImg_user();
            accountGetCallback.onSucces(pojoUser.getUser(), username, image);
          }
        }
      }
    }, new ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
          accountGetCallback.onError(String.valueOf(error));
        }
    }) {
      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }
}
