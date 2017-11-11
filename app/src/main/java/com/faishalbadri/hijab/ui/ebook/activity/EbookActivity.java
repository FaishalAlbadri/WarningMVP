package com.faishalbadri.hijab.ui.ebook.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.ui.ebook.fragment.category.EbookCategoryFragment;
import com.faishalbadri.hijab.ui.ebook.fragment.ebook_all.EbookFragment;
import com.faishalbadri.hijab.ui.home.activity.HomeActivity;
import com.faishalbadri.hijab.ui.search_ebook.SearchEbookActivity;
import com.faishalbadri.hijab.util.ActivityUtil;

public class EbookActivity extends AppCompatActivity {


  @BindView(R.id.button_back_general_toolbar_search)
  ImageView buttonBackGeneralToolbarSearch;
  @BindView(R.id.textview_general_toolbar_search)
  TextView textviewGeneralToolbarSearch;
  @BindView(R.id.button_search_general_toolbar_search)
  ImageView buttonSearchGeneralToolbarSearch;
  @BindView(R.id.button_all_activity_ebook)
  ImageButton buttonAllActivityEbook;
  @BindView(R.id.button_category_activity_ebook)
  ImageButton buttonCategoryActivityEbook;
  ActivityUtil activityUtil;
  String sessionEbook;
  SearchView searchView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ebook);
    ButterKnife.bind(this);
    activityUtil = ActivityUtil.getInstance(getApplicationContext());
    textviewGeneralToolbarSearch.setText(R.string.text_pinky_hijab_ebook);
    ebookFragment();
  }

  private void ebookCategoryFragment() {
    activityUtil
        .addFragment(getSupportFragmentManager(), R.id.framelayout_for_fragment_activity_ebook,
            EbookCategoryFragment.instance());
  }

  private void ebookFragment() {
    activityUtil
        .addFragment(getSupportFragmentManager(), R.id.framelayout_for_fragment_activity_ebook,
            EbookFragment.instance());
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
    startActivity(new Intent(getApplicationContext(), SearchEbookActivity.class));
  }

  @OnClick(R.id.button_all_activity_ebook)
  public void onButtonAllActivityEbookClicked() {
    ebookFragment();
  }

  @OnClick(R.id.button_category_activity_ebook)
  public void onButtonCategoryActivityEbookClicked() {
    ebookCategoryFragment();
  }

}
