package com.faishalbadri.hijab.ui.splash_screen;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.util.SessionManager;

public class SplashScreen extends AppCompatActivity {

  SessionManager sessionSplash;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.activity_splash_screen);

    sessionSplash = new SessionManager(SplashScreen.this);

    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
      @Override
      public void run() {
        sessionSplash.checkLogin();
        finish();
      }
    },3000);

  }
}
