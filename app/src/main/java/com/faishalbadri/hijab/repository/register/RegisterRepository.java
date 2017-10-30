package com.faishalbadri.hijab.repository.register;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 10/30/17.
 */

public class RegisterRepository implements RegisterDataResource {

  RegisterDataResource registerDataResource;

  public RegisterRepository(
      RegisterDataResource registerDataResource) {
    this.registerDataResource = registerDataResource;
  }

  @Override
  public void getRegisterResult(String username, String email, String password,
      @NonNull RegisterGetCallback registerGetCallback) {
    registerDataResource.getRegisterResult(username, email, password, registerGetCallback);
  }
}
