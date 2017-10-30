package com.faishalbadri.hijab.repository.login;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 10/30/17.
 */

public class LoginRepository implements LoginDataResource {

  private LoginDataResource loginDataResource;

  public LoginRepository(LoginDataResource loginDataResource) {
    this.loginDataResource = loginDataResource;
  }

  @Override
  public void getLoginResult(String email, String password,
      @NonNull LoginGetCallback loginGetCallback) {
    loginDataResource.getLoginResult(email, password, loginGetCallback);
  }
}
