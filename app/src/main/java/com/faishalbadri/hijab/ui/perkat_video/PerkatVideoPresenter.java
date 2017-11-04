package com.faishalbadri.hijab.ui.perkat_video;

import com.faishalbadri.hijab.data.PojoVideoPerkat.VideoBean;
import com.faishalbadri.hijab.repository.video_perkat.VideoPerkatDataResource.VideoPerkatGetDataCallBack;
import com.faishalbadri.hijab.repository.video_perkat.VideoPerkatRepository;
import com.faishalbadri.hijab.ui.perkat_video.PerkatVideoContract.perkatVideoPresenter;
import com.faishalbadri.hijab.ui.perkat_video.PerkatVideoContract.perkatVideoView;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class PerkatVideoPresenter implements  perkatVideoPresenter{

  perkatVideoView perkatVideoView;
  VideoPerkatRepository videoPerkatRepository;

  public PerkatVideoPresenter(VideoPerkatRepository videoPerkatRepository) {
    this.videoPerkatRepository = videoPerkatRepository;
  }

  @Override
  public void onAttachView(perkatVideoView view) {
    perkatVideoView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataPerkatVideo(String id) {
    videoPerkatRepository.getAccountResult(id, new VideoPerkatGetDataCallBack() {
      @Override
      public void onSuccessVideoPerkat(List<VideoBean> video, String msg) {
        perkatVideoView.onSuccesPerkatVideo(video, msg);
      }

      @Override
      public void onError(String msg) {
        perkatVideoView.onErrorPerkatVideo(msg);
      }
    });
  }
}
