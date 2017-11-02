package com.faishalbadri.hijab.repository.account;


import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoUser;
import com.faishalbadri.hijab.util.ActivityUtil;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/30/17.
 */

public interface AccountDataResource {

  interface AccountGetCallback {

    void onSucces(List<PojoUser.UserBean> user, String username, String image , String id);

    void onError(String msg);

  }

  void getAccountResult(String email, @NonNull AccountDataResource.AccountGetCallback accountGetCallback);

  interface EditImageGetCallback {

    void onSucces(ActivityUtil activityUtil);

    void onError(String msg);

  }

  void getEditImageResult(String id,String path, @NonNull AccountDataResource.EditImageGetCallback editImageGetCallback);

}
