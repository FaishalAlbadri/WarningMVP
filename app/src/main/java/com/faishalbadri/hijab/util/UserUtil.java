package com.faishalbadri.hijab.util;

import android.content.Context;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import java.util.HashMap;

/**
 * Created by faishal on 05/02/18.
 */

public class UserUtil {

  private static SessionManager sessionManager;
  private static HashMap<String, String> hashMap;
  private static UserUtil mInstance = null;
  private Context context;

  public UserUtil(Context context) {
    this.context = context;
  }

  public static UserUtil getInstance(Context context) {
    if (mInstance == null) {
      mInstance = new UserUtil(context);
      sessionManager = new SessionManager(context);
      hashMap = sessionManager.getUser();
    }
    return mInstance;
  }

  public void setDataUser() {
    if (DataUser.getInstance().getUserApiKey() == null) {
      DataUser.getInstance().setUserId(hashMap.get(SessionManager.key_id_user));
      DataUser.getInstance().setUserName(hashMap.get(SessionManager.key_user_name));
      DataUser.getInstance().setUserEmail(hashMap.get(SessionManager.key_user_email));
      DataUser.getInstance().setUserPassword(hashMap.get(SessionManager.key_user_password));
      DataUser.getInstance()
          .setUserHandphoneNumber(hashMap.get(SessionManager.key_user_handphone_number));
      DataUser.getInstance().setUserImage(hashMap.get(SessionManager.key_user_image));
      DataUser.getInstance().setUserVerifyCode(hashMap.get(SessionManager.key_user_verify_code));
      DataUser.getInstance()
          .setUserVerifiedCode(hashMap.get(SessionManager.key_user_verified_code));
      DataUser.getInstance().setUserGender(hashMap.get(SessionManager.key_user_gender));
      DataUser.getInstance().setUserApiKey(hashMap.get(SessionManager.key_user_apikey));
    }
  }

  public void setDataUserLogin() {
    DataUser.getInstance().setUserId(hashMap.get(SessionManager.key_id_user));
    DataUser.getInstance().setUserName(hashMap.get(SessionManager.key_user_name));
    DataUser.getInstance().setUserEmail(hashMap.get(SessionManager.key_user_email));
    DataUser.getInstance().setUserPassword(hashMap.get(SessionManager.key_user_password));
    DataUser.getInstance()
        .setUserHandphoneNumber(hashMap.get(SessionManager.key_user_handphone_number));
    DataUser.getInstance().setUserImage(hashMap.get(SessionManager.key_user_image));
    DataUser.getInstance().setUserVerifyCode(hashMap.get(SessionManager.key_user_verify_code));
    DataUser.getInstance()
        .setUserVerifiedCode(hashMap.get(SessionManager.key_user_verified_code));
    DataUser.getInstance().setUserGender(hashMap.get(SessionManager.key_user_gender));
    DataUser.getInstance().setUserApiKey(hashMap.get(SessionManager.key_user_apikey));
  }
}
