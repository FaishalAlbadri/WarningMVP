package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.verify_code.VerifyCodeRepository;
import com.faishalbadri.hijab.repository.verify_code.remote.VerifyCodeDataRemote;

/**
 * Created by faishal on 23/12/17.
 */

public class VerifyCodeRepositoryInject {

  public static VerifyCodeRepository provideToRepository(Context context) {
    return new VerifyCodeRepository(new VerifyCodeDataRemote(context));
  }
}
