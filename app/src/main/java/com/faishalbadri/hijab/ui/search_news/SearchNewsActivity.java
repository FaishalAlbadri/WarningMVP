package com.faishalbadri.hijab.ui.search_news;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoNews.IsiBean;
import com.faishalbadri.hijab.revamp.di.SearchNewsRepositoryInject;
import com.faishalbadri.hijab.ui.search_news.SearchNewsContract.SearchNewsView;
import java.util.ArrayList;
import java.util.List;

public class SearchNewsActivity extends AppCompatActivity implements SearchNewsView {

  private static final String SAVE_DATA_NEWS_SEARCH = "save";
  @BindView(R.id.recyclerview_activity_search_event)
  RecyclerView recyclerviewActivitySearchEvent;
  String key;
  SearchNewsPresenter searchNewsPresenter;
  SearchNewsAdapter adapter;
  ArrayList<IsiBean> resultItem;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_seaerch_news);
    ButterKnife.bind(this);
    setView();
  }

  private void setView() {
    setTitle("Search News Here");
    searchNewsPresenter = new SearchNewsPresenter(
        SearchNewsRepositoryInject.provideToSearchNewsRepository(this));
    searchNewsPresenter.onAttachView(this);
    resultItem = new ArrayList<>();
    adapter = new SearchNewsAdapter(this, resultItem);
    recyclerviewActivitySearchEvent.setLayoutManager(new LinearLayoutManager(this));
    recyclerviewActivitySearchEvent.setAdapter(adapter);
  }

  @Override
  public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    super.onSaveInstanceState(outState, outPersistentState);
    outState.putParcelableArrayList(SAVE_DATA_NEWS_SEARCH, resultItem);
  }

  @Override
  public void onSuccesSearchNews(List<IsiBean> data, String msg) {
    resultItem.clear();
    resultItem.addAll(data);
    adapter.notifyDataSetChanged();
  }

  @Override
  public void onWrongSearchNews(String msg) {
    Toast.makeText(this, "wrong key", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onErrorSearchNews(String msg) {
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
        searchNewsPresenter.getDataSearchNews(key);
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
