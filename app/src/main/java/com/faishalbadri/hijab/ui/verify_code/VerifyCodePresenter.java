package com.faishalbadri.hijab.ui.verify_code;

import com.faishalbadri.hijab.repository.verify_code.VerifyCodeDataResource.VerifyCodeGetCallback;
import com.faishalbadri.hijab.repository.verify_code.VerifyCodeRepository;
import com.faishalbadri.hijab.ui.verify_code.VerifyCodeContract.VerifyCodeView;

/**
 * Created by faishal on 23/12/17.
 */

public class VerifyCodePresenter implements VerifyCodeContract.VerifyCodePresenter {

  private VerifyCodeRepository verifyCodeRepository;
  private VerifyCodeContract.VerifyCodeView verifyCodeView;

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
  public void getDataVerifyCode() {
    verifyCodeRepository.getVerifyCodeResult(new VerifyCodeGetCallback() {
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
