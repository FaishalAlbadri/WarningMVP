package com.faishalbadri.hijab.repository.verify_code.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.faishalbadri.hijab.api.APIClient;
import com.faishalbadri.hijab.api.APIInterface;
import com.faishalbadri.hijab.data.response.GlobalResponse;
import com.faishalbadri.hijab.repository.verify_code.VerifyCodeDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by faishal on 23/12/17.
 */

public class VerifyCodeDataRemote implements VerifyCodeDataResource {

  private Context context;

  public VerifyCodeDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getVerifyCodeResult(@NonNull VerifyCodeGetCallback verifyCodeGetCallback) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<GlobalResponse> responsechangePasswordCall = apiInterface.verifyCode(DataUser
        .getInstance().getUserId(), DataUser.getInstance().getUserVerifyCode());
    responsechangePasswordCall.enqueue(new Callback<GlobalResponse>() {
      @Override
      public void onResponse(Call<GlobalResponse> call, Response<GlobalResponse> response) {
        try {
          if (response.body().getMessage().equals("You're successfully verified your code")) {
            verifyCodeGetCallback.onSuccesVerifyCode("succes");
          } else {
            verifyCodeGetCallback.onErrorVerifyCode("Kode verifikasi salah");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<GlobalResponse> call, Throwable t) {
        verifyCodeGetCallback.onErrorVerifyCode("Tidak ada koneksi internet");
      }
    });
  }
}