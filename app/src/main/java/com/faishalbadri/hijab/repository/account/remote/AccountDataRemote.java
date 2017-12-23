package com.faishalbadri.hijab.repository.account.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.data.PojoUser;
import com.faishalbadri.hijab.repository.account.AccountDataResource;
import com.faishalbadri.hijab.util.server.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import net.gotev.uploadservice.MultipartUploadRequest;

/**
 * Created by fikriimaduddin on 10/30/17.
 */

public class AccountDataRemote implements AccountDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "loginuser";
  private static final String URL_EDIT_IMAGE = Server.BASE_URL_REVAMP + "user/upload";
  Context context;

  public AccountDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getAccountResult(String username, String password,
      @NonNull AccountGetCallback accountGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.POST, String.valueOf(URL),
        response -> {
          Log.i("response", response);
          final PojoUser pojoUser = new Gson().fromJson(response, PojoUser.class);
          try {
            if (pojoUser == null) {
              accountGetCallback.onError("Email atau Password salah");
            } else {
              for (int a = 0; a < pojoUser.getUser().size(); a++) {
                String id_user = pojoUser.getUser().get(a).getUser_id();
                String user_name = pojoUser.getUser().get(a).getUser_name();
                String user_email = pojoUser.getUser().get(a).getUser_email();
                String user_handphone_number = pojoUser.getUser().get(a).getUser_handphone_number();
                String user_image = pojoUser.getUser().get(a).getUser_image();
                String user_password = pojoUser.getUser().get(a).getUser_password();
                String user_verify_code = pojoUser.getUser().get(a).getUser_verify_code();
                String user_verified_code = pojoUser.getUser().get(a).getUser_verified_code();
                String user_gender = pojoUser.getUser().get(a).getUser_gender();
                String user_apikey = pojoUser.getUser().get(a).getUser_apikey();
                accountGetCallback.onSucces("Ok", id_user, user_name, user_email,
                    user_handphone_number, user_image, user_password, user_verify_code,
                    user_verified_code, user_gender, user_apikey);
              }
            }
          } catch (Exception e) {

          }
        }, error -> accountGetCallback.onError(String.valueOf(error))) {

      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        params.put("password", password);
        return params;
      }

    };
    requestQueue.add(stringRequest);
  }


  @Override
  public void getEditImageResult(String id, String path,
      @NonNull final EditImageGetCallback editImageGetCallback) {
    try {
      String uploadId = UUID.randomUUID().toString();
      new MultipartUploadRequest(context, uploadId, URL_EDIT_IMAGE)
          .addFileToUpload(path, "user_image")
          .addParameter("user_id", id)
          .setMaxRetries(2)
          .startUpload();
    } catch (Exception ignored) {

    }
  }
}
