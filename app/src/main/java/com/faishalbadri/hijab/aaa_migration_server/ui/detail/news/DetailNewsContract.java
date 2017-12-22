package com.faishalbadri.hijab.aaa_migration_server.ui.detail.news;

import com.faishalbadri.hijab.aaa_migration_server.base.BasePresenter;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoNews.NewsBean;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/8/17.
 */

public class DetailNewsContract {

  public interface DetailNewsView {

    void onSuccessDetailNews(List<NewsBean> data, String msg);

    void onError(String msg);

  }

  public interface DetailNewsPresenter extends BasePresenter<DetailNewsView> {

    void getData(String id_isi);

  }

}
