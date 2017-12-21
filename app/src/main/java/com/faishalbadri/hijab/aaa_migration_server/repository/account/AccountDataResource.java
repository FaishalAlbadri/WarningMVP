package com.faishalbadri.hijab.aaa_migration_server.repository.account;


import android.support.annotation.NonNull;
import com.faishalbadri.hijab.aaa_migration_server.util.ActivityUtil;

/**
 * Created by fikriimaduddin on 10/30/17.
 */

public interface AccountDataResource {

  void getAccountResult(String username, String password,
      @NonNull AccountDataResource.AccountGetCallback accountGetCallback);

  void getEditImageResult(String id, String path,
      @NonNull AccountDataResource.EditImageGetCallback editImageGetCallback);

  interface AccountGetCallback {

    void onSucces(String msg, String id_user, String user_name,String user_email, String
        user_handphone_number, String
        user_image, String user_password, String user_verify_code, String
        user_verified_code, String user_gender, String user_apikey);

    void onError(String msg);

  }

  interface EditImageGetCallback {

    void onSucces(ActivityUtil activityUtil);

    void onError(String msg);

  }

}
