package com.faishalbadri.hijab.ui.home.fragment.account;

import com.faishalbadri.hijab.data.PojoUser.UserBean;
import com.faishalbadri.hijab.repository.account.AccountDataResource.AccountGetCallback;
import com.faishalbadri.hijab.repository.account.AccountRepository;
import com.faishalbadri.hijab.ui.home.fragment.account.AccountContract.accoutView;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/30/17.
 */

public class AccountPresenter implements AccountContract.accountPresenter{

  AccountContract.accoutView accoutView;
  AccountRepository accountRepository;

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
  public void getDataAccount(String email) {
    accountRepository.getAccountResult(email, new AccountGetCallback() {
      @Override
      public void onSucces(List<UserBean> user, String username, String image, String id) {
        accoutView.onSuccesAccount(user, username, image, id);
      }

      @Override
      public void onError(String msg) {
        accoutView.onErrorAccount(msg);
      }
    });
  }
}
