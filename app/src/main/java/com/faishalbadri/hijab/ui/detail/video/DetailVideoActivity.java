package com.faishalbadri.hijab.ui.detail.video;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoVideo.VideoBean;
import com.faishalbadri.hijab.di.DetailVideoRepositoryInject;
import com.faishalbadri.hijab.ui.detail.video.DetailVideoContract.DetailVideoView;
import com.faishalbadri.hijab.ui.video.activity.VideoActivity;
import com.faishalbadri.hijab.util.Server;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStyle;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;
import java.util.ArrayList;
import java.util.List;

public class DetailVideoActivity extends YouTubeBaseActivity implements
    OnInitializedListener, DetailVideoView {

  String title, video, duration, description;
  private static final String SAVE_DATA_VIDEO_DETAIL = "save";
  private static final int RECOVERY_DIALOG_REQUEST = 1;
  @BindView(R.id.youtube_video_detail)
  YouTubePlayerView youtubeVideoDetail;
  @BindView(R.id.txt_title_video_detail)
  TextView txtTitleVideoDetail;
  @BindView(R.id.txt_description_video_detail)
  TextView txtDescriptionVideoDetail;
  @BindView(R.id.button_back_general_toolbar_with_back_button)
  ImageView buttonBackGeneralToolbarWithBackButton;
  @BindView(R.id.textview_general_toolbar_with_back_button)
  TextView textviewGeneralToolbarWithBackButton;
  @BindView(R.id.recyclerview_activity_video_detail)
  RecyclerView recyclerviewActivityVideoDetail;
  DetailVideoAdapter detailVideoAdapter;
  ArrayList<VideoBean> resultItem;
  DetailVideoPresenter detailVideoPresenter;
  @BindView(R.id.ad_view_detail_video)
  AdView adViewDetailVideo;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail_video);
    ButterKnife.bind(this);
    setView();
    if (savedInstanceState != null) {
      ArrayList<VideoBean> resultArray = savedInstanceState
          .getParcelableArrayList(SAVE_DATA_VIDEO_DETAIL);
      this.resultItem.clear();
      this.resultItem.addAll(resultArray);
      detailVideoAdapter.notifyDataSetChanged();
    } else {
      detailVideoPresenter.getData();
    }
  }

  private void setView() {
    detailVideoPresenter = new DetailVideoPresenter(
        DetailVideoRepositoryInject.provideToDetailVideoInject(this));
    detailVideoPresenter.onAttachView(this);
    resultItem = new ArrayList<>();
    detailVideoAdapter = new DetailVideoAdapter(this, resultItem);
    recyclerviewActivityVideoDetail.setLayoutManager(new GridLayoutManager(this, 2));
    recyclerviewActivityVideoDetail.setAdapter(detailVideoAdapter);
    title = getIntent().getStringExtra("title");
    video = getIntent().getStringExtra("video");
    description = getIntent().getStringExtra("description");
    duration = getIntent().getStringExtra("duration");
    txtTitleVideoDetail.setText(title);
    textviewGeneralToolbarWithBackButton.setText(R.string.text_pinky_hijab_video);
    txtDescriptionVideoDetail.setText(description);
    youtubeVideoDetail.initialize(Server.YT_CODE, this);
    setAdView();
  }

  private void setAdView() {
    AdRequest adRequest = new AdRequest.Builder().build();
    adViewDetailVideo.loadAd(adRequest);
  }

  @Override
  public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    super.onSaveInstanceState(outState, outPersistentState);
    outState.putParcelableArrayList(SAVE_DATA_VIDEO_DETAIL, resultItem);
  }

  @Override
  public void onInitializationSuccess(Provider provider, YouTubePlayer youTubePlayer, boolean b) {
    if (!b) {

      // loadVideo() will auto play video
      // Use cueVideo() method, if you don't want to play it automatically
      youTubePlayer.loadVideo(video);
      youTubePlayer.addFullscreenControlFlag(RECOVERY_DIALOG_REQUEST);
      // Hiding player controls
      youTubePlayer.setPlayerStyle(PlayerStyle.DEFAULT);

    }
  }

  @Override
  public void onInitializationFailure(Provider provider,
      YouTubeInitializationResult youTubeInitializationResult) {
    if (youTubeInitializationResult.isUserRecoverableError()) {
      youTubeInitializationResult.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
    } else {
      String errorMessage = String
          .format(getString(R.string.error_player), youTubeInitializationResult.toString());
      Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == RECOVERY_DIALOG_REQUEST) {
      getYoutubePlayerProvider().initialize(Server.YT_CODE, this);
    }
  }

  protected YouTubePlayerView getYoutubePlayerProvider() {
    return youtubeVideoDetail;
  }

  @OnClick(R.id.button_back_general_toolbar_with_back_button)
  public void onViewClicked() {
    startActivity(new Intent(getApplicationContext(), VideoActivity.class));
    finish();
  }

  @Override
  public void onSuccessDetailVideo(List<VideoBean> data, String msg) {
    resultItem.clear();
    resultItem.addAll(data);
    detailVideoAdapter.notifyDataSetChanged();
  }

  @Override
  public void onError(String msg) {
    Toast.makeText(this, "internal server error", Toast.LENGTH_SHORT).show();
  }
}
