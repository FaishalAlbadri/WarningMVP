package com.faishalbadri.hijab.aaa_migration_server.ui.news.fragment.category;

import com.faishalbadri.hijab.aaa_migration_server.data.PojoCategory;
import com.faishalbadri.hijab.aaa_migration_server.repository.category.CategoryDataResource.CategoryGetCallback;
import com.faishalbadri.hijab.aaa_migration_server.repository.category.CategoryRepository;
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
