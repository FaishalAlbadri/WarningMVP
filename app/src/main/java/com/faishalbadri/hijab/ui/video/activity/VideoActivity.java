package com.faishalbadri.hijab.ui.video.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.ui.home.activity.HomeActivity;
import com.faishalbadri.hijab.ui.search_video.SearchVideoActivity;
import com.faishalbadri.hijab.ui.video.fragment.category_video.CategoryVideoFragment;
import com.faishalbadri.hijab.ui.video.fragment.video.VideoFragment;
import com.faishalbadri.hijab.util.ActivityUtil;
import com.faishalbadri.hijab.util.UserUtil;

public class VideoActivity extends AppCompatActivity {

  ActivityUtil activityUtil;
  @BindView(R.id.button_back_general_toolbar_search)
  ImageView buttonBackGeneralToolbarSearch;
  @BindView(R.id.textview_general_toolbar_search)
  TextView textviewGeneralToolbarSearch;
  @BindView(R.id.button_search_general_toolbar_search)
  ImageView buttonSearchGeneralToolbarSearch;
  @BindView(R.id.button_video_activity_video)
  Button buttonVideoActivityVideo;
  @BindView(R.id.button_category_activity_video)
  Button buttonCategoryActivityVideo;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_video);
    ButterKnife.bind(this);
    UserUtil.getInstance(getApplicationContext()).setDataUser();
    activityUtil = ActivityUtil.getInstance(getApplicationContext());
    textviewGeneralToolbarSearch.setText(R.string.text_pinky_hijab_video);
    videoFragment();
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

  @OnClick(R.id.button_back_general_toolbar_search)
  public void onButtonBackGeneralToolbarSearchClicked() {
    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
    finish();
  }

  @OnClick(R.id.button_search_general_toolbar_search)
  public void onButtonSearchGeneralToolbarSearchClicked() {
    startActivity(new Intent(getApplicationContext(), SearchVideoActivity.class));
  }

  @OnClick(R.id.button_video_activity_video)
  public void onButtonVideoActivityVideoClicked() {
    videoFragment();
  }

  @OnClick(R.id.button_category_activity_video)
  public void onButtonCategoryActivityVideoClicked() {
    categoryFragment();
  }
}
