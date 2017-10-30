package com.faishalbadri.hijab.repository.account;


import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoUser;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/30/17.
 */

public interface AccountDataResource {

  public interface AccountGetCallback {

    void onSucces(List<PojoUser.UserBean> user, String username, String image );

    void onError(String msg);

  }

  void getAccountResult(String email, @NonNull AccountDataResource.AccountGetCallback accountGetCallback);

}
