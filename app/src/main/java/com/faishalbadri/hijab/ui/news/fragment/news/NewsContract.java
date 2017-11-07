package com.faishalbadri.hijab.ui.news.fragment.news;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.PojoNews;
import com.faishalbadri.hijab.data.PojoSlider;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsContract {

  public interface newsView {

    void onSuccesNews(List<PojoNews.IsiBean> data, String msg);

    void onErrorNews(String msg);

    void onSuccesSlider(List<PojoSlider.SliderBean> dataSlider,String msg);

    void onErrorSlider(String msg);

  }

  public interface newsPresenter extends BasePresenter<NewsContract.newsView> {

    void getDataNews();

    void getDataSlider();

  }

}
