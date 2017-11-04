package com.faishalbadri.hijab.repository.video_by_category;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoVideoByCategory;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public interface VideoByCategoryDataResource {

  interface VideoByCategoryGetDataCallBack{

    void onSuccessVideoByCategory(List<PojoVideoByCategory.VideoBean> video, String msg);

    void onErrorVideoByCategory(String msg);

  }

  void getVideoByCategoryGetDataCallBack(String id, @NonNull VideoByCategoryDataResource.VideoByCategoryGetDataCallBack videoByCategoryGetDataCallBack);

}
