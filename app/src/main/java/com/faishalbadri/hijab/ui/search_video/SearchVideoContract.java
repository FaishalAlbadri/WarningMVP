package com.faishalbadri.hijab.ui.search_video;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.PojoVideo.VideosBean;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchVideoContract {

  public interface SearchVideoView {

    void onSuccesSearchVideo(List<VideosBean> data, String msg);

    void onWrongSearchVideo(String msg);

    void onErrorSearchVideo(String msg);
  }

  public interface SearchVideoPresenter extends BasePresenter<SearchVideoView> {

    void getDataSearchVideo(String key);
  }

}
