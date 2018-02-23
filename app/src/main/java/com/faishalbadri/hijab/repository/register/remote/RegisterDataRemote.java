package com.faishalbadri.hijab.repository.register.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.api.APIClient;
import com.faishalbadri.hijab.api.APIInterface;
import com.faishalbadri.hijab.data.ResponseRegister;
import com.faishalbadri.hijab.repository.register.RegisterDataResource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by faishal on 10/30/17.
 */

public class RegisterDataRemote implements RegisterDataResource {

  Context context;

  public RegisterDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getRegisterResult(String username, String email, String password, String verify_code,
      @NonNull RegisterGetCallback registerGetCallback) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<ResponseRegister> responseRegisterCall = apiInterface
        .getRegister(username, email, password, verify_code);
    responseRegisterCall.enqueue(new Callback<ResponseRegister>() {
      @Override
      public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
        try {
          if (response.body().getMessage().equals("You're successfully registered")) {
            Toast.makeText(context, "Anda telah terdaftar\nSilahkan Login", Toast.LENGTH_SHORT)
                .show();
            registerGetCallback.onSuccesRegister(context.getString(R.string.text_succes));
          } else if (response.body().getMessage().equals("Sorry.. Account already exist")) {
            Toast.makeText(context, "Masukkan data yang valid\nNama atau Email Sudah Terpakai",
                Toast.LENGTH_SHORT).show();
            registerGetCallback.onWrongRegister(context.getString(R.string.text_error));
          } else {
            Toast.makeText(context, "Terjadi kesalahan ketika mendaftar\nSilahkan daftar ulang",
                Toast.LENGTH_SHORT).show();
            registerGetCallback.onWrongRegister(context.getString(R.string.text_error));
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<ResponseRegister> call, Throwable t) {
        registerGetCallback.onErrorRegister("error");
      }
    });

  }
}
