package com.faishalbadri.hijab.revamp.ui.video_by_category;

import com.faishalbadri.hijab.revamp.base.BasePresenter;
import com.faishalbadri.hijab.revamp.data.PojoVideo;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class VideoByCategoryContract {

  public interface videoByCategoryView {

    void onSuccesVideoByCategory(List<PojoVideo.VideosBean> data, String msg);

    void onErrorVideoByCategory(String msg);
  }

  public interface videoByCategoryPresenter extends BasePresenter<videoByCategoryView> {

    void getDataVideoByCategory(String id);
  }

}
