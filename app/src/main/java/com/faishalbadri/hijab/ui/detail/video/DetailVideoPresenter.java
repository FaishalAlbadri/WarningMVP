package com.faishalbadri.hijab.ui.detail.video;

import com.faishalbadri.hijab.repository.detail_video_related_.DetailVideoDataRepository;
import com.faishalbadri.hijab.repository.detail_video_related_.DetailVideoDataResource.DetailVideoGetDataCallBack;
import com.faishalbadri.hijab.ui.detail.video.DetailVideoContract.DetailVideoView;
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
  public void getData(String limit) {
    detailVideoDataRepository.getDetailVideo(limit, new DetailVideoGetDataCallBack() {
      @Override
      public void onSuccessDetailVideo(List<PojoVideo.VideosBean> data, String msg) {
        detailVideoView.onSuccessDetailVideo(data, msg);
      }

      @Override
      public void onError(String msg) {
        detailVideoView.onError(msg);
      }
    });
  }
}
