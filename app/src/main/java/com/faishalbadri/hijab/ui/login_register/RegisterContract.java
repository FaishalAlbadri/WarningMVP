package com.faishalbadri.hijab.ui.login_register;

import com.faishalbadri.hijab.base.BasePresenter;

/**
 * Created by faishal on 10/30/17.
 */

public class RegisterContract {

  public interface registerView {

    void onSuccesRegister(String msg);

    void onErrorRegister(String msg);
  }

  public interface registerPresenter extends BasePresenter<registerView> {

    void getDataRegister(String username, String email, String password);
  }

}
