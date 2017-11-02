package com.faishalbadri.hijab.repository.account.remote;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.data.PojoUser;
import com.faishalbadri.hijab.repository.account.AccountDataResource;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;

/**
 * Created by fikriimaduddin on 10/30/17.
 */

public class AccountDataRemote implements AccountDataResource{

  Context context;
  private static final String URL = Server.BASE_URL+ "getUser.php";
  private static final String URL_EDIT_IMAGE = Server.BASE_URL+ "uploadimage.php";

  public AccountDataRemote(Context context) {
    this.context = context;
  }


  @Override
  public void getAccountResult(final String email, @NonNull final AccountGetCallback accountGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.POST, String.valueOf(URL), response -> {
      final PojoUser pojoUser = new Gson().fromJson(response, PojoUser.class);
      if (pojoUser == null) {
        accountGetCallback.onError("No Account");
      } else {
        for (int a = 0; a < pojoUser.getUser().size(); a++) {
          String id = pojoUser.getUser().get(a).getId_user();
          String username = pojoUser.getUser().get(a).getUsername();
          String image = pojoUser.getUser().get(a).getImg_user();
          accountGetCallback.onSucces(pojoUser.getUser(), username, image, id);
        }
      }
    }, error -> accountGetCallback.onError(String.valueOf(error))) {
      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }

  @Override
  public void getEditImageResult(String id,String path, @NonNull final EditImageGetCallback editImageGetCallback) {
    try {
      String uploadId = UUID.randomUUID().toString();
      new MultipartUploadRequest(context, uploadId, URL_EDIT_IMAGE)
          .addFileToUpload(path, "image")
          .addParameter("id", id)
          .setNotificationConfig(new UploadNotificationConfig())
          .setMaxRetries(2)
          .startUpload();
    } catch (Exception ignored) {

    }
  }
}
