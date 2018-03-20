package com.faishalbadri.hijab.ui.video_by_category;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.videos.VideosItem;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class VideoByCategoryContract {

  public interface videoByCategoryView {

    void onSuccesVideoByCategory(List<VideosItem> data, String msg);

    void onErrorVideoByCategory(String msg);
  }

  public interface videoByCategoryPresenter extends BasePresenter<videoByCategoryView> {

    void getDataVideoByCategory(String id);
  }

}
