package com.faishalbadri.hijab.aaa_migration_server.di;

import android.content.Context;
import com.faishalbadri.hijab.aaa_migration_server.repository.register.RegisterRepository;
import com.faishalbadri.hijab.aaa_migration_server.repository.register.remote.RegisterDataRemote;

/**
 * Created by faishal on 10/30/17.
 */

public class RegisterRepositoryInject {

  public static RegisterRepository provideToRegisterRepository(Context context) {
    return new RegisterRepository(new RegisterDataRemote(context));
  }
}
