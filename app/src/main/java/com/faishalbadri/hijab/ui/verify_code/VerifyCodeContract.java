package com.faishalbadri.hijab.ui.verify_code;

import com.faishalbadri.hijab.base.BasePresenter;

/**
 * Created by faishal on 23/12/17.
 */

public class VerifyCodeContract {

  public interface VerifyCodeView {

    void onSuccesVerifyCode(String msg);

    void onErrorVerifyCode(String msg);
  }

  public interface VerifyCodePresenter extends BasePresenter<VerifyCodeView> {

    void getDataVerifyCode();
  }

}
