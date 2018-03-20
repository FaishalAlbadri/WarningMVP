package com.faishalbadri.hijab.ui.video_by_category;

import com.faishalbadri.hijab.data.videos.VideosItem;
import com.faishalbadri.hijab.repository.video_by_category.VideoByCategoryDataResource.VideoByCategoryGetDataCallBack;
import com.faishalbadri.hijab.repository.video_by_category.VideoByCategoryRepository;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class VideoByCategoryPresenter implements VideoByCategoryContract.videoByCategoryPresenter {

  private VideoByCategoryContract.videoByCategoryView videoByCategoryView;
  private VideoByCategoryRepository videoByCategoryRepository;


  public VideoByCategoryPresenter(
      VideoByCategoryRepository videoByCategoryRepository) {
    this.videoByCategoryRepository = videoByCategoryRepository;
  }

  @Override
  public void onAttachView(VideoByCategoryContract.videoByCategoryView view) {
    this.videoByCategoryView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataVideoByCategory(String id) {
    videoByCategoryRepository.getVideoByCategoryGetDataCallBack(id,
        new VideoByCategoryGetDataCallBack() {
          @Override
          public void onSuccessVideoByCategory(List<VideosItem> video, String msg) {
            videoByCategoryView.onSuccesVideoByCategory(video, msg);
          }

          @Override
          public void onErrorVideoByCategory(String msg) {
            videoByCategoryView.onErrorVideoByCategory(msg);
          }
        });
  }
}
