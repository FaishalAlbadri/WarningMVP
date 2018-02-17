package com.faishalbadri.hijab.ui.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.ui.change.password.ChangePasswordFragment;
import com.faishalbadri.hijab.ui.home.fragment.account.AccountFragment;
import com.faishalbadri.hijab.ui.home.fragment.home.HomeFragment;
import com.faishalbadri.hijab.ui.home.fragment.other.OtherFragment;
import com.faishalbadri.hijab.util.ActivityUtil;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import com.faishalbadri.hijab.util.UserUtil;

public class HomeActivity extends AppCompatActivity {

  @BindView(R.id.button_home_activity_home)
  Button buttonHomeActivityHome;
  @BindView(R.id.button_other_activity_home)
  Button buttonOtherActivityHome;
  @BindView(R.id.button_account_activity_home)
  Button buttonAccountActivityHome;
  @BindView(R.id.linear_layout_tab_activity_home)
  LinearLayout linearLayoutTabActivityHome;
  @BindView(R.id.framelayout_for_fragment_activity_home)
  FrameLayout framelayoutForFragmentActivityHome;
  private ActivityUtil activityUtil;
  private String sessionHome;
  private DataUser dataUser;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    ButterKnife.bind(this);
    UserUtil.getInstance(getApplicationContext()).setDataUser();
    activityUtil = ActivityUtil.getInstance(getApplicationContext());
    setFragment();
    dataUser = DataUser.getInstance();
    Log.i("Response",
        "id_user = " + dataUser.getUserId() + "\nusername = " + dataUser.getUserName());
  }


  private void setFragment() {
    try {
      sessionHome = getIntent().getStringExtra("session_home");
      if (sessionHome == null) {
        homeFragment();
      } else if (sessionHome.equals("1")) {
        otherFragment();
      }

    } catch (Exception e) {

    }
  }


  @Override
  public void onBackPressed() {
    if (linearLayoutTabActivityHome.getVisibility() == View.GONE) {
      linearLayoutTabActivityHome.setVisibility(View.VISIBLE);
    }
    if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
      getFragmentManager().popBackStack();
      super.onBackPressed();
    } else {
      startActivity(new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME)
          .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
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

  public void changePasswordFragment() {
    activityUtil
        .addFragment(getSupportFragmentManager(), R.id.framelayout_for_fragment_activity_home,
            ChangePasswordFragment.instance());
    linearLayoutTabActivityHome.setVisibility(View.GONE);
  }

  private void accountFragment() {
    activityUtil
        .addFragment(getSupportFragmentManager(), R.id.framelayout_for_fragment_activity_home,
            AccountFragment.instance());
  }

  private void homeFragment() {
    activityUtil
        .addFragment(getSupportFragmentManager(), R.id.framelayout_for_fragment_activity_home,
            HomeFragment.instance());
  }

  private void otherFragment() {
    activityUtil
        .addFragment(getSupportFragmentManager(), R.id.framelayout_for_fragment_activity_home,
            OtherFragment.instance());
  }
}
