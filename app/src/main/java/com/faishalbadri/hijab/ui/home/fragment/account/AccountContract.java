package com.faishalbadri.hijab.ui.home.fragment.account;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.PojoUser;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/30/17.
 */

public class AccountContract {

  public interface accoutView {

    void onSuccesAccount(List<PojoUser.UserBean> user,String username, String image, String id);

    void onErrorAccount(String msg);
  }

  public interface accountPresenter extends BasePresenter<accoutView> {

    void getDataAccount(String email);
  }

}
