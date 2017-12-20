package com.faishalbadri.hijab.ui.video_by_category;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoVideo.VideoBean;
import com.faishalbadri.hijab.revamp.di.VideoByCategoryRepositoryInject;
import com.faishalbadri.hijab.ui.video_by_category.VideoByCategoryContract.videoByCategoryView;
import java.util.ArrayList;
import java.util.List;

public class VideoByCategoryActivity extends AppCompatActivity implements videoByCategoryView {


  private static final String SAVE_DATA_VIDEO_PERKAT = "save";
  VideoByCategoryPresenter videoByCategoryPresenter;
  VideoByCategoryAdapter videoByCategoryAdapter;
  ArrayList<VideoBean> resultItem;
  String id, title;
  @BindView(R.id.button_back_general_toolbar_with_back_button)
  ImageView buttonBackGeneralToolbarWithBackButton;
  @BindView(R.id.textview_general_toolbar_with_back_button)
  TextView textviewGeneralToolbarWithBackButton;
  @BindView(R.id.recyclerview_activity_video_by_category)
  RecyclerView recyclerviewActivityVideoByCategory;
  @BindView(R.id.refresh_video_by_category)
  SwipeRefreshLayout refreshVideoByCategory;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_video_by_category);
    ButterKnife.bind(this);
    setView();
    if (savedInstanceState != null) {
      ArrayList<VideoBean> resultArray = savedInstanceState
          .getParcelableArrayList(SAVE_DATA_VIDEO_PERKAT);
      this.resultItem.clear();
      this.resultItem.addAll(resultArray);
      videoByCategoryAdapter.notifyDataSetChanged();
    } else {
      videoByCategoryPresenter.getDataVideoByCategory(id);
    }

    refreshVideoByCategory.setOnRefreshListener(() -> {
      refreshVideoByCategory.setRefreshing(false);
      videoByCategoryPresenter.getDataVideoByCategory(id);
    });
  }

  private void setView() {
    id = getIntent().getStringExtra("id");
    title = getIntent().getStringExtra("kategori");
    textviewGeneralToolbarWithBackButton.setText(title);
    videoByCategoryPresenter = new VideoByCategoryPresenter(
        VideoByCategoryRepositoryInject.provideToVideoByCategoryRepository(this));
    videoByCategoryPresenter.onAttachView(this);
    resultItem = new ArrayList<>();
    videoByCategoryAdapter = new VideoByCategoryAdapter(this, resultItem);
    recyclerviewActivityVideoByCategory.setLayoutManager(new LinearLayoutManager(this));
    recyclerviewActivityVideoByCategory.setAdapter(videoByCategoryAdapter);
    refreshVideoByCategory.setColorSchemeResources(
        android.R.color.holo_blue_bright,
        android.R.color.holo_green_light,
        android.R.color.holo_orange_light,
        android.R.color.holo_red_light);
  }

  @Override
  public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    super.onSaveInstanceState(outState, outPersistentState);
    outState.putParcelableArrayList(SAVE_DATA_VIDEO_PERKAT, resultItem);
  }


  @OnClick(R.id.button_back_general_toolbar_with_back_button)
  public void onViewClicked() {
    onBackPressed();
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    finish();
  }

  @Override
  public void onSuccesVideoByCategory(List<VideoBean> data, String msg) {
    resultItem.clear();
    resultItem.addAll(data);
    videoByCategoryAdapter.notifyDataSetChanged();
  }

  @Override
  public void onErrorVideoByCategory(String msg) {

  }
}
