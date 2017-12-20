package com.faishalbadri.hijab.revamp.di;

import android.content.Context;
import com.faishalbadri.hijab.revamp.repository.account.AccountRepository;
import com.faishalbadri.hijab.revamp.repository.account.remote.AccountDataRemote;

/**
 * Created by fikriimaduddin on 10/30/17.
 */

public class AccountRepositoryInject {

  public static AccountRepository provideToLoginRepository(Context context) {
    return new AccountRepository(new AccountDataRemote(context));
  }
}
