package com.faishalbadri.hijab.aaa_migration_server.ui.login_register;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.aaa_migration_server.util.ActivityUtil;

public class LoginRegisterActivity extends AppCompatActivity {

  @BindView(R.id.button_login_activity_login_register)
  Button buttonLoginActivityLoginRegister;
  @BindView(R.id.button_register_activity_login_register)
  Button buttonRegisterActivityLoginRegister;
  ActivityUtil activityUtil;
  @BindView(R.id.view_segment_login)
  View viewSegmentLogin;
  @BindView(R.id.view_segment_register)
  View viewSegmentRegister;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(LayoutParams.FLAG_FULLSCREEN,
        LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.activity_login_register);
    ButterKnife.bind(this);
    activityUtil = ActivityUtil.getInstance(getApplicationContext());

    login();
  }


  @OnClick(R.id.button_login_activity_login_register)
  public void onButtonLoginActivityLoginRegisterClicked() {
    login();
  }

  @OnClick(R.id.button_register_activity_login_register)
  public void onButtonRegisterActivityLoginRegisterClicked() {
    register();
  }

  private void login() {
    activityUtil.addFragment(getSupportFragmentManager(),
        R.id.framelayout_for_fragment_activity_login_register, LoginFragment.instance());
    viewSegmentLogin.setVisibility(View.VISIBLE);
    viewSegmentRegister.setVisibility(View.INVISIBLE);
  }

  private void register() {
    activityUtil.addFragment(getSupportFragmentManager(),
        R.id.framelayout_for_fragment_activity_login_register, RegisterFragment.instance());
    viewSegmentRegister.setVisibility(View.VISIBLE);
    viewSegmentLogin.setVisibility(View.INVISIBLE);

  }

  @Override
  public void onBackPressed() {
    finish();
  }
}
