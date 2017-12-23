package com.faishalbadri.hijab.repository.verify_code;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 23/12/17.
 */

public interface VerifyCodeDataResource {

  void getVerifyCodeResult(@NonNull VerifyCodeGetCallback verifyCodeGetCallback);

  interface VerifyCodeGetCallback {

    void onSuccesVerifyCode(String msg);

    void onErrorVerifyCode(String msg);
  }

}
