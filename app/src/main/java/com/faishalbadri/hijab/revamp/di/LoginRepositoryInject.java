package com.faishalbadri.hijab.revamp.di;

import android.content.Context;
import com.faishalbadri.hijab.revamp.repository.login.LoginRepository;
import com.faishalbadri.hijab.revamp.repository.login.remote.LoginDataRemote;

/**
 * Created by faishal on 10/30/17.
 */

public class LoginRepositoryInject {

  public static LoginRepository provideToLoginRepository(Context context) {
    return new LoginRepository(new LoginDataRemote(context));
  }
}