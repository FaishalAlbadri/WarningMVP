package com.faishalbadri.hijab.ui.login_register;

import com.faishalbadri.hijab.repository.login.LoginDataResource.LoginGetCallback;
import com.faishalbadri.hijab.repository.login.LoginRepository;
import com.faishalbadri.hijab.ui.login_register.LoginContract.loginView;

/**
 * Created by faishal on 10/30/17.
 */

public class LoginPresenter implements LoginContract.loginPresenter {

  LoginContract.loginView loginView;
  LoginRepository loginRepository;

  public LoginPresenter(LoginRepository loginRepository) {
    this.loginRepository = loginRepository;
  }



  @Override
  public void onAttachView(loginView view) {
    this.loginView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataLogin(String email, String password) {
    loginRepository.getLoginResult(email, password, new LoginGetCallback() {
      @Override
      public void onSuccesLogin(String msg) {
        loginView.onSuccesLogin(msg);
      }

      @Override
      public void onErrorLogin(String msg) {
        loginView.onErrorLogin(msg);
      }
    });

  }
}
