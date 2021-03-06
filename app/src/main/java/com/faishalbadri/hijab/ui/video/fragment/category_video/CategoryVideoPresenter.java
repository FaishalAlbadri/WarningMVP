package com.faishalbadri.hijab.ui.video.fragment.category_video;

import com.faishalbadri.hijab.data.categories.CategoriesItem;
import com.faishalbadri.hijab.repository.category.CategoryDataResource.CategoryGetCallback;
import com.faishalbadri.hijab.repository.category.CategoryRepository;
import com.faishalbadri.hijab.ui.video.fragment.category_video.CatergoryVideoContract.categoryVideoPresenter;
import com.faishalbadri.hijab.ui.video.fragment.category_video.CatergoryVideoContract.categoryVideoView;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class CategoryVideoPresenter implements categoryVideoPresenter {

  private CatergoryVideoContract.categoryVideoView categoryVideoView;
  private CategoryRepository categoryRepository;

  public CategoryVideoPresenter(
      CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
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
    categoryRepository.getCategoryResult(new CategoryGetCallback() {
      @Override
      public void onSuccesCategory(List<CategoriesItem> data, String msg) {
        categoryVideoView.onSuccesCategoryVideo(data, msg);
      }

      @Override
      public void onErrorCategory(String msg) {
        categoryVideoView.onErrorCategoryVideo(msg);
      }

    });
  }
}
