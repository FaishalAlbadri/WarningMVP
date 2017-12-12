package com.faishalbadri.hijab.ui.search_ebook;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoEbook.EbookBean;
import com.faishalbadri.hijab.di.SearchEbookRepositoryInject;
import com.faishalbadri.hijab.ui.ebook.fragment.ebook_all.EbookAdapter;
import com.faishalbadri.hijab.ui.search_ebook.SearchEbookContract.SearchEbookView;
import java.util.ArrayList;
import java.util.List;

public class SearchEbookActivity extends AppCompatActivity implements SearchEbookView {

  private static final String SAVE_DATA_EBOOK_SEARCH = "save";
  SearchEbookPresenter searchEbookPresenter;
  EbookAdapter adapter;
  ArrayList<EbookBean> resultItem;
  @BindView(R.id.recyclerview_activity_search_ebook)
  RecyclerView recyclerviewActivitySearchEbook;
  String key;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_ebook);
    ButterKnife.bind(this);
    setView();
  }

  private void setView() {
    searchEbookPresenter = new SearchEbookPresenter(
        SearchEbookRepositoryInject.provideToSearchEbookRepository(this));
    searchEbookPresenter.onAttachView(this);
    resultItem = new ArrayList<>();
    adapter = new EbookAdapter(this, resultItem);
    recyclerviewActivitySearchEbook.setLayoutManager(new GridLayoutManager(this, 3));
    recyclerviewActivitySearchEbook.setAdapter(adapter);
  }

  @Override
  public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    super.onSaveInstanceState(outState, outPersistentState);
    outState.putParcelableArrayList(SAVE_DATA_EBOOK_SEARCH, resultItem);
  }

  @Override
  public void onSuccesSearchEbook(List<EbookBean> data, String msg) {
    resultItem.clear();
    resultItem.addAll(data);
    adapter.notifyDataSetChanged();
  }

  @Override
  public void onWrongSearchEbook(String msg) {
    Toast.makeText(this, "wrong key", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onErrorSearchEbook(String msg) {
    Toast.makeText(this, "internal server error", Toast.LENGTH_SHORT).show();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_search, menu);
    MenuItem searchItem = menu.findItem(R.id.search);
    final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
}
