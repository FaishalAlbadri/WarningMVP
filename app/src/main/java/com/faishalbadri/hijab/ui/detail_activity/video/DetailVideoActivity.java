package com.faishalbadri.hijab.ui.detail_activity.video;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.util.Server;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStyle;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

public class DetailVideoActivity extends YouTubeBaseActivity implements
    OnInitializedListener {

  String title, video, duration;
  private static final int RECOVERY_DIALOG_REQUEST = 1;
  @BindView(R.id.youtube_video_detail)
  YouTubePlayerView youtubeVideoDetail;
  @BindView(R.id.txt_title_video_detail)
  TextView txtTitleVideoDetail;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail_video);
    ButterKnife.bind(this);
    setView();
  }

  private void setView() {
    title     = getIntent().getStringExtra("title");
    video     = getIntent().getStringExtra("video");
    duration  = getIntent().getStringExtra("duration");
    txtTitleVideoDetail.setText(title);
    youtubeVideoDetail.initialize(Server.YT_CODE, this);
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
      String errorMessage = String.format(getString(R.string.error_player), youTubeInitializationResult.toString());
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
}
