package com.faishalbadri.hijab.ui.search_ebook;

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
import com.faishalbadri.hijab.data.PojoEbook.EbookBean;
import com.faishalbadri.hijab.di.SearchEbookRepositoryInject;
import com.faishalbadri.hijab.ui.search_ebook.SearchEbookContract.SearchEbookView;
import java.util.ArrayList;
import java.util.List;

public class SearchEbookActivity extends AppCompatActivity implements SearchEbookView {

  @BindView(R.id.edt_search_ebook)
  EditText edtSearchEbook;
  SearchEbookPresenter searchEbookPresenter;
  SearchEbookAdapter adapter;
  ArrayList<EbookBean> resultItem;
  private static final String SAVE_DATA_EBOOK_SEARCH = "save";
  @BindView(R.id.recyclerview_activity_search_ebook)
  RecyclerView recyclerviewActivitySearchEbook;
  String key;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_ebook);
    ButterKnife.bind(this);
    setView();
    edtSearchEbook.setOnEditorActionListener((TextView v, int actionId, KeyEvent event) -> {
      if (actionId == EditorInfo.IME_ACTION_SEARCH) {
        key = edtSearchEbook.getText().toString();
        searchEbookPresenter.getDataSearchEbook(key);
      }
      return false;
    });
  }

  private void setView() {
    searchEbookPresenter = new SearchEbookPresenter(
        SearchEbookRepositoryInject.provideToSearchEbookRepository(this));
    searchEbookPresenter.onAttachView(this);
    resultItem = new ArrayList<>();
//    adapter = new SearchEbookAdapter(this, resultItem);
    recyclerviewActivitySearchEbook.setLayoutManager(new LinearLayoutManager(this));
//    recyclerviewActivitySearchEbook.setAdapter(adapter);
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
//    adapter.notifyDataSetChanged();
  }

  @Override
  public void onWrongSearchEbook(String msg) {
    Toast.makeText(this, "wrong key", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onErrorSearchEbook(String msg) {
    Toast.makeText(this, "internal server error", Toast.LENGTH_SHORT).show();
  }
}
