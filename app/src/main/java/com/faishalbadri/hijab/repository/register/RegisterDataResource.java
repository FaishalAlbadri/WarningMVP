package com.faishalbadri.hijab.repository.register;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 10/30/17.
 */

public interface RegisterDataResource {

  public interface RegisterGetCallback {

    void onSuccesRegister(String msg);

    void onErrorRegister(String msg);
  }

  void getRegisterResult(String username, String email, String password,
      @NonNull RegisterGetCallback registerGetCallback);

}
