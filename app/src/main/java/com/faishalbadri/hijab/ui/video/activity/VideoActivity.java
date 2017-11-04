package com.faishalbadri.hijab.ui.video.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.ui.home.activity.HomeActivity;
import com.faishalbadri.hijab.ui.video.fragment.category_video.CategoryVideoFragment;
import com.faishalbadri.hijab.ui.video.fragment.search_video.SearchFragment;
import com.faishalbadri.hijab.ui.video.fragment.video.VideoFragment;
import com.faishalbadri.hijab.util.ActivityUtil;

public class VideoActivity extends AppCompatActivity {

  @BindView(R.id.button_video_activity_video)
  Button buttonVideoActivityVideo;
  @BindView(R.id.button_other_activity_video)
  Button buttonOtherActivityVideo;
  @BindView(R.id.button_account_activity_video)
  Button buttonAccountActivityVideo;
  ActivityUtil activityUtil;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_video);
    ButterKnife.bind(this);
    activityUtil = ActivityUtil.getInstance(getApplicationContext());
    setFragment();
  }

  private void setFragment() {
    videoFragment();
  }

  @OnClick(R.id.button_video_activity_video)
  public void onButtonVideoActivityVideoClicked() {
    videoFragment();
  }

  @OnClick(R.id.button_other_activity_video)
  public void onButtonOtherActivityVideoClicked() {
    categoryFragment();
  }

  @OnClick(R.id.button_account_activity_video)
  public void onButtonAccountActivityVideoClicked() {
    searchFragment();
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
    finish();
  }

  private void videoFragment() {
    activityUtil
        .addFragment(getSupportFragmentManager(), R.id.framelayout_for_fragment_activity_video,
            VideoFragment.instance());

  }

  private void categoryFragment() {
    activityUtil
        .addFragment(getSupportFragmentManager(), R.id.framelayout_for_fragment_activity_video,
            CategoryVideoFragment.instance());

  }

  private void searchFragment() {
    activityUtil
        .addFragment(getSupportFragmentManager(), R.id.framelayout_for_fragment_activity_video,
            SearchFragment.instance());

  }

}
