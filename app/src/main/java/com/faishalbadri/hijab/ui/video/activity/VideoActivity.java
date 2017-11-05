package com.faishalbadri.hijab.ui.video.activity;

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
import com.faishalbadri.hijab.ui.home.activity.HomeActivity;
import com.faishalbadri.hijab.ui.video.fragment.category_video.CategoryVideoFragment;
import com.faishalbadri.hijab.ui.video.fragment.video.VideoFragment;
import com.faishalbadri.hijab.util.ActivityUtil;

public class VideoActivity extends AppCompatActivity {

  @BindView(R.id.button_video_activity_video)
  ImageButton buttonVideoActivityVideo;
  @BindView(R.id.button_other_activity_video)
  ImageButton buttonOtherActivityVideo;
  @BindView(R.id.button_account_activity_video)
  ImageButton buttonAccountActivityVideo;
  ActivityUtil activityUtil;
  @BindView(R.id.button_back_general_toolbar_with_back_button)
  ImageView buttonBackGeneralToolbarWithBackButton;
  @BindView(R.id.textview_general_toolbar_with_back_button)
  TextView textviewGeneralToolbarWithBackButton;
  String sessionVideo;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_video);
    ButterKnife.bind(this);
    activityUtil = ActivityUtil.getInstance(getApplicationContext());
    textviewGeneralToolbarWithBackButton.setText(R.string.text_pinky_hijab_video);
    setFragment();
  }

  private void setFragment() {
    try {
      sessionVideo = getIntent().getStringExtra("session_video");
      if (sessionVideo == null) {
        videoFragment();
      } else if (sessionVideo.equals("1")) {
        categoryFragment();
      }

    } catch (Exception e) {

    }
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

  }

  @Override
  public void onBackPressed() {
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


  @OnClick(R.id.button_back_general_toolbar_with_back_button)
  public void onViewClicked() {
    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
    finish();
  }
}
