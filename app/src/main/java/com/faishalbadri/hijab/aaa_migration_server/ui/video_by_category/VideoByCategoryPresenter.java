package com.faishalbadri.hijab.aaa_migration_server.ui.video_by_category;

import com.faishalbadri.hijab.aaa_migration_server.data.PojoVideo;
import com.faishalbadri.hijab.aaa_migration_server.repository.video_by_category.VideoByCategoryDataResource.VideoByCategoryGetDataCallBack;
import com.faishalbadri.hijab.aaa_migration_server.repository.video_by_category.VideoByCategoryRepository;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class VideoByCategoryPresenter implements VideoByCategoryContract.videoByCategoryPresenter {

  VideoByCategoryContract.videoByCategoryView videoByCategoryView;
  VideoByCategoryRepository videoByCategoryRepository;


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
          public void onSuccessVideoByCategory(List<PojoVideo.VideosBean> video, String msg) {
            videoByCategoryView.onSuccesVideoByCategory(video, msg);
          }

          @Override
          public void onErrorVideoByCategory(String msg) {
            videoByCategoryView.onErrorVideoByCategory(msg);
          }
        });
  }
}
