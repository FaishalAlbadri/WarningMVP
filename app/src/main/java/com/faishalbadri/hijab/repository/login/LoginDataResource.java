package com.faishalbadri.hijab.repository.login;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 10/30/17.
 */

public interface LoginDataResource {

  public interface LoginGetCallback {

    void onSuccesLogin(String msg);

    void onErrorLogin(String msg);

  }

  void getLoginResult(String email, String password, @NonNull LoginGetCallback loginGetCallback);

}
