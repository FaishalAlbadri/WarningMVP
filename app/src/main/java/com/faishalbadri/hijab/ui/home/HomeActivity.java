package com.faishalbadri.hijab.ui.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.util.SessionManager;
import java.util.HashMap;

public class HomeActivity extends AppCompatActivity {

  SessionManager sessionHome;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    sessionHome = new SessionManager(getApplicationContext());
    HashMap<String, String> user = sessionHome.getUserDetails();
    Toast.makeText(this, user.toString(), Toast.LENGTH_SHORT).show();
  }
}
