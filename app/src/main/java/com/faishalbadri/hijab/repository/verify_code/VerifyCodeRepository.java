package com.faishalbadri.hijab.repository.verify_code;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 23/12/17.
 */

public class VerifyCodeRepository implements VerifyCodeDataResource {

  VerifyCodeDataResource verifyCodeDataResource;

  public VerifyCodeRepository(
      VerifyCodeDataResource verifyCodeDataResource) {
    this.verifyCodeDataResource = verifyCodeDataResource;
  }

  @Override
  public void getVerifyCodeResult(String user_id, String verify_code,
      @NonNull VerifyCodeGetCallback verifyCodeGetCallback) {
    verifyCodeDataResource.getVerifyCodeResult(user_id, verify_code, verifyCodeGetCallback);
  }
}
