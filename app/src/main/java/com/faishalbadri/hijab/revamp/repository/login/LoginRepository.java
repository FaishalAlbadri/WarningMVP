package com.faishalbadri.hijab.revamp.repository.login;

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
  public void getLoginResult(String username, String password,
      @NonNull LoginGetCallback loginGetCallback) {
    loginDataResource.getLoginResult(username, password, loginGetCallback);
  }
}
