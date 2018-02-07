package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.change.password.PasswordRepository;
import com.faishalbadri.hijab.repository.change.password.remote.PasswordDataRemote;

/**
 * Created by faishal on 06/02/18.
 */

public class ChangePasswordRepositoryInject {

  public static PasswordRepository provideToRepositoryInject(Context context) {
    return new PasswordRepository(new PasswordDataRemote(context));
  }
}
