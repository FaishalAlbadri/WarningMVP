package com.faishalbadri.hijab.ui.home.activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.ui.home.fragment.account.AccountFragment;
import com.faishalbadri.hijab.ui.home.fragment.home.HomeFragment;
import com.faishalbadri.hijab.ui.home.fragment.other.OtherFragment;
import com.faishalbadri.hijab.util.ActivityUtil;

public class HomeActivity extends AppCompatActivity {

  @BindView(R.id.button_home_activity_home)
  Button buttonHomeActivityHome;
  @BindView(R.id.button_other_activity_home)
  Button buttonOtherActivityHome;
  @BindView(R.id.button_account_activity_home)
  Button buttonAccountActivityHome;
  ActivityUtil activityUtil;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    ButterKnife.bind(this);
    activityUtil = ActivityUtil.getInstance(getApplicationContext());
    homeFragment();
  }


  @Override
  public void onBackPressed() {

  }

  @OnClick(R.id.button_home_activity_home)
  public void onButtonHomeActivityHomeClicked() {
    homeFragment();
  }

  @OnClick(R.id.button_other_activity_home)
  public void onButtonOtherActivityHomeClicked() {
    otherFragment();
  }



  @OnClick(R.id.button_account_activity_home)
  public void onButtonAccountActivityHomeClicked() {
    accountFragment();
  }

  private void accountFragment() {
    activityUtil.addFragment(getSupportFragmentManager(), R.id.framelayout_for_fragment_activity_home, AccountFragment.instance());
  }

  private void homeFragment() {
    activityUtil.addFragment(getSupportFragmentManager(), R.id.framelayout_for_fragment_activity_home, HomeFragment.instance());
  }

  private void otherFragment() {
    activityUtil.addFragment(getSupportFragmentManager(), R.id.framelayout_for_fragment_activity_home, OtherFragment.instance());
  }

}