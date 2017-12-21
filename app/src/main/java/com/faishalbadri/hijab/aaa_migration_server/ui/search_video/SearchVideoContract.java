package com.faishalbadri.hijab.aaa_migration_server.ui.search_video;

import com.faishalbadri.hijab.aaa_migration_server.base.BasePresenter;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoVideo;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchVideoContract {

  public interface SearchVideoView {

    void onSuccesSearchVideo(List<PojoVideo.VideosBean> data, String msg);

    void onWrongSearchVideo(String msg);

    void onErrorSearchVideo(String msg);
  }

  public interface SearchVideoPresenter extends BasePresenter<SearchVideoView> {

    void getDataSearchVideo(String key);
  }

}
