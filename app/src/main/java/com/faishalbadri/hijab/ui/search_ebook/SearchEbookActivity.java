package com.faishalbadri.hijab.ui.search_ebook;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.ebook.EbookItem;
import com.faishalbadri.hijab.di.SearchEbookRepositoryInject;
import com.faishalbadri.hijab.ui.search_ebook.SearchEbookContract.SearchEbookView;
import com.faishalbadri.hijab.util.UserUtil;
import java.util.ArrayList;
import java.util.List;

public class SearchEbookActivity extends AppCompatActivity implements SearchEbookView {

  ArrayList<EbookItem> resultItem;
  @BindView(R.id.recyclerview_activity_search_ebook)
  RecyclerView recyclerviewActivitySearchEbook;
  @BindView(R.id.layout_no_internet_acces)
  RelativeLayout layoutNoInternetAcces;
  private SearchEbookPresenter searchEbookPresenter;
  private SearchEbookAdapter adapter;
  private String key;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_ebook);
    ButterKnife.bind(this);
    UserUtil.getInstance(getApplicationContext()).setDataUser();
    setView();
  }

  private void setView() {
    searchEbookPresenter = new SearchEbookPresenter(
        SearchEbookRepositoryInject.provideToSearchEbookRepository(this));
    searchEbookPresenter.onAttachView(this);
    resultItem = new ArrayList<>();
    adapter = new SearchEbookAdapter(this, resultItem);
    recyclerviewActivitySearchEbook.setLayoutManager(new GridLayoutManager(this, 2));
    recyclerviewActivitySearchEbook.setAdapter(adapter);
  }

  @Override
  public void onSuccesSearchEbook(List<EbookItem> data, String msg) {
    resultItem.clear();
    resultItem.addAll(data);
    adapter.notifyDataSetChanged();
    recyclerviewActivitySearchEbook.setVisibility(View.VISIBLE);
    layoutNoInternetAcces.setVisibility(View.GONE);
  }

  @Override
  public void onWrongSearchEbook(String msg) {
    Toast.makeText(this, "Data tidak ada", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onErrorSearchEbook(String msg) {
    recyclerviewActivitySearchEbook.setVisibility(View.GONE);
    layoutNoInternetAcces.setVisibility(View.VISIBLE);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_search, menu);
    MenuItem searchItem = menu.findItem(R.id.search);
    final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
    searchView.setOnQueryTextListener(new OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String query) {
        key = query;
        searchEbookPresenter.getDataSearchEbook(key);
        searchView.clearFocus();
        setTitle(key);
        return true;
      }

      @Override
      public boolean onQueryTextChange(String newText) {

        return false;
      }


    });
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    finish();
  }

  @OnClick(R.id.layout_no_internet_acces)
  public void onViewClicked() {
    searchEbookPresenter.getDataSearchEbook(key);
  }
}
