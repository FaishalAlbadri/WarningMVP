package com.faishalbadri.hijab.ui.search_video;

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
import com.faishalbadri.hijab.data.videos.VideosItem;
import com.faishalbadri.hijab.di.SearchVideoRepositoryInject;
import com.faishalbadri.hijab.ui.search_video.SearchVideoContract.SearchVideoView;
import com.faishalbadri.hijab.util.UserUtil;
import java.util.ArrayList;
import java.util.List;

public class SearchVideoActivity extends AppCompatActivity implements SearchVideoView {

  @BindView(R.id.recyclerview_activity_search_video)
  RecyclerView recyclerviewActivitySearchVideo;
  @BindView(R.id.layout_no_internet_acces)
  RelativeLayout layoutNoInternetAcces;
  private SearchVideoPresenter searchVideoPresenter;
  private SearchVideoAdapter adapter;
  private ArrayList<VideosItem> resultItem;
  private String key;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_video);
    ButterKnife.bind(this);
    UserUtil.getInstance(getApplicationContext()).setDataUser();
    setView();

  }

  private void setView() {
    searchVideoPresenter = new SearchVideoPresenter(
        SearchVideoRepositoryInject.provideToSearchVideoRepository(this));
    searchVideoPresenter.onAttachView(this);
    resultItem = new ArrayList<>();
    adapter = new SearchVideoAdapter(this, resultItem);
    recyclerviewActivitySearchVideo.setLayoutManager(new LinearLayoutManager(this));
    recyclerviewActivitySearchVideo.setAdapter(adapter);
  }

  @Override
  public void onSuccesSearchVideo(List<VideosItem> data, String msg) {
    resultItem.clear();
    resultItem.addAll(data);
    adapter.notifyDataSetChanged();
    recyclerviewActivitySearchVideo.setVisibility(View.VISIBLE);
    layoutNoInternetAcces.setVisibility(View.GONE);
  }

  @Override
  public void onWrongSearchVideo(String msg) {
    Toast.makeText(this, "Data tidak ada", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onErrorSearchVideo(String msg) {
    recyclerviewActivitySearchVideo.setVisibility(View.GONE);
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
        searchVideoPresenter.getDataSearchVideo(key);
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
    searchVideoPresenter.getDataSearchVideo(key);
  }
}
