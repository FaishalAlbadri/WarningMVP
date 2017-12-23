package com.faishalbadri.hijab.ui.home.fragment.account;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.util.ActivityUtil;


public class AccountContract {

  public interface accoutView {

    void onSuccesAccount(String msg, String id_user, String user_name, String user_email, String
        user_handphone_number, String
        user_image, String user_password, String user_verify_code, String
        user_verified_code, String user_gender, String user_apikey);


    void onErrorAccount(String msg);
  }

  public interface accountPresenter extends BasePresenter<accoutView> {

    void getDataAccount();
  }

  public interface editImageView {

    void onSuccessEditImage(ActivityUtil activityUtil);

    void onErrorEditImage(String msg);
  }

  public interface editImagePresenter extends BasePresenter<editImageView> {

    void getEditImage(String path);
  }

}
