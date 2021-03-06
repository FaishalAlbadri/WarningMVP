package com.faishalbadri.hijab.ui.search_news;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
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
import com.faishalbadri.hijab.data.news.NewsItem;
import com.faishalbadri.hijab.di.SearchNewsRepositoryInject;
import com.faishalbadri.hijab.ui.search_news.SearchNewsContract.SearchNewsView;
import com.faishalbadri.hijab.util.UserUtil;
import java.util.ArrayList;
import java.util.List;

public class SearchNewsActivity extends AppCompatActivity implements SearchNewsView {

  @BindView(R.id.recyclerview_activity_search_event)
  RecyclerView recyclerviewActivitySearchEvent;
  @BindView(R.id.layout_no_internet_acces)
  RelativeLayout layoutNoInternetAcces;
  private String key;
  private SearchNewsPresenter searchNewsPresenter;
  private SearchNewsAdapter adapter;
  private ArrayList<NewsItem> resultItem;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_news);
    ButterKnife.bind(this);
    UserUtil.getInstance(getApplicationContext()).setDataUser();
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
  public void onSuccesSearchNews(List<NewsItem> data, String msg) {
    resultItem.clear();
    resultItem.addAll(data);
    adapter.notifyDataSetChanged();
    recyclerviewActivitySearchEvent.setVisibility(View.VISIBLE);
    layoutNoInternetAcces.setVisibility(View.GONE);
  }

  @Override
  public void onWrongSearchNews(String msg) {
    Toast.makeText(this, "Data tidak ada", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onErrorSearchNews(String msg) {
    recyclerviewActivitySearchEvent.setVisibility(View.GONE);
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

  @OnClick(R.id.layout_no_internet_acces)
  public void onViewClicked() {
    searchNewsPresenter.getDataSearchNews(key);
  }
}
