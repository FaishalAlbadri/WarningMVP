package com.faishalbadri.hijab.ui.verify_code;

import com.faishalbadri.hijab.repository.verify_code.VerifyCodeDataResource.VerifyCodeGetCallback;
import com.faishalbadri.hijab.repository.verify_code.VerifyCodeRepository;
import com.faishalbadri.hijab.ui.verify_code.VerifyCodeContract.VerifyCodeView;

/**
 * Created by faishal on 23/12/17.
 */

public class VerifyCodePresenter implements VerifyCodeContract.VerifyCodePresenter {

  VerifyCodeRepository verifyCodeRepository;
  VerifyCodeContract.VerifyCodeView verifyCodeView;

  public VerifyCodePresenter(
      VerifyCodeRepository verifyCodeRepository) {
    this.verifyCodeRepository = verifyCodeRepository;
  }

  @Override
  public void onAttachView(VerifyCodeView view) {
    this.verifyCodeView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataVerifyCode(String user_id, String verify_code) {
    verifyCodeRepository.getVerifyCodeResult(user_id, verify_code, new VerifyCodeGetCallback() {
      @Override
      public void onSuccesVerifyCode(String msg) {
        verifyCodeView.onSuccesVerifyCode(msg);
      }

      @Override
      public void onErrorVerifyCode(String msg) {
        verifyCodeView.onErrorVerifyCode(msg);
      }
    });
  }
}
