package com.faishalbadri.hijab.revamp.ui.home.fragment.account;

import com.faishalbadri.hijab.revamp.base.BasePresenter;
import com.faishalbadri.hijab.revamp.util.ActivityUtil;


public class AccountContract {

  public interface accoutView {

    void onSuccesAccount(String msg, String id_user, String user_name, String user_email, String
        user_handphone_number, String
        user_image, String user_password, String user_verify_code, String
        user_verified_code, String user_gender, String user_apikey);


    void onErrorAccount(String msg);
  }

  public interface accountPresenter extends BasePresenter<accoutView> {

    void getDataAccount(String username, String password);
  }

  public interface editImageView {

    void onSuccessEditImage(ActivityUtil activityUtil);

    void onErrorEditImage(String msg);
  }

  public interface editImagePresenter extends BasePresenter<editImageView> {

    void getEditImage(String id, String path);
  }

}
