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
  public void getAccountResult(String email, @NonNull AccountGetCallback accountGetCallback) {
    accountDataResource.getAccountResult(email, accountGetCallback);
  }
}
