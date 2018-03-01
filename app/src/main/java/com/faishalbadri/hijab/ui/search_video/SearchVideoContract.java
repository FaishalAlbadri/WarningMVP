package com.faishalbadri.hijab.ui.search_video;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.videos.VideosItem;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchVideoContract {

  public interface SearchVideoView {

    void onSuccesSearchVideo(List<VideosItem> data, String msg);

    void onWrongSearchVideo(String msg);

    void onErrorSearchVideo(String msg);
  }

  public interface SearchVideoPresenter extends BasePresenter<SearchVideoView> {

    void getDataSearchVideo(String key);
  }

}
