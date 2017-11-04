package com.faishalbadri.hijab.ui.perkat_video;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.PojoVideoPerkat.VideoBean;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class PerkatVideoContract {

  public interface perkatVideoView {

    void onSuccesPerkatVideo(List<VideoBean> user,String msg);

    void onErrorPerkatVideo(String msg);
  }

  public interface perkatVideoPresenter extends BasePresenter<perkatVideoView> {

    void getDataPerkatVideo(String id);
  }

}
