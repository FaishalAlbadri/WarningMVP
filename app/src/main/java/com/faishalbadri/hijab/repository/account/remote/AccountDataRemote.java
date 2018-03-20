package com.faishalbadri.hijab.repository.account.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.faishalbadri.hijab.api.APIClient;
import com.faishalbadri.hijab.api.APIInterface;
import com.faishalbadri.hijab.data.user.UserItem;
import com.faishalbadri.hijab.data.user.UserResponse;
import com.faishalbadri.hijab.repository.account.AccountDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import com.faishalbadri.hijab.util.server.Server;
import java.util.List;
import java.util.UUID;
import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fikriimaduddin on 10/30/17.
 */

public class AccountDataRemote implements AccountDataResource {

  private static final String URL_EDIT_IMAGE = Server.BASE_URL_REVAMP + "user/upload";
  private Context context;

  public AccountDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getAccountResult(@NonNull AccountGetCallback accountGetCallback) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<UserResponse> userResponseCall = apiInterface
        .getLogin(DataUser.getInstance().getUserName(), DataUser.getInstance().getUserPassword());
    userResponseCall.enqueue(new Callback<UserResponse>() {
      @Override
      public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
        try {
          if (response.body().getMessage().equals("Invalid username or password")) {
            accountGetCallback.onError("Email atau Kata sandi salah");
          } else {
            UserResponse userResponse = response.body();
            List<UserItem> items = userResponse.getUser();
            for (int a = 0; a < items.size(); a++) {
              String id_user = items.get(a).getUserId();
              String user_name = items.get(a).getUserName();
              String user_email = items.get(a).getUserEmail();
              String user_handphone_number = items.get(a).getUserHandphoneNumber();
              String user_image = items.get(a).getUserImage();
              String user_password = items.get(a).getUserPassword();
              String user_verify_code = items.get(a).getUserVerifyCode();
              String user_verified_code = items.get(a).getUserVerifiedCode();
              String user_gender = items.get(a).getUserGender();
              String user_apikey = items.get(a).getUserApikey();
              accountGetCallback.onSucces("Ok", id_user, user_name, user_email,
                  user_handphone_number, user_image, user_password, user_verify_code,
                  user_verified_code, user_gender, user_apikey);
            }
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<UserResponse> call, Throwable t) {
        accountGetCallback.onError("error");
      }
    });
  }


  @Override
  public void getEditImageResult(String path,
      @NonNull final EditImageGetCallback editImageGetCallback) {
    try {
      String uploadId = UUID.randomUUID().toString();
      new MultipartUploadRequest(context, uploadId, URL_EDIT_IMAGE)
          .addFileToUpload(path, "user_image")
          .addParameter("user_id", DataUser.getInstance().getUserId())
          .setNotificationConfig(new UploadNotificationConfig())
          .setMaxRetries(2)
          .startUpload();
    } catch (Exception ignored) {

    }
  }
}
