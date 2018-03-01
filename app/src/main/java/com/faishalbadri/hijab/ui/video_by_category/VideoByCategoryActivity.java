package com.faishalbadri.hijab.ui.video_by_category;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.videos.VideosItem;
import com.faishalbadri.hijab.di.VideoByCategoryRepositoryInject;
import com.faishalbadri.hijab.ui.video_by_category.VideoByCategoryContract.videoByCategoryView;
import com.faishalbadri.hijab.util.Singleton.DataServerProgress;
import com.faishalbadri.hijab.util.UserUtil;
import java.util.ArrayList;
import java.util.List;

public class VideoByCategoryActivity extends AppCompatActivity implements videoByCategoryView {


  @BindView(R.id.button_back_general_toolbar_with_back_button)
  ImageView buttonBackGeneralToolbarWithBackButton;
  @BindView(R.id.textview_general_toolbar_with_back_button)
  TextView textviewGeneralToolbarWithBackButton;
  @BindView(R.id.recyclerview_activity_video_by_category)
  RecyclerView recyclerviewActivityVideoByCategory;
  @BindView(R.id.refresh_video_by_category)
  SwipeRefreshLayout refreshVideoByCategory;
  @BindView(R.id.layout_no_internet_acces)
  RelativeLayout layoutNoInternetAcces;
  @BindView(R.id.layout_loading)
  RelativeLayout layoutLoading;
  private VideoByCategoryPresenter videoByCategoryPresenter;
  private VideoByCategoryAdapter videoByCategoryAdapter;
  private ArrayList<VideosItem> resultItem;
  private String id, title;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_video_by_category);
    ButterKnife.bind(this);
    UserUtil.getInstance(getApplicationContext()).setDataUser();
    setView();
    videoByCategoryPresenter.getDataVideoByCategory(id);
    refreshVideoByCategory.setOnRefreshListener(() -> {
      refreshVideoByCategory.setRefreshing(false);
      videoByCategoryPresenter.getDataVideoByCategory(id);
    });
  }

  private void setView() {
    id = getIntent().getStringExtra("category_id");
    title = getIntent().getStringExtra("category_title");
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
  public void onBackPressed() {
    super.onBackPressed();
    finish();
  }

  @Override
  public void onSuccesVideoByCategory(List<VideosItem> data, String msg) {
    resultItem.clear();
    resultItem.addAll(data);
    videoByCategoryAdapter.notifyDataSetChanged();
    refreshVideoByCategory.setVisibility(View.VISIBLE);
    layoutNoInternetAcces.setVisibility(View.GONE);
    DataServerProgress.getInstance().onSuccesData(recyclerviewActivityVideoByCategory, layoutLoading);
  }

  @Override
  public void onErrorVideoByCategory(String msg) {
    if (msg.equals("Data Null")) {
      layoutLoading.setVisibility(View.GONE);
      layoutNoInternetAcces.setVisibility(View.GONE);
      Toast.makeText(this, "Maaf Data Masih Kosong", Toast.LENGTH_SHORT).show();
    } else {
      layoutLoading.setVisibility(View.GONE);
      refreshVideoByCategory.setVisibility(View.GONE);
      layoutNoInternetAcces.setVisibility(View.VISIBLE);
    }
  }

  @OnClick(R.id.button_back_general_toolbar_with_back_button)
  public void onButtonBackGeneralToolbarWithBackButtonClicked() {
    onBackPressed();
  }

  @OnClick(R.id.layout_no_internet_acces)
  public void onLayoutNoInternetAccesClicked() {
    videoByCategoryPresenter.getDataVideoByCategory(id);
  }
}
