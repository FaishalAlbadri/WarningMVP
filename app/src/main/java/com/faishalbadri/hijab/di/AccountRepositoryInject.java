package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.account.AccountRepository;
import com.faishalbadri.hijab.repository.account.remote.AccountDataRemote;

/**
 * Created by fikriimaduddin on 10/30/17.
 */

public class AccountRepositoryInject {
  public static AccountRepository provideToLoginRepository(Context context){
    return new AccountRepository(new AccountDataRemote(context));
  }
}
