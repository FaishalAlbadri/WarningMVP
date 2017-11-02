package com.faishalbadri.hijab.ui.home.fragment.account;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.PojoUser;
import com.faishalbadri.hijab.util.ActivityUtil;
import java.util.List;


public class AccountContract {

  public interface accoutView {

    void onSuccesAccount(List<PojoUser.UserBean> user, String username, String image, String id);

    void onErrorAccount(String msg);
  }

  public interface accountPresenter extends BasePresenter<accoutView> {

    void getDataAccount(String email);
  }

  public interface editImageView {

    void onSuccessEditImage(ActivityUtil activityUtil);

    void onErrorEditImage(String msg);
  }

  public interface editImagePresenter extends BasePresenter<editImageView> {

    void getEditImage(String id, String path);
  }

}
