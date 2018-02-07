package com.faishalbadri.hijab.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.faishalbadri.hijab.ui.home.activity.HomeActivity;
import com.faishalbadri.hijab.ui.login_register.LoginRegisterActivity;
import com.faishalbadri.hijab.ui.verify_code.VerifyCodeActivity;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import java.util.HashMap;


public class SessionManager {

  public static final String key_id_user = "key_id_user";
  public static final String key_user_name = "key_user_name";
  public static final String key_user_email = "key_user_email";
  public static final String key_user_handphone_number = "key_user_handphone_number";
  public static final String key_user_image = "key_user_image";
  public static final String key_user_password = "key_user_password";
  public static final String key_user_verify_code = "key_user_verify_code";
  public static final String key_user_verified_code = "key_user_verified_code";
  public static final String key_user_gender = "key_user_gender";
  public static final String key_user_apikey = "key_user_apikey";
  private static final String pref_id_user = "pref_id_user";
  private static final String pref_user_name = "pref_user_name";
  private static final String pref_user_email = "pref_user_email";
  private static final String pref_user_handphone_number = "pref_user_handphone_number";
  private static final String pref_user_image = "pref_user_image";
  private static final String pref_user_password = "pref_user_password";
  private static final String pref_user_verify_code = "pref_user_verify_code";
  private static final String pref_user_verified_code = "pref_user_verified_code";
  private static final String pref_user_gender = "pref_user_gender";
  private static final String pref_user_apikey = "pref_user_apikey";
  private static final String is_login = "islogin";
  private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
  private static final String pref_intro = "intro-welcome";
  private Context context;
  private SharedPreferences id_userPref, user_namePref, user_emailPref, user_handphone_numberPref,
      user_imagePref, user_passwordPref, user_verify_codePref, user_verified_codePref,
      user_genderPref, user_apikeyPref, introPref;
  private SharedPreferences.Editor id_userEditor, user_nameEditor, user_emailEditor,
      user_handphone_numberEditor,
      user_imageEditor, user_passwordEditor, user_verify_codeEditor, user_verified_codeEditor,
      user_genderEditor, user_apikeyEditor, introEditor;
  private int mode;


  public SessionManager(Context context) {
    mode = 0;
    this.context = context;
    introPref = context.getSharedPreferences(pref_intro, mode);
    id_userPref = context.getSharedPreferences(pref_id_user, mode);
    user_namePref = context.getSharedPreferences(pref_user_name, mode);
    user_emailPref = context.getSharedPreferences(pref_user_email, mode);
    user_handphone_numberPref = context.getSharedPreferences(pref_user_handphone_number, mode);
    user_imagePref = context.getSharedPreferences(pref_user_image, mode);
    user_passwordPref = context.getSharedPreferences(pref_user_password, mode);
    user_verify_codePref = context.getSharedPreferences(pref_user_verify_code, mode);
    user_verified_codePref = context.getSharedPreferences(pref_user_verified_code, mode);
    user_genderPref = context.getSharedPreferences(pref_user_gender, mode);
    user_apikeyPref = context.getSharedPreferences(pref_user_apikey, mode);

    introEditor = introPref.edit();
    id_userEditor = id_userPref.edit();
    user_nameEditor = user_namePref.edit();
    user_emailEditor = user_emailPref.edit();
    user_handphone_numberEditor = user_handphone_numberPref.edit();
    user_imageEditor = user_imagePref.edit();
    user_passwordEditor = user_passwordPref.edit();
    user_verify_codeEditor = user_verify_codePref.edit();
    user_verified_codeEditor = user_verified_codePref.edit();
    user_genderEditor = user_genderPref.edit();
    user_apikeyEditor = user_apikeyPref.edit();
  }


