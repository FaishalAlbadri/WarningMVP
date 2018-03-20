package com.faishalbadri.hijab.repository.video_by_category;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.videos.VideosItem;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public interface VideoByCategoryDataResource {

  void getVideoByCategoryGetDataCallBack(String id,
      @NonNull VideoByCategoryDataResource.VideoByCategoryGetDataCallBack videoByCategoryGetDataCallBack);

  interface VideoByCategoryGetDataCallBack {

    void onSuccessVideoByCategory(List<VideosItem> video, String msg);

    void onErrorVideoByCategory(String msg);

  }

}
