package com.faishalbadri.hijab.aaa_migration_server.ui.ebook_by_category;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoEbook.EbookBean;
import com.faishalbadri.hijab.aaa_migration_server.di.EbookByCategoryRepositoryInject;
import com.faishalbadri.hijab.aaa_migration_server.ui.ebook_by_category.EbookByCategoryContract.ebookByCategoryView;
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

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ebook_by_category);
    ButterKnife.bind(this);
    setView();
    ebookCategoryPresenter.getDataEbookByCategory(id);

    refreshEbookByCategory.setOnRefreshListener(() -> {
      refreshEbookByCategory.setRefreshing(false);
      ebookCategoryPresenter.getDataEbookByCategory(id);

    });
  }

  @Override
  public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    super.onSaveInstanceState(outState, outPersistentState);
    outState.putParcelableArrayList(SAVE_DATA_EBOOK, resultItem);
  }

  private void setView() {
    buttonSearchGeneralToolbarSearch.setVisibility(View.INVISIBLE);
    id = getIntent().getStringExtra("id_category_ebook");
    title = getIntent().getStringExtra("title");
    textviewGeneralToolbarSearch.setText(title);
    ebookCategoryPresenter = new EbookByCategoryPresenter(
        EbookByCategoryRepositoryInject.provideToEbookCategoryRepositories(this));
    ebookCategoryPresenter.onAttachView(this);
    resultItem = new ArrayList<>();
    adapter = new EbookByCategoryAdapter(this, resultItem);
    recyclerviewActivityEbookByCategory.setLayoutManager(new GridLayoutManager(this, 3));
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
  }

  @Override
  public void onErrorEbookByCategory(String msg) {
    Toast.makeText(this, "check your internet connection", Toast.LENGTH_SHORT).show();
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
}
