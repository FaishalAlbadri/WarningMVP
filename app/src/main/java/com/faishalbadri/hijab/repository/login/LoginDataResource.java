package com.faishalbadri.hijab.repository.login;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 10/30/17.
 */

public interface LoginDataResource {

  void getLoginResult(String username, String password, @NonNull LoginGetCallback
      loginGetCallback);

  interface LoginGetCallback {

    void onSuccesLogin(String msg, String id_user, String user_name,String user_email, String
        user_handphone_number, String
        user_image, String user_password, String user_verify_code, String
        user_verified_code, String user_gender, String user_apikey);

    void onWrongLogin(String msg);

    void onErrorLogin(String msg);

  }

}
