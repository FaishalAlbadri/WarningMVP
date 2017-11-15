package com.faishalbadri.hijab.ui.ebook_by_category;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
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
import com.faishalbadri.hijab.data.PojoEbook.EbookBean;
import com.faishalbadri.hijab.di.EbookByCategoryRepositoryInject;
import com.faishalbadri.hijab.ui.ebook.activity.EbookActivity;
import com.faishalbadri.hijab.ui.ebook_by_category.EbookByCategoryContract.ebookByCategoryView;
import java.util.ArrayList;
import java.util.List;

public class EbookByCategoryActivity extends AppCompatActivity implements ebookByCategoryView {

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
  private static final String SAVE_DATA_EBOOK = "save";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ebook_by_category);
    ButterKnife.bind(this);
    setView();
    ebookCategoryPresenter.getDataEbookByCategory(id);
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