package com.faishalbadri.hijab.ui.login_register;

import com.faishalbadri.hijab.base.BasePresenter;

/**
 * Created by faishal on 10/30/17.
 */

public class LoginContract {

  public interface loginView {

    void onSuccesLogin(String msg, String id, String username, String image);

    void onWrongLogin(String msg);

    void onErrorLogin(String msg);
  }

  public interface loginPresenter extends BasePresenter<loginView> {

    void getDataLogin(String email, String password);
  }

}
