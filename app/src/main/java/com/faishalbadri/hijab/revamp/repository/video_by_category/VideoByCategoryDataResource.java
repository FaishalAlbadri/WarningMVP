package com.faishalbadri.hijab.revamp.repository.video_by_category;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.revamp.data.PojoVideo;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public interface VideoByCategoryDataResource {

  void getVideoByCategoryGetDataCallBack(String id,
      @NonNull VideoByCategoryDataResource.VideoByCategoryGetDataCallBack videoByCategoryGetDataCallBack);

  interface VideoByCategoryGetDataCallBack {

    void onSuccessVideoByCategory(List<PojoVideo.VideosBean> video, String msg);

    void onErrorVideoByCategory(String msg);

  }

}
