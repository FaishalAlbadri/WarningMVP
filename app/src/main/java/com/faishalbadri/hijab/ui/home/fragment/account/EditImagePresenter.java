package com.faishalbadri.hijab.ui.home.fragment.account;

import com.faishalbadri.hijab.repository.account.AccountDataResource.EditImageGetCallback;
import com.faishalbadri.hijab.repository.account.AccountRepository;
import com.faishalbadri.hijab.ui.home.fragment.account.AccountContract.editImageView;
import com.faishalbadri.hijab.util.ActivityUtil;

/**
 * Created by fikriimaduddin on 11/2/17.
 */

public class EditImagePresenter implements AccountContract.editImagePresenter {


  AccountRepository accountRepository;
  AccountContract.editImageView editImageView;

  public EditImagePresenter(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  public void onAttachView(editImageView view) {
    this.editImageView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getEditImage(String id, String path) {

    accountRepository.getEditImageResult(id, path, new EditImageGetCallback() {
      @Override
      public void onSucces(ActivityUtil activityUtil) {
        editImageView.onSuccessEditImage(activityUtil);
      }

      @Override
      public void onError(String msg) {

      }
    });
  }
}
