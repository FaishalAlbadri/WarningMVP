package com.faishalbadri.hijab.ui.detail.news;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.PojoNews.NewsBean;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/8/17.
 */

public class DetailNewsContract {


  public interface DetailNewsPresenter extends BasePresenter<DetailNewsView> {

    void getData(String id_content);

    void getView(String id_news);

  }

  public interface DetailNewsView {

    void onSuccessDetailNews(List<NewsBean> data, String msg);

    void onSuccesView(List<NewsBean> data, String msg);

    void onError(String msg);

  }

}
