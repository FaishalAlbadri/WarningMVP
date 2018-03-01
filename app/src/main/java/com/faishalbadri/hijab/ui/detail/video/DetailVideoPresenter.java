package com.faishalbadri.hijab.ui.detail.video;

import com.faishalbadri.hijab.data.videos.VideosItem;
import com.faishalbadri.hijab.repository.detail_video_related_.DetailVideoDataResource.DetailVideoGetDataCallBack;
import com.faishalbadri.hijab.repository.detail_video_related_.DetailVideoRepository;
import com.faishalbadri.hijab.ui.detail.video.DetailVideoContract.DetailVideoView;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/6/17.
 */

public class DetailVideoPresenter implements DetailVideoContract.DetailVideoPresenter {

  DetailVideoView detailVideoView;
  private DetailVideoRepository detailVideoRepository;

  public DetailVideoPresenter(DetailVideoRepository detailVideoRepository) {
    this.detailVideoRepository = detailVideoRepository;
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
    detailVideoRepository.getDetailVideo(limit, new DetailVideoGetDataCallBack() {
      @Override
      public void onSuccessDetailVideo(List<VideosItem> data, String msg) {
        detailVideoView.onSuccessDetailVideo(data, msg);
      }

      @Override
      public void onError(String msg) {
        detailVideoView.onError(msg);
      }
    });
  }
}
