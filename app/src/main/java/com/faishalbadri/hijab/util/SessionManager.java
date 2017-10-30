package com.faishalbadri.hijab.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.faishalbadri.hijab.ui.home.activity.HomeActivity;
import com.faishalbadri.hijab.ui.login_register.LoginRegisterActivity;
import java.util.HashMap;

/**
 * Created by fikriimaduddin on 10/30/17.
 */

public class SessionManager {

  SharedPreferences pref;
  SharedPreferences.Editor editor;
  Context context;
  int mode = 0;

  private static final String pref_name = "crudpref";
  private static final String is_login = "islogin";
  public static final String key_email = "keyemail";

  public SessionManager(Context context) {
    this.context = context;
    pref = context.getSharedPreferences(pref_name, mode);
    editor = pref.edit();
  }

  public void createSession(String email) {
    editor.putBoolean(is_login, true);
    editor.putString(key_email, email);
    editor.commit();
  }

  public void checkLogin() {
    if (!this.is_login()) {
      Intent i = new Intent(context, LoginRegisterActivity.class);
      i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
      i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      context.startActivity(i);
//      ((Activity) context).finish();
    } else {
      Intent i = new Intent(context, HomeActivity.class);
      i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
      i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      context.startActivity(i);
//      ((Activity) context).finish();
    }
  }

  private boolean is_login() {
    return pref.getBoolean(is_login, false);
  }

  public void logout() {
    editor.clear();
    editor.commit();
    Intent i = new Intent(context, LoginRegisterActivity.class);
    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(i);
  }

  public HashMap<String, String> getUserDetails() {
    HashMap<String, String> user = new HashMap<String, String>();
    user.put(key_email, pref.getString(key_email, null));
    return user;
  }

}
