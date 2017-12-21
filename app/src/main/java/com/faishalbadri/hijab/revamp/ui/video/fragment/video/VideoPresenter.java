package com.faishalbadri.hijab.revamp.ui.video.fragment.video;

import com.faishalbadri.hijab.revamp.data.PojoVideo;
import com.faishalbadri.hijab.revamp.repository.video.VideoDataResource.VideoGetCallBack;
import com.faishalbadri.hijab.revamp.repository.video.VideoRepository;
import com.faishalbadri.hijab.revamp.ui.video.fragment.video.VideoContract.VideoView;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class VideoPresenter implements VideoContract.VideoPresenter {

  VideoContract.VideoView videoView;
  private VideoRepository videoRepository;

  public VideoPresenter(VideoRepository videoRepository) {
    this.videoRepository = videoRepository;
  }

  @Override
  public void onAttachView(VideoView view) {
    this.videoView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataVideo() {
    videoRepository.getVideoList(new VideoGetCallBack() {
      @Override
      public void onSuccessVideo(List<PojoVideo.VideosBean> data, String msg) {
        videoView.onSuccesVideo(data, msg);
      }

      @Override
      public void onErrorVideo(String msg) {
        videoView.onErrorVideo(msg);
      }
    });
  }
}