  public void createSession(String id_user, String user_name, String user_email,
      String user_handphone_number, String user_image, String user_password,
      String user_verify_code, String user_verified_code, String user_gender, String user_apikey) {

    id_userEditor.putBoolean(is_login, true);
    id_userEditor.putString(key_id_user, id_user);
    user_nameEditor.putString(key_user_name, user_name);
    user_emailEditor.putString(key_user_email, user_email);
    user_handphone_numberEditor.putString(key_user_handphone_number, user_handphone_number);
    user_imageEditor.putString(key_user_image, user_image);
    user_passwordEditor.putString(key_user_password, user_password);
    user_verify_codeEditor.putString(key_user_verify_code, user_verify_code);
    user_verified_codeEditor.putString(key_user_verified_code, user_verified_code);
    user_genderEditor.putString(key_user_gender, user_gender);
    user_apikeyEditor.putString(key_user_apikey, user_apikey);

    id_userEditor.commit();
    user_nameEditor.commit();
    user_emailEditor.commit();
    user_handphone_numberEditor.commit();
    user_imageEditor.commit();
    user_passwordEditor.commit();
    user_verify_codeEditor.commit();
    user_verified_codeEditor.commit();
    user_genderEditor.commit();
    user_apikeyEditor.commit();

    DataUser.getInstance().setUserId(id_user);
    DataUser.getInstance().setUserName(user_name);
    DataUser.getInstance().setUserEmail(user_email);
    DataUser.getInstance().setUserPassword(user_password);
    DataUser.getInstance().setUserHandphoneNumber(user_handphone_number);
    DataUser.getInstance().setUserImage(user_image);
    DataUser.getInstance().setUserVerifyCode(user_verify_code);
    DataUser.getInstance().setUserVerifiedCode(user_verified_code);
    DataUser.getInstance().setUserGender(user_gender);
    DataUser.getInstance().setUserApiKey(user_apikey);
  }

  public void editVerifiedCode(String user_verified_code) {
    user_verified_codeEditor.clear();
    user_verified_codeEditor.putString(key_user_verified_code, user_verified_code);
    user_verified_codeEditor.commit();
    DataUser.getInstance().setUserVerifiedCode(user_verified_code);
    context.startActivity(new Intent(context, HomeActivity.class)
        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
    ((Activity) context).finish();
  }

  public void editPassword(String user_password) {
    user_passwordEditor.clear();
    user_passwordEditor.putString(key_user_password, user_password);
    user_passwordEditor.commit();
    DataUser.getInstance().setUserPassword(user_password);
  }

  public HashMap<String, String> getUser() {
    HashMap<String, String> user = new HashMap<>();
    user.put(key_id_user, id_userPref.getString(key_id_user, null));
    user.put(key_user_name, user_namePref.getString(key_user_name, null));
    user.put(key_user_email, user_emailPref.getString(key_user_email, null));
    user.put(key_user_handphone_number,
        user_handphone_numberPref.getString(key_user_handphone_number, null));
    user.put(key_user_image, user_imagePref.getString(key_user_image, null));
    user.put(key_user_password, user_passwordPref.getString(key_user_password, null));
    user.put(key_user_verify_code, user_verify_codePref.getString(key_user_verify_code, null));
    user.put(key_user_verified_code,
        user_verified_codePref.getString(key_user_verified_code, null));
    user.put(key_user_gender, user_genderPref.getString(key_user_gender, null));
    user.put(key_user_apikey, user_apikeyPref.getString(key_user_apikey, null));
    return user;
  }

  public void checkLogin() {
    if (!this.is_login()) {
      Intent i = new Intent(context, LoginRegisterActivity.class);
      i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
      i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      context.startActivity(i);
      ((Activity) context).finish();
    } else {
      Intent i = new Intent(context, VerifyCodeActivity.class);
      i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
      i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      context.startActivity(i);
      ((Activity) context).finish();
    }
  }

  private boolean is_login() {
    return id_userPref.getBoolean(is_login, false);
  }

  public void logout() {
    this.clear();
    Intent i = new Intent(context, LoginRegisterActivity.class);
    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(i);
    ((Activity) context).finish();
  }

  public void clear() {
    id_userEditor.clear();
    user_nameEditor.clear();
    user_emailEditor.clear();
    user_handphone_numberEditor.clear();
    user_imageEditor.clear();
    user_passwordEditor.clear();
    user_verify_codeEditor.clear();
    user_verified_codeEditor.clear();
    user_genderEditor.clear();
    user_apikeyEditor.clear();

    id_userEditor.commit();
    user_nameEditor.commit();
    user_emailEditor.commit();
    user_handphone_numberEditor.commit();
    user_imageEditor.commit();
    user_passwordEditor.commit();
    user_verify_codeEditor.commit();
    user_verified_codeEditor.commit();
    user_genderEditor.commit();
    user_apikeyEditor.commit();
  }


  public boolean isFirstTimeLaunch() {
    return introPref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
  }

  public void setFirstTimeLaunch(boolean isFirstTime) {
    introEditor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
    introEditor.commit();
  }
}
