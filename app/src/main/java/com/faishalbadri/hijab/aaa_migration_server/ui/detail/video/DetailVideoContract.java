package com.faishalbadri.hijab.aaa_migration_server.ui.detail.video;

import com.faishalbadri.hijab.aaa_migration_server.base.BasePresenter;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoVideo;
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
