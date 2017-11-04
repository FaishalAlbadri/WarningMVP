package com.faishalbadri.hijab.ui.news.fragment.news;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.PojoCategory.KategoriBean;
import com.faishalbadri.hijab.data.PojoNews;
import com.faishalbadri.hijab.ui.news.fragment.category.NewsCategoryContract;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsContract {

  public interface newsView {

    void onSuccesNews(List<PojoNews.IsiBean> data, String msg);

    void onErrorNews(String msg);

  }

  public interface newsPresenter extends BasePresenter<NewsContract.newsView> {

    void getDataNews();

  }

}
