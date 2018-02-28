package com.faishalbadri.hijab.repository.change.password.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.faishalbadri.hijab.api.APIClient;
import com.faishalbadri.hijab.api.APIInterface;
import com.faishalbadri.hijab.data.response.GlobalResponse;
import com.faishalbadri.hijab.repository.change.password.PasswordDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by faishal on 06/02/18.
 */

public class PasswordDataRemote implements PasswordDataResource {

  private Context context;

  public PasswordDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getPasswordResult(String password, @NonNull PasswordGetCallback passwordGetCallback) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<GlobalResponse> responsechangePasswordCall = apiInterface
        .changePasswordUser(DataUser.getInstance().getUserId(), password);
    responsechangePasswordCall.enqueue(new Callback<GlobalResponse>() {
      @Override
      public void onResponse(Call<GlobalResponse> call, Response<GlobalResponse> response) {
        try {
          if (response.body().getMessage().equals("You're successfully update your password")) {
            passwordGetCallback.onResponse("succes");
          } else {
            passwordGetCallback.onResponse("Error");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<GlobalResponse> call, Throwable t) {
        passwordGetCallback.onResponse("Tidak ada koneksi internet");
      }
    });
  }
}
