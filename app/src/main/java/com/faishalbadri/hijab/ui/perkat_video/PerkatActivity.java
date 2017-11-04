package com.faishalbadri.hijab.ui.perkat_video;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoVideoPerkat.VideoBean;
import com.faishalbadri.hijab.di.VideoPerkatRepositoryInject;
import com.faishalbadri.hijab.ui.video.activity.VideoActivity;
import com.faishalbadri.hijab.ui.perkat_video.PerkatVideoContract.perkatVideoView;
import java.util.ArrayList;
import java.util.List;

public class PerkatActivity extends AppCompatActivity implements perkatVideoView {

  @BindView(R.id.recyclerview_activity_perkat_video)
  RecyclerView recyclerviewActivityPerkatVideo;
  private static final String SAVE_DATA_VIDEO_PERKAT = "save";
  PerkatVideoPresenter perkatVideoPresenter;
  PerkatVideoAdapter perkatVideoAdapter;
  ArrayList<VideoBean> resultItem;
  String id, title;
  @BindView(R.id.button_back_general_toolbar_with_back_button)
  ImageView buttonBackGeneralToolbarWithBackButton;
  @BindView(R.id.textview_general_toolbar_with_back_button)
  TextView textviewGeneralToolbarWithBackButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_perkat);
    ButterKnife.bind(this);
    setView();
    if (savedInstanceState != null) {
      ArrayList<VideoBean> resultArray = savedInstanceState
          .getParcelableArrayList(SAVE_DATA_VIDEO_PERKAT);
      this.resultItem.clear();
      this.resultItem.addAll(resultArray);
      perkatVideoAdapter.notifyDataSetChanged();
    } else {
      perkatVideoPresenter.getDataPerkatVideo(id);
    }
  }

  private void setView() {
    id = getIntent().getStringExtra("id");
    title = getIntent().getStringExtra("kategori");
    textviewGeneralToolbarWithBackButton.setText(title);
    perkatVideoPresenter = new PerkatVideoPresenter(
        VideoPerkatRepositoryInject.provideToVideoPerkatRepository(this));
    perkatVideoPresenter.onAttachView(this);
    resultItem = new ArrayList<>();
    perkatVideoAdapter = new PerkatVideoAdapter(this, resultItem);
    recyclerviewActivityPerkatVideo.setLayoutManager(new LinearLayoutManager(this));
    recyclerviewActivityPerkatVideo.setAdapter(perkatVideoAdapter);
  }

  @Override
  public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    super.onSaveInstanceState(outState, outPersistentState);
    outState.putParcelableArrayList(SAVE_DATA_VIDEO_PERKAT, resultItem);
  }

  @Override
  public void onSuccesPerkatVideo(List<VideoBean> user, String msg) {
    resultItem.clear();
    resultItem.addAll(user);
    perkatVideoAdapter.notifyDataSetChanged();
  }

  @Override
  public void onErrorPerkatVideo(String msg) {
    Toast.makeText(this, "check your internet", Toast.LENGTH_SHORT).show();
  }

  @OnClick(R.id.button_back_general_toolbar_with_back_button)
  public void onViewClicked() {
    startActivity(new Intent(getApplicationContext(), VideoActivity.class).putExtra("session_video","1"));
    finish();
  }

  @Override
  public void onBackPressed() {
    startActivity(new Intent(getApplicationContext(), VideoActivity.class).putExtra("session_video","1"));
    finish();
  }
}
