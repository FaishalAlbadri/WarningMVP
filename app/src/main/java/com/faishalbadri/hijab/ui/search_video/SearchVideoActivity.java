package com.faishalbadri.hijab.ui.search_video;

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
import com.faishalbadri.hijab.data.PojoVideo;
import com.faishalbadri.hijab.di.SearchVideoRepositoryInject;
import com.faishalbadri.hijab.ui.search_video.SearchVideoContract.SearchVideoView;
import com.faishalbadri.hijab.ui.video.fragment.video.VideoAdapter;
import java.util.ArrayList;
import java.util.List;

public class SearchVideoActivity extends AppCompatActivity implements SearchVideoView {

  private static final String SAVE_DATA_VIDEO_SEARCH = "save";
  SearchVideoPresenter searchVideoPresenter;
  VideoAdapter adapter;
  ArrayList<PojoVideo.VideosBean> resultItem;
  @BindView(R.id.recyclerview_activity_search_video)
  RecyclerView recyclerviewActivitySearchVideo;
  String key;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_video);
    ButterKnife.bind(this);
    setView();

  }

  private void setView() {
    searchVideoPresenter = new SearchVideoPresenter(
        SearchVideoRepositoryInject.provideToSearchVideoRepository(this));
    searchVideoPresenter.onAttachView(this);
    resultItem = new ArrayList<>();
    adapter = new VideoAdapter(this, resultItem);
    recyclerviewActivitySearchVideo.setLayoutManager(new LinearLayoutManager(this));
    recyclerviewActivitySearchVideo.setAdapter(adapter);
  }

  @Override
  public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    super.onSaveInstanceState(outState, outPersistentState);
    outState.putParcelableArrayList(SAVE_DATA_VIDEO_SEARCH, resultItem);
  }

  @Override
  public void onSuccesSearchVideo(List<PojoVideo.VideosBean> data, String msg) {
    resultItem.clear();
    resultItem.addAll(data);
    adapter.notifyDataSetChanged();
  }

  @Override
  public void onWrongSearchVideo(String msg) {
    Toast.makeText(this, "wrong key", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onErrorSearchVideo(String msg) {
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
}
