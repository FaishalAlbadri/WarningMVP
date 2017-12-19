package com.faishalbadri.hijab.ui.news.fragment.category;

import com.faishalbadri.hijab.revamp.data.PojoCategory;
import com.faishalbadri.hijab.revamp.repository.category.CategoryDataResource.CategoryGetCallback;
import com.faishalbadri.hijab.revamp.repository.category.CategoryRepository;
import com.faishalbadri.hijab.ui.news.fragment.category.NewsCategoryContract.newsCategoryView;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsCategoryPresenter implements NewsCategoryContract.newsCategoryPresenter {

  NewsCategoryContract.newsCategoryView newsCategoryView;
  CategoryRepository categoryRepository;

  public NewsCategoryPresenter(
      CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  public void onAttachView(newsCategoryView view) {
    this.newsCategoryView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataNewsCategory() {
    categoryRepository.getCategoryResult(new CategoryGetCallback() {
      @Override
      public void onSuccesCategory(List<PojoCategory.CategoriesBean> data, String msg) {
        newsCategoryView.onSuccesNewsCategory(data, msg);
      }

      @Override
      public void onErrorCategory(String msg) {
        newsCategoryView.onErrorNewsCategory(msg);
      }

    });
  }
}
