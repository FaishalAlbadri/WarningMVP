package com.faishalbadri.hijab.ui.login_register;

import com.faishalbadri.hijab.base.BasePresenter;

/**
 * Created by faishal on 10/30/17.
 */

public class LoginContract {

  public interface loginView {

    void onSuccesLogin(String msg, String id_user, String user_name, String user_email, String
        user_handphone_number, String
        user_image, String user_password, String user_verify_code, String
        user_verified_code, String user_gender, String user_apikey);

    void onWrongLogin(String msg);

    void onErrorLogin(String msg);
  }

  public interface loginPresenter extends BasePresenter<loginView> {

    void getDataLogin(String username, String password);
  }

}
