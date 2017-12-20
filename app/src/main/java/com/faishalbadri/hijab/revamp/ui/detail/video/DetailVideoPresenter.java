package com.faishalbadri.hijab.revamp.ui.detail.video;

import com.faishalbadri.hijab.data.PojoVideo.VideoBean;
import com.faishalbadri.hijab.repository.detail_video_related.DetailVideoDataRepository;
import com.faishalbadri.hijab.repository.detail_video_related.DetailVideoDataResource.DetailVideoGetDataCallBack;
import com.faishalbadri.hijab.revamp.ui.detail.video.DetailVideoContract.DetailVideoView;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/6/17.
 */

public class DetailVideoPresenter implements DetailVideoContract.DetailVideoPresenter {

  DetailVideoView detailVideoView;
  private DetailVideoDataRepository detailVideoDataRepository;

  public DetailVideoPresenter(DetailVideoDataRepository detailVideoDataRepository) {
    this.detailVideoDataRepository = detailVideoDataRepository;
  }

  @Override
  public void onAttachView(DetailVideoView view) {
    detailVideoView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getData() {
    detailVideoDataRepository.getDetailVideo(new DetailVideoGetDataCallBack() {
      @Override
      public void onSuccessDetailVideo(List<VideoBean> data, String msg) {
        detailVideoView.onSuccessDetailVideo(data, msg);
      }

      @Override
      public void onError(String msg) {
        detailVideoView.onError(msg);
      }
    });
  }
}
