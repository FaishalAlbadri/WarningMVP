package com.faishalbadri.hijab.ui.home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.ui.home.fragment.AccountFragment;
import com.faishalbadri.hijab.ui.home.fragment.OtherFragment;
import com.faishalbadri.hijab.ui.home.fragment.SettingFragment;
import com.faishalbadri.hijab.ui.home.fragment.HomeFragment;

public class HomeActivity extends AppCompatActivity {

  @BindView(R.id.tablayout_activity_home)
  TabLayout tablayoutActivityHome;
  @BindView(R.id.view_pager_activity_home)
  ViewPager viewPagerActivityHome;

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
    adapterViewPagerHome.addFragment(new SettingFragment(),"Setting");
    adapterViewPagerHome.addFragment(new OtherFragment(),"Other");
    adapterViewPagerHome.addFragment(new AccountFragment(),"My Account");
    viewPagerActivityHome.setAdapter(adapterViewPagerHome);
  }

  @Override
  public void onBackPressed() {

  }
}
