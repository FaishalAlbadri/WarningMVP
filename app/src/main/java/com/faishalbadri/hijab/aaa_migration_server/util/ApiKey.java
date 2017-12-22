package com.faishalbadri.hijab.aaa_migration_server.util;

import android.content.Context;
import java.util.HashMap;

/**
 * Created by faishal on 23/12/17.
 */

public class ApiKey {

  private static ApiKey mInstance = null;
  private static SessionManager sessionManager = null;
  private static String ApiKey;

  public static ApiKey getInstance(Context context) {
    if (mInstance == null && sessionManager == null) {
      mInstance = new ApiKey();
      sessionManager = new SessionManager(context);
      HashMap<String, String> user = sessionManager.getUser();
      ApiKey = user.get(SessionManager.key_user_apikey);
    }
    return mInstance;
  }

  public String getApiKey() {
    return ApiKey;
  }

}
