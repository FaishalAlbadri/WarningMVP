package com.faishalbadri.hijab.ui.detail.video;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.PojoVideo.VideosBean;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/6/17.
 */

public class DetailVideoContract {

  public interface DetailVideoView {

    void onSuccessDetailVideo(List<VideosBean> data, String msg);

    void onError(String msg);

  }

  public interface DetailVideoPresenter extends BasePresenter<DetailVideoView> {

    void getData(String limit);

  }

}
