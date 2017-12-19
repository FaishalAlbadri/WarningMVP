package com.faishalbadri.hijab.ui.login_register;

import com.faishalbadri.hijab.revamp.repository.register.RegisterDataResource.RegisterGetCallback;
import com.faishalbadri.hijab.revamp.repository.register.RegisterRepository;
import com.faishalbadri.hijab.ui.login_register.RegisterContract.registerView;

/**
 * Created by faishal on 10/30/17.
 */

public class RegisterPresenter implements RegisterContract.registerPresenter {

  RegisterContract.registerView registerView;
  RegisterRepository registerRepository;

  public RegisterPresenter(
      RegisterRepository registerRepository) {
    this.registerRepository = registerRepository;
  }

  @Override
  public void onAttachView(registerView view) {
    this.registerView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataRegister(String username, String email, String password, String verify_code) {
    registerRepository.getRegisterResult(username, email, password, verify_code, new
        RegisterGetCallback() {
          @Override
          public void onSuccesRegister(String msg) {
            registerView.onSuccesRegister(msg);
          }

          @Override
          public void onWrongRegister(String msg) {
            registerView.onWrongRegister(msg);
          }

          @Override
          public void onErrorRegister(String msg) {
            registerView.onErrorRegister(msg);
          }
        });
  }
}
