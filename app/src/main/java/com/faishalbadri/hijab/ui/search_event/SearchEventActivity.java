package com.faishalbadri.hijab.ui.search_event;

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
import com.faishalbadri.hijab.data.event.EventItem;
import com.faishalbadri.hijab.di.SearchEventRepositoryInject;
import com.faishalbadri.hijab.ui.event_by_city.EventByCityAdapter;
import com.faishalbadri.hijab.ui.search_event.SearchEventContract.SearchEventView;
import com.faishalbadri.hijab.util.UserUtil;
import java.util.ArrayList;
import java.util.List;

public class SearchEventActivity extends AppCompatActivity implements SearchEventView {

  @BindView(R.id.recyclerview_activity_search_event)
  RecyclerView recyclerviewActivitySearchEvent;
  @BindView(R.id.layout_no_internet_acces)
  RelativeLayout layoutNoInternetAcces;
  private String key;
  private SearchEventPresenter searchEventPresenter;
  private EventByCityAdapter adapter;
  private ArrayList<EventItem> resultItem;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_event);
    ButterKnife.bind(this);
    UserUtil.getInstance(getApplicationContext()).setDataUser();
    setView();
  }

  private void setView() {
    searchEventPresenter = new SearchEventPresenter(
        SearchEventRepositoryInject.provideToSearchEventRepository(this));
    searchEventPresenter.onAttachView(this);
    resultItem = new ArrayList<>();
    adapter = new EventByCityAdapter(this, resultItem);
    recyclerviewActivitySearchEvent.setLayoutManager(new LinearLayoutManager(this));
    recyclerviewActivitySearchEvent.setAdapter(adapter);
  }

  @Override
  public void onSuccesSearchEvent(List<EventItem> data, String msg) {
    resultItem.clear();
    resultItem.addAll(data);
    adapter.notifyDataSetChanged();
    recyclerviewActivitySearchEvent.setVisibility(View.VISIBLE);
    layoutNoInternetAcces.setVisibility(View.GONE);
  }

  @Override
  public void onWrongSearchEvent(String msg) {
    Toast.makeText(this, "Data tidak ada", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onErrorSearchEvent(String msg) {
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
        searchEventPresenter.getDataSearchEvent(key);
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
    searchEventPresenter.getDataSearchEvent(key);
  }
}
