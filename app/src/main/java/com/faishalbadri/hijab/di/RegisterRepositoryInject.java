package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.register.RegisterRepository;
import com.faishalbadri.hijab.repository.register.remote.RegisterDataRemote;

/**
 * Created by faishal on 10/30/17.
 */

public class RegisterRepositoryInject {

  public static RegisterRepository provideToRegisterRepository(Context context) {
    return new RegisterRepository(new RegisterDataRemote(context));
  }
}
