package com.faishalbadri.hijab.repository.login;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 10/30/17.
 */

public interface LoginDataResource {

  void getLoginResult(String email, String password, @NonNull LoginGetCallback loginGetCallback);

  interface LoginGetCallback {

    void onSuccesLogin(String msg, String id, String username, String image);

    void onWrongLogin(String msg);

    void onErrorLogin(String msg);

  }

}
