package com.faishalbadri.hijab.ui.video.fragment.category_video;

import com.faishalbadri.hijab.data.PojoEbook.EbookBean;
import com.faishalbadri.hijab.repository.category_video.CategoryVideoDataResource.CategoryVideoGetCallBack;
import com.faishalbadri.hijab.repository.category_video.CategoryVideoRepository;
import com.faishalbadri.hijab.ui.video.fragment.category_video.CatergoryVideoContract.categoryVideoPresenter;
import com.faishalbadri.hijab.ui.video.fragment.category_video.CatergoryVideoContract.categoryVideoView;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class CategoryVideoPresenter implements categoryVideoPresenter {

  categoryVideoView categoryVideoView;
  private CategoryVideoRepository categoryVideoRepository;

  public CategoryVideoPresenter(CategoryVideoRepository categoryVideoRepository) {
    this.categoryVideoRepository = categoryVideoRepository;
  }

  @Override
  public void onAttachView(categoryVideoView view) {
    this.categoryVideoView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataCategoryVideo() {
    categoryVideoRepository.getCategoryVideoList(new CategoryVideoGetCallBack() {
      @Override
      public void onSuccessCategoryVideo(List<EbookBean> data, String msg) {
        categoryVideoView.onSuccesCategoryVideo(data,msg);
      }

      @Override
      public void onErrorCategoryVideo(String msg) {
        categoryVideoView.onErrorCategoryVideo(msg);
      }
    });
  }
}
