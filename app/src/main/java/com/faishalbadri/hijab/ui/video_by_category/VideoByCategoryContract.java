package com.faishalbadri.hijab.ui.video_by_category;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.PojoVideo;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class VideoByCategoryContract {

  public interface videoByCategoryView {

    void onSuccesVideoByCategory(List<PojoVideo.VideoBean> data, String msg);

    void onErrorVideoByCategory(String msg);
  }

  public interface videoByCategoryPresenter extends BasePresenter<videoByCategoryView> {

    void getDataVideoByCategory(String id);
  }

}
