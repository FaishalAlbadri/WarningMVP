package com.faishalbadri.hijab.repository.change.password;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 06/02/18.
 */

public interface PasswordDataResource {

  void getPasswordResult(String password, @NonNull PasswordGetCallback passwordGetCallback);

  interface PasswordGetCallback {

    void onResponse(String msg);

  }

}
