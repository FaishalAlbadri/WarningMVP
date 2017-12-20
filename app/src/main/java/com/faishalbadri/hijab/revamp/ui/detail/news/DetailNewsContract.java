package com.faishalbadri.hijab.revamp.ui.detail.news;

import com.faishalbadri.hijab.revamp.base.BasePresenter;
import com.faishalbadri.hijab.data.PojoNews.IsiBean;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/8/17.
 */

public class DetailNewsContract {

  public interface DetailNewsView {

    void onSuccessDetailNews(List<IsiBean> data, String msg);

    void onError(String msg);

  }

  public interface DetailNewsPresenter extends BasePresenter<DetailNewsView> {

    void getData(String id_isi);

  }

}
