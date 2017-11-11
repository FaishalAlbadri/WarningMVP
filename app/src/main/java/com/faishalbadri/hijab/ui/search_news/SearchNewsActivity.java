package com.faishalbadri.hijab.ui.search_news;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoNews.IsiBean;
import com.faishalbadri.hijab.di.SearchNewsRepositoryInject;
import com.faishalbadri.hijab.ui.search_news.SearchNewsContract.SearchNewsView;
import java.util.ArrayList;
import java.util.List;

public class SearchNewsActivity extends AppCompatActivity implements SearchNewsView{

  @BindView(R.id.edt_search_news)
  EditText edtSearchNews;
  @BindView(R.id.recyclerview_activity_search_event)
  RecyclerView recyclerviewActivitySearchEvent;
  private static final String SAVE_DATA_NEWS_SEARCH = "save";
  String key;
  SearchNewsPresenter searchEventPresenter;
  SearchNewsAdapter adapter;
  ArrayList<IsiBean> resultItem;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_seaerch_news);
    ButterKnife.bind(this);
    setView();
    edtSearchNews.setOnEditorActionListener((TextView v, int actionId, KeyEvent event) -> {
      if (actionId == EditorInfo.IME_ACTION_SEARCH) {
        key = edtSearchNews.getText().toString();
        searchEventPresenter.getDataSearchNews(key);
      }
      return false;
    });
  }

  private void setView() {
    searchEventPresenter = new SearchNewsPresenter(
        SearchNewsRepositoryInject.provideToSearchNewsRepository(this));
    searchEventPresenter.onAttachView(this);
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
}
