package com.faishalbadri.hijab.aaa_migration_server.repository.register;

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
  public void getRegisterResult(String username, String email, String password, String verify_code,
      @NonNull RegisterGetCallback registerGetCallback) {
    registerDataResource.getRegisterResult(username, email, password, verify_code,
        registerGetCallback);
  }
}
