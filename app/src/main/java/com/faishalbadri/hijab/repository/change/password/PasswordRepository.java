package com.faishalbadri.hijab.repository.change.password;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 06/02/18.
 */

public class PasswordRepository implements PasswordDataResource {

  PasswordDataResource passwordDataResource;

  public PasswordRepository(PasswordDataResource passwordDataResource) {
    this.passwordDataResource = passwordDataResource;
  }

  @Override
  public void getPasswordResult(String password, @NonNull PasswordGetCallback passwordGetCallback) {
    passwordDataResource.getPasswordResult(password, passwordGetCallback);
  }
}
