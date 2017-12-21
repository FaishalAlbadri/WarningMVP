package com.faishalbadri.hijab.revamp.ui.detail.video;

import com.faishalbadri.hijab.revamp.base.BasePresenter;
import com.faishalbadri.hijab.revamp.data.PojoVideo;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/6/17.
 */

public class DetailVideoContract {

  public interface DetailVideoView {

    void onSuccessDetailVideo(List<PojoVideo.VideosBean> data, String msg);

    void onError(String msg);

  }

  public interface DetailVideoPresenter extends BasePresenter<DetailVideoView> {

    void getData(String limit);

  }

}
