package com.faishalbadri.hijab.ui.splash_screen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.ui.intro.IntroActivity;
import com.faishalbadri.hijab.util.UserUtil;

public class SplashScreen extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.activity_splash_screen);
    UserUtil.getInstance(getApplicationContext()).setDataUser();
    Handler handler = new Handler();
    handler.postDelayed(() -> {
      startActivity(new Intent(getApplicationContext(), IntroActivity.class));
      finish();
    }, 3000);

  }

}
