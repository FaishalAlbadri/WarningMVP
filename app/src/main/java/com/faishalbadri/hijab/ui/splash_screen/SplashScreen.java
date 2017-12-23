package com.faishalbadri.hijab.ui.splash_screen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.ui.intro.IntroActivity;
import com.faishalbadri.hijab.util.SessionManager;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import java.util.HashMap;

public class SplashScreen extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.activity_splash_screen);
    setSingletonData();
    Handler handler = new Handler();
    handler.postDelayed(() -> {
      startActivity(new Intent(getApplicationContext(), IntroActivity.class));
      finish();
    }, 3000);

  }

  private void setSingletonData() {
    SessionManager sessionManager = new SessionManager(getApplicationContext());
    HashMap<String, String> hashMap = sessionManager.getUser();
    DataUser.getInstance().setUserId(hashMap.get(SessionManager.key_id_user));
    DataUser.getInstance().setUserName(hashMap.get(SessionManager.key_user_name));
    DataUser.getInstance().setUserEmail(hashMap.get(SessionManager.key_user_email));
    DataUser.getInstance().setUserPassword(hashMap.get(SessionManager.key_user_password));
    DataUser.getInstance()
        .setUserHandphoneNumber(hashMap.get(SessionManager.key_user_handphone_number));
    DataUser.getInstance().setUserImage(hashMap.get(SessionManager.key_user_image));
    DataUser.getInstance().setUserVerifyCode(hashMap.get(SessionManager.key_user_verify_code));
    DataUser.getInstance().setUserVerifiedCode(hashMap.get(SessionManager.key_user_verified_code));
    DataUser.getInstance().setUserGender(hashMap.get(SessionManager.key_user_gender));
    DataUser.getInstance().setUserApiKey(hashMap.get(SessionManager.key_user_apikey));
  }

}
