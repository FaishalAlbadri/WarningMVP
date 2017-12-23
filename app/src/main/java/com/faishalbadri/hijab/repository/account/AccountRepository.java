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
  public void getAccountResult(@NonNull AccountGetCallback accountGetCallback) {
    accountDataResource.getAccountResult(accountGetCallback);
  }

  public void getEditImageResult(String path,
      @NonNull EditImageGetCallback accountGetCallback) {
    accountDataResource.getEditImageResult(path, accountGetCallback);
  }
}
