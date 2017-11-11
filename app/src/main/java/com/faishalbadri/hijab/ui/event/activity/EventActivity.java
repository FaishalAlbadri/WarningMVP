package com.faishalbadri.hijab.ui.event.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.ui.event.fragment.event.EventFragment;
import com.faishalbadri.hijab.ui.event.fragment.event_city.EventCityFragment;
import com.faishalbadri.hijab.ui.home.activity.HomeActivity;
import com.faishalbadri.hijab.ui.home.fragment.account.AccountFragment;
import com.faishalbadri.hijab.ui.search_event.SearchEventActivity;
import com.faishalbadri.hijab.util.ActivityUtil;

public class EventActivity extends AppCompatActivity {

  @BindView(R.id.button_back_general_toolbar_search)
  ImageView buttonBackGeneralToolbarSearch;
  @BindView(R.id.textview_general_toolbar_search)
  TextView textviewGeneralToolbarSearch;
  @BindView(R.id.button_search_general_toolbar_search)
  ImageView buttonSearchGeneralToolbarSearch;
  @BindView(R.id.button_home_activity_event)
  ImageButton buttonHomeActivityEvent;
  @BindView(R.id.button_city_activity_event)
  ImageButton buttonCityActivityEvent;
  ActivityUtil activityUtil;
  String sessionEvent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_event);
    ButterKnife.bind(this);
    textviewGeneralToolbarSearch.setText(R.string.text_pinky_hijab_event);
    activityUtil = ActivityUtil.getInstance(getApplicationContext());
    homeFragment();
  }

  @OnClick(R.id.button_back_general_toolbar_search)
  public void onButtonBackGeneralToolbarSearchClicked() {
    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
    finish();
  }

  @OnClick(R.id.button_search_general_toolbar_search)
  public void onButtonSearchGeneralToolbarSearchClicked() {
    startActivity(new Intent(getApplicationContext(), SearchEventActivity.class));
  }

  @OnClick(R.id.button_home_activity_event)
  public void onButtonHomeActivityEventClicked() {
    homeFragment();
  }

  private void homeFragment() {
    activityUtil
        .addFragment(getSupportFragmentManager(), R.id.framelayout_for_fragment_activity_event,
            EventFragment.instance());
  }

  @OnClick(R.id.button_city_activity_event)
  public void onButtonCityActivityEventClicked() {
    cityFragment();
  }

  private void cityFragment() {
    activityUtil
        .addFragment(getSupportFragmentManager(), R.id.framelayout_for_fragment_activity_event,
            EventCityFragment.instance());
  }

  @Override
  public void onBackPressed() {
    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
    finish();
  }
}
