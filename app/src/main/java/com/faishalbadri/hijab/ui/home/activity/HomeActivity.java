package com.faishalbadri.hijab.ui.home.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.ui.home.fragment.account.AccountFragment;
import com.faishalbadri.hijab.ui.home.fragment.other.OtherFragment;
import com.faishalbadri.hijab.ui.home.fragment.home.HomeFragment;

public class HomeActivity extends AppCompatActivity {

  @BindView(R.id.tablayout_activity_home)
  TabLayout tablayoutActivityHome;
  @BindView(R.id.view_pager_activity_home)
  ViewPager viewPagerActivityHome;

  String email;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    ButterKnife.bind(this);
    setView();
  }

  private void setView() {
    setupViewPager(viewPagerActivityHome);
    tablayoutActivityHome.setupWithViewPager(viewPagerActivityHome);
  }

  private void setupViewPager(ViewPager viewPagerActivityHome) {
    AdapterViewPagerHome adapterViewPagerHome = new AdapterViewPagerHome(getSupportFragmentManager());
    adapterViewPagerHome.addFragment(new HomeFragment(),"Home");
    adapterViewPagerHome.addFragment(new AccountFragment(),"Account");
    adapterViewPagerHome.addFragment(new OtherFragment(),"Other");
    viewPagerActivityHome.setAdapter(adapterViewPagerHome);
  }

  @Override
  public void onBackPressed() {

  }
}
