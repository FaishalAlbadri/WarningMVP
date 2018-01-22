package com.faishalbadri.hijab.ui.news_by_category;

import com.faishalbadri.hijab.data.PojoNews.NewsBean;
import com.faishalbadri.hijab.repository.news_by_category.NewsByCategoryDataResource.NewsByCategoryGetDataCallBack;
import com.faishalbadri.hijab.repository.news_by_category.NewsByCategoryRepository;
import com.faishalbadri.hijab.ui.news_by_category.NewsByCategoryContract.NewsByCategoryView;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsByCategoryPresenter implements NewsByCategoryContract.NewsByCategoryPresenter {

  private NewsByCategoryContract.NewsByCategoryView newsByCategoryView;
  private NewsByCategoryRepository newsByCategoryRepository;

  public NewsByCategoryPresenter(
      NewsByCategoryRepository newsByCategoryRepository) {
    this.newsByCategoryRepository = newsByCategoryRepository;
  }


  @Override
  public void onAttachView(NewsByCategoryView view) {
    this.newsByCategoryView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataNewsByCategory(String id) {
    newsByCategoryRepository.getNewsByCategoryGetDataCallBack(id,
        new NewsByCategoryGetDataCallBack() {
          @Override
          public void onSuccessNewsByCategory(List<NewsBean> video, String msg) {
            newsByCategoryView.onSuccesNewsByCategory(video, msg);
          }

          @Override
          public void onErrorNewsByCategory(String msg) {
            newsByCategoryView.onErrorNewsByCategory(msg);
          }
        });
  }
}
