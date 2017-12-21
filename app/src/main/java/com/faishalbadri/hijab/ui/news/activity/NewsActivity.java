package com.faishalbadri.hijab.ui.news.activity;

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
import com.faishalbadri.hijab.aaa_migration_server.ui.home.activity.HomeActivity;
import com.faishalbadri.hijab.ui.news.fragment.category.NewsCategoryFragment;
import com.faishalbadri.hijab.ui.news.fragment.news.NewsFragment;
import com.faishalbadri.hijab.ui.news.fragment.news_popular.NewsPopularFragment;
import com.faishalbadri.hijab.ui.search_news.SearchNewsActivity;
import com.faishalbadri.hijab.aaa_migration_server.util.ActivityUtil;

public class NewsActivity extends AppCompatActivity {

  ActivityUtil activityUtil;
  @BindView(R.id.button_news_activity_news)
  ImageButton buttonNewsActivityNews;
  @BindView(R.id.button_category_activity_news)
  ImageButton buttonCategoryActivityNews;
  @BindView(R.id.button_back_general_toolbar_search)
  ImageView buttonBackGeneralToolbarSearch;
  @BindView(R.id.textview_general_toolbar_search)
  TextView textviewGeneralToolbarSearch;
  @BindView(R.id.button_search_general_toolbar_search)
  ImageView buttonSearchGeneralToolbarSearch;
  @BindView(R.id.button_rank_activity_news)
  ImageButton buttonRankActivityNews;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_news);
    ButterKnife.bind(this);
    setView();
    newsFragment();
  }


  private void setView() {
    activityUtil = ActivityUtil.getInstance(getApplicationContext());
    textviewGeneralToolbarSearch.setText(R.string.text_pinky_hijab_news);
  }

  @OnClick(R.id.button_news_activity_news)
  public void onButtonNewsActivityNewsClicked() {
    newsFragment();
  }

  private void newsFragment() {
    activityUtil
        .addFragment(getSupportFragmentManager(), R.id.framelayout_for_fragment_activity_news,
            NewsFragment.instance());
  }

  @OnClick(R.id.button_category_activity_news)
  public void onButtonCategoryActivityNewsClicked() {
    categoryNews();
  }

  private void categoryNews() {
    activityUtil
        .addFragment(getSupportFragmentManager(), R.id.framelayout_for_fragment_activity_news,
            NewsCategoryFragment.instance());
  }

  @Override
  public void onBackPressed() {
    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
    finish();
  }

  @OnClick(R.id.button_back_general_toolbar_search)
  public void onButtonBackGeneralToolbarSearchClicked() {
    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
    finish();
  }

  @OnClick(R.id.button_search_general_toolbar_search)
  public void onButtonSearchGeneralToolbarSearchClicked() {
    startActivity(new Intent(getApplicationContext(), SearchNewsActivity.class));
  }

  @OnClick(R.id.button_rank_activity_news)
  public void onViewClicked() {
    newsPopular();
  }

  private void newsPopular() {
    activityUtil
        .addFragment(getSupportFragmentManager(), R.id.framelayout_for_fragment_activity_news,
            NewsPopularFragment.instance());
  }
}
