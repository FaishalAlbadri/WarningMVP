package com.faishalbadri.hijab.repository.account;

import android.support.annotation.NonNull;

/**
 * Created by fikriimaduddin on 10/30/17.
 */

public class AccountRepository implements AccountDataResource {

  private AccountDataResource accountDataResource;

  public AccountRepository(AccountDataResource accountDataResource) {
    this.accountDataResource = accountDataResource;
  }

  @Override
  public void getAccountResult(String username, String password,
      @NonNull AccountGetCallback accountGetCallback) {
    accountDataResource.getAccountResult(username, password, accountGetCallback);
  }

  public void getEditImageResult(String id, String path,
      @NonNull EditImageGetCallback accountGetCallback) {
    accountDataResource.getEditImageResult(id, path, accountGetCallback);
  }
}
