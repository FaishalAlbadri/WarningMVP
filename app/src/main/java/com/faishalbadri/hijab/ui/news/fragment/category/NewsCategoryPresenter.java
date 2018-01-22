package com.faishalbadri.hijab.ui.news.fragment.category;

import com.faishalbadri.hijab.data.PojoCategory.CategoriesBean;
import com.faishalbadri.hijab.repository.category.CategoryDataResource.CategoryGetCallback;
import com.faishalbadri.hijab.repository.category.CategoryRepository;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsCategoryPresenter implements NewsCategoryContract.newsCategoryPresenter {

  private NewsCategoryContract.newsCategoryView newsCategoryView;
  private CategoryRepository categoryRepository;

  public NewsCategoryPresenter(
      CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  public void onAttachView(NewsCategoryContract.newsCategoryView view) {
    this.newsCategoryView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataNewsCategory() {
    categoryRepository.getCategoryResult(new CategoryGetCallback() {
      @Override
      public void onSuccesCategory(List<CategoriesBean> data, String msg) {
        newsCategoryView.onSuccesNewsCategory(data, msg);
      }

      @Override
      public void onErrorCategory(String msg) {
        newsCategoryView.onErrorNewsCategory(msg);
      }

    });
  }
}
