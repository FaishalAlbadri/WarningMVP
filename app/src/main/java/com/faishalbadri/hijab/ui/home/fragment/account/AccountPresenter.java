package com.faishalbadri.hijab.ui.home.fragment.account;

import com.faishalbadri.hijab.repository.account.AccountDataResource.AccountGetCallback;
import com.faishalbadri.hijab.repository.account.AccountRepository;
import com.faishalbadri.hijab.ui.home.fragment.account.AccountContract.accoutView;

/**
 * Created by fikriimaduddin on 10/30/17.
 */

public class AccountPresenter implements AccountContract.accountPresenter {

  private AccountContract.accoutView accoutView;
  private AccountRepository accountRepository;

  public AccountPresenter(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  public void onAttachView(accoutView view) {
    this.accoutView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataAccount() {
    accountRepository.getAccountResult(new AccountGetCallback() {
      @Override
      public void onSucces(String msg, String id_user, String user_name, String user_email,
          String user_handphone_number, String user_image, String user_password,
          String user_verify_code, String user_verified_code, String user_gender,
          String user_apikey) {
        accoutView
            .onSuccesAccount(msg, id_user, user_name, user_email, user_handphone_number, user_image,
                user_password, user_verify_code, user_verified_code, user_gender, user_apikey);
      }

      @Override
      public void onError(String msg) {
        accoutView.onErrorAccount(msg);
      }
    });
  }
}
