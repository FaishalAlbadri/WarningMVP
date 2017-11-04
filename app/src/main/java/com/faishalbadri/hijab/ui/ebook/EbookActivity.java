package com.faishalbadri.hijab.ui.ebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoEbook.EbookBean;
import com.faishalbadri.hijab.di.EbookRepositoryInject;
import com.faishalbadri.hijab.ui.ebook.EbookContract.EbookView;
import com.faishalbadri.hijab.ui.home.activity.HomeActivity;
import java.util.ArrayList;
import java.util.List;

public class EbookActivity extends AppCompatActivity implements EbookView {

  @BindView(R.id.recyclerview_activity_ebook)
  RecyclerView recyclerviewActivityEbook;
  EbookPresenter ebookPresenter;
  EbookAdapter ebookAdapter;
  ArrayList<EbookBean> resultItem;
  private static final String SAVE_DATA_EBOOK = "save";
  @BindView(R.id.textview_general_toolbar_with_button)
  TextView textviewGeneralToolbarWithButton;
  @BindView(R.id.button_send_general_toolbar_with_button)
  ImageView buttonSendGeneralToolbarWithButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ebook);
    ButterKnife.bind(this);
    setView();
    if (savedInstanceState != null) {
      ArrayList<EbookBean> resultArray = savedInstanceState.getParcelableArrayList(SAVE_DATA_EBOOK);
      this.resultItem.clear();
      this.resultItem.addAll(resultArray);
      ebookAdapter.notifyDataSetChanged();
    } else {
      ebookPresenter.getData();
    }
  }

  private void setView() {
    buttonSendGeneralToolbarWithButton.setVisibility(View.GONE);
    textviewGeneralToolbarWithButton.setText(R.string.text_ebook);
    ebookPresenter = new EbookPresenter(
        EbookRepositoryInject.provideToEbookRepositories(EbookActivity.this));
    ebookPresenter.onAttachView(this);
    resultItem = new ArrayList<>();
    ebookAdapter = new EbookAdapter(EbookActivity.this, resultItem);
    recyclerviewActivityEbook.setLayoutManager(new GridLayoutManager(this, 2));
    recyclerviewActivityEbook.setAdapter(ebookAdapter);
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putParcelableArrayList(SAVE_DATA_EBOOK, resultItem);
  }

  @Override
  public void onSuccessEbook(List<EbookBean> ebook, String msg) {
    resultItem.clear();
    resultItem.addAll(ebook);
    ebookAdapter.notifyDataSetChanged();
  }

  @Override
  public void onNullEbook(String msg) {
    Toast.makeText(EbookActivity.this, msg, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onErrorEbook(String msg) {
    Toast.makeText(EbookActivity.this, msg, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    startActivity(new Intent(getApplicationContext(),HomeActivity.class));
    finish();
  }
}
