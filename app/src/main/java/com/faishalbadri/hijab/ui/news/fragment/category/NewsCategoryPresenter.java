package com.faishalbadri.hijab.ui.news.fragment.category;

import com.faishalbadri.hijab.data.PojoCategory.KategoriBean;
import com.faishalbadri.hijab.repository.news_category.NewsCategoryDataResource.NewsCategoryGetCallback;
import com.faishalbadri.hijab.repository.news_category.NewsCategoryRepository;
import com.faishalbadri.hijab.ui.news.fragment.category.NewsCategoryContract.newsCategoryView;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsCategoryPresenter implements NewsCategoryContract.newsCategoryPresenter {

  NewsCategoryContract.newsCategoryView newsCategoryView;
  NewsCategoryRepository newsCategoryRepository;

  public NewsCategoryPresenter(
      NewsCategoryRepository newsCategoryRepository) {
    this.newsCategoryRepository = newsCategoryRepository;
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
    newsCategoryRepository.getNewsCategoryResult(new NewsCategoryGetCallback() {
      @Override
      public void onSuccesNewsCategory(List<KategoriBean> data, String msg) {
        newsCategoryView.onSuccesNewsCategory(data, msg);
      }

      @Override
      public void onErrorNewsCategory(String msg) {
        newsCategoryView.onErrorNewsCategory(msg);
      }
    });
  }
}
