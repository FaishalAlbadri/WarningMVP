package com.faishalbadri.hijab.ui.login_register;

import com.faishalbadri.hijab.repository.login.LoginDataResource.LoginGetCallback;
import com.faishalbadri.hijab.repository.login.LoginRepository;

/**
 * Created by faishal on 10/30/17.
 */

public class LoginPresenter implements LoginContract.loginPresenter {

  private LoginContract.loginView loginView;
  private LoginRepository loginRepository;

  public LoginPresenter(LoginRepository loginRepository) {
    this.loginRepository = loginRepository;
  }


  @Override
  public void onAttachView(LoginContract.loginView view) {
    this.loginView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataLogin(String email, String password) {
    loginRepository.getLoginResult(email, password, new LoginGetCallback() {
      @Override
      public void onSuccesLogin(String msg, String id_user, String user_name, String user_email,
          String user_handphone_number, String user_image, String user_password,
          String user_verify_code, String user_verified_code, String user_gender,
          String user_apikey) {
        loginView.onSuccesLogin(msg, id_user, user_name, user_email, user_handphone_number, user_image, user_password, user_verify_code, user_verified_code, user_gender, user_apikey);
      }

      @Override
      public void onWrongLogin(String msg) {
        loginView.onWrongLogin(msg);
      }

      @Override
      public void onErrorLogin(String msg) {
        loginView.onErrorLogin(msg);
      }
    });
  }
}
