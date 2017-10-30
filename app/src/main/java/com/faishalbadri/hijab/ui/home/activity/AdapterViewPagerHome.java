package com.faishalbadri.hijab.ui.home.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by faishal on 10/30/17.
 */

public class AdapterViewPagerHome extends FragmentPagerAdapter {

  private final List<Fragment> fragmentList = new ArrayList<>();
  private final List<String> namelist = new ArrayList<>();

  public AdapterViewPagerHome(FragmentManager fm) {
    super(fm);
  }

  @Override
  public Fragment getItem(int position) {
    return fragmentList.get(position);
  }

  @Override
  public int getCount() {
    return fragmentList.size();
  }

  public void addFragment(Fragment fragment, String title) {
    fragmentList.add(fragment);
    namelist.add(title);
  }

  @Override
  public CharSequence getPageTitle(int position) {
    return namelist.get(position);
  }
}
