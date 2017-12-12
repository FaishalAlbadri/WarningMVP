package com.faishalbadri.hijab.ui.news_by_category;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoNews;
import com.faishalbadri.hijab.data.PojoNews.IsiBean;
import com.faishalbadri.hijab.di.NewsByCategoryRepositoryInject;
import com.faishalbadri.hijab.ui.news_by_category.NewsByCategoryContract.NewsByCategoryView;
import java.util.ArrayList;
import java.util.List;

public class NewsByCategoryActivity extends AppCompatActivity implements NewsByCategoryView {

  private static final String save_news_category = "save_news_category";
  @BindView(R.id.button_back_general_toolbar_with_back_button)
  ImageView buttonBackGeneralToolbarWithBackButton;
  @BindView(R.id.textview_general_toolbar_with_back_button)
  TextView textviewGeneralToolbarWithBackButton;
  @BindView(R.id.recyclerview_activity_news_by_category)
  RecyclerView recyclerviewActivityNewsByCategory;
  String id, title;
  NewsByCategoryAdapter newsByCategoryAdapter;
  NewsByCategoryPresenter newsByCategoryPresenter;
  ArrayList<IsiBean> list_data;
  @BindView(R.id.refresh_news_by_category)
  SwipeRefreshLayout refreshNewsByCategory;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_news_by_category);
    ButterKnife.bind(this);
    setView();
    if (savedInstanceState != null) {
      ArrayList<IsiBean> resultArray = savedInstanceState
          .getParcelableArrayList(save_news_category);
      this.list_data.clear();
      this.list_data.addAll(resultArray);
      newsByCategoryAdapter.notifyDataSetChanged();
    } else {
      newsByCategoryPresenter.getDataNewsByCategory(id);
    }

    refreshNewsByCategory.setOnRefreshListener(new OnRefreshListener() {
      @Override
      public void onRefresh() {
        refreshNewsByCategory.setRefreshing(false);
        newsByCategoryPresenter.getDataNewsByCategory(id);
      }
    });
  }

  private void setView() {
    id = getIntent().getStringExtra("id_kategori");
    title = getIntent().getStringExtra("kategori_title");
    textviewGeneralToolbarWithBackButton.setText(title);
    newsByCategoryPresenter = new NewsByCategoryPresenter(
        NewsByCategoryRepositoryInject.provideToNewsByCategoryRepository(this));
    newsByCategoryPresenter.onAttachView(this);
    list_data = new ArrayList<>();
    newsByCategoryAdapter = new NewsByCategoryAdapter(this, list_data);
    recyclerviewActivityNewsByCategory.setLayoutManager(new LinearLayoutManager(this));
    recyclerviewActivityNewsByCategory.setAdapter(newsByCategoryAdapter);
    refreshNewsByCategory.setColorSchemeResources(
        android.R.color.holo_blue_bright,
        android.R.color.holo_green_light,
        android.R.color.holo_orange_light,
        android.R.color.holo_red_light);
  }

  @Override
  public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    super.onSaveInstanceState(outState, outPersistentState);
    outState.putParcelableArrayList(save_news_category, list_data);
  }

  @Override
  public void onSuccesNewsByCategory(List<IsiBean> data, String msg) {
    list_data.clear();
    list_data.addAll(data);
    newsByCategoryAdapter.notifyDataSetChanged();
  }

  @Override
  public void onErrorNewsByCategory(String msg) {

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
}
