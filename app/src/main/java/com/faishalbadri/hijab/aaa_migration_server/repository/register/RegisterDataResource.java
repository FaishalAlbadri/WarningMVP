package com.faishalbadri.hijab.aaa_migration_server.repository.register;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 10/30/17.
 */

public interface RegisterDataResource {

  void getRegisterResult(String username, String email, String password, String verify_code,
      @NonNull RegisterGetCallback registerGetCallback);

  interface RegisterGetCallback {

    void onSuccesRegister(String msg);

    void onWrongRegister(String msg);

    void onErrorRegister(String msg);
  }

}
