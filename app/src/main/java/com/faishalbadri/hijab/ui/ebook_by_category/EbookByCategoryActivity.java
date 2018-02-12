package com.faishalbadri.hijab.ui.ebook_by_category;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoEbook.EbookBean;
import com.faishalbadri.hijab.di.EbookByCategoryRepositoryInject;
import com.faishalbadri.hijab.ui.ebook_by_category.EbookByCategoryContract.ebookByCategoryView;
import com.faishalbadri.hijab.util.Singleton.DataServerProgress;
import com.faishalbadri.hijab.util.UserUtil;
import java.util.ArrayList;
import java.util.List;

public class EbookByCategoryActivity extends AppCompatActivity implements ebookByCategoryView {

  private static final String SAVE_DATA_EBOOK = "save";
  @BindView(R.id.button_back_general_toolbar_search)
  ImageView buttonBackGeneralToolbarSearch;
  @BindView(R.id.textview_general_toolbar_search)
  TextView textviewGeneralToolbarSearch;
  @BindView(R.id.button_search_general_toolbar_search)
  ImageView buttonSearchGeneralToolbarSearch;
  @BindView(R.id.recyclerview_activity_ebook_by_category)
  RecyclerView recyclerviewActivityEbookByCategory;
  String id, title;
  EbookByCategoryPresenter ebookCategoryPresenter;
  EbookByCategoryAdapter adapter;
  ArrayList<EbookBean> resultItem;
  @BindView(R.id.refresh_ebook_by_category)
  SwipeRefreshLayout refreshEbookByCategory;
  @BindView(R.id.layout_no_internet_acces)
  RelativeLayout layoutNoInternetAcces;
  @BindView(R.id.layout_loading)
  RelativeLayout layoutLoading;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ebook_by_category);
    ButterKnife.bind(this);
    UserUtil.getInstance(getApplicationContext()).setDataUser();
    setView();
    ebookCategoryPresenter.getDataEbookByCategory(id);

    refreshEbookByCategory.setOnRefreshListener(() -> {
      refreshEbookByCategory.setRefreshing(false);
      ebookCategoryPresenter.getDataEbookByCategory(id);

    });
  }

  private void setView() {
    buttonSearchGeneralToolbarSearch.setVisibility(View.INVISIBLE);
    id = getIntent().getStringExtra("category_id");
    title = getIntent().getStringExtra("category_title");
    textviewGeneralToolbarSearch.setText(title);
    ebookCategoryPresenter = new EbookByCategoryPresenter(
        EbookByCategoryRepositoryInject.provideToEbookCategoryRepositories(this));
    ebookCategoryPresenter.onAttachView(this);
    resultItem = new ArrayList<>();
    adapter = new EbookByCategoryAdapter(this, resultItem);
    recyclerviewActivityEbookByCategory.setLayoutManager(new GridLayoutManager(this, 2));
    recyclerviewActivityEbookByCategory.setAdapter(adapter);
    refreshEbookByCategory.setColorSchemeResources(
        android.R.color.holo_blue_bright,
        android.R.color.holo_green_light,
        android.R.color.holo_orange_light,
        android.R.color.holo_red_light);
  }

  @Override
  public void onSuccesEbookByCategory(List<EbookBean> data, String msg) {
    resultItem.clear();
    resultItem.addAll(data);
    adapter.notifyDataSetChanged();
    layoutNoInternetAcces.setVisibility(View.GONE);
    refreshEbookByCategory.setVisibility(View.VISIBLE);
    DataServerProgress.getInstance().onSuccesData(recyclerviewActivityEbookByCategory, layoutLoading);
  }

  @Override
  public void onErrorEbookByCategory(String msg) {
    layoutNoInternetAcces.setVisibility(View.VISIBLE);
    refreshEbookByCategory.setVisibility(View.GONE);
  }

  @OnClick(R.id.button_back_general_toolbar_search)
  public void onButtonBackGeneralToolbarSearchClicked() {
    onBackPressed();
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    finish();
  }

  @OnClick(R.id.layout_no_internet_acces)
  public void onViewClicked() {
    ebookCategoryPresenter.getDataEbookByCategory(id);
  }
}
