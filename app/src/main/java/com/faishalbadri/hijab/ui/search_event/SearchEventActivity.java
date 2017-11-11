package com.faishalbadri.hijab.ui.search_event;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.TextInputLayout;
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
import com.faishalbadri.hijab.data.PojoEvent.EventBean;
import com.faishalbadri.hijab.di.SearchEventRepositoryInject;
import com.faishalbadri.hijab.ui.search_ebook.SearchEbookContract.SearchEbookView;
import com.faishalbadri.hijab.ui.search_event.SearchEventContract.SearchEventView;
import java.util.ArrayList;
import java.util.List;

public class SearchEventActivity extends AppCompatActivity implements SearchEventView{

  @BindView(R.id.edt_search_event)
  EditText edtSearchEvent;
  @BindView(R.id.txt_input_layout)
  TextInputLayout txtInputLayout;
  @BindView(R.id.recyclerview_activity_search_event)
  RecyclerView recyclerviewActivitySearchEvent;
  private static final String SAVE_DATA_EVENT_SEARCH = "save";
  String key;
  SearchEventPresenter searchEventPresenter;
  SearchEventAdapter adapter;
  ArrayList<EventBean> resultItem;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_event);
    ButterKnife.bind(this);
    setView();
    edtSearchEvent.setOnEditorActionListener((TextView v, int actionId, KeyEvent event) -> {
      if (actionId == EditorInfo.IME_ACTION_SEARCH) {
        key = edtSearchEvent.getText().toString();
        searchEventPresenter.getDataSearchEvent(key);
      }
      return false;
    });
  }

  private void setView() {
    searchEventPresenter = new SearchEventPresenter(
        SearchEventRepositoryInject.provideToSearchEventRepository(this));
    searchEventPresenter.onAttachView(this);
    resultItem = new ArrayList<>();
//    adapter = new SearchEventAdapter(this, resultItem);
    recyclerviewActivitySearchEvent.setLayoutManager(new LinearLayoutManager(this));
//    recyclerviewActivitySearchEvent.setAdapter(adapter);
  }

  @Override
  public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    super.onSaveInstanceState(outState, outPersistentState);
    outState.putParcelableArrayList(SAVE_DATA_EVENT_SEARCH, resultItem);
  }

  @Override
  public void onSuccesSearchEvent(List<EventBean> data, String msg) {
    resultItem.clear();
    resultItem.addAll(data);
//    adapter.notifyDataSetChanged();
  }

  @Override
  public void onWrongSearchEvent(String msg) {
    Toast.makeText(this, "wrong key", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onErrorSearchEvent(String msg) {
    Toast.makeText(this, "internal server error", Toast.LENGTH_SHORT).show();
  }
}
