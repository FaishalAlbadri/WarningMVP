package com.faishalbadri.hijab.ui.change.password;

import com.faishalbadri.hijab.base.BasePresenter;

/**
 * Created by faishal on 06/02/18.
 */

public class PasswordContract {

  public interface PasswordView {

    void onResponse(String msg);

  }

  public interface PasswordPresenter extends BasePresenter<PasswordView> {

    void getPassword(String password);

  }

}
