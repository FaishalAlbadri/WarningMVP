package com.faishalbadri.hijab.ui.change.password;

import com.faishalbadri.hijab.repository.change.password.PasswordRepository;
import com.faishalbadri.hijab.ui.change.password.PasswordContract.PasswordView;

/**
 * Created by faishal on 06/02/18.
 */

public class PasswordPresenter implements PasswordContract.PasswordPresenter {

  private PasswordContract.PasswordView passwordView;
  private PasswordRepository passwordRepository;

  public PasswordPresenter(PasswordRepository passwordRepository) {
    this.passwordRepository = passwordRepository;
  }

  @Override
  public void onAttachView(PasswordView view) {
    passwordView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getPassword(String password) {
    passwordRepository.getPasswordResult(password, msg -> passwordView.onResponse(msg));
  }
}
