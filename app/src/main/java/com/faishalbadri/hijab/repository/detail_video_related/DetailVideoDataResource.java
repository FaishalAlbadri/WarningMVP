package com.faishalbadri.hijab.repository.detail_video_related;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.videos.VideosItem;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/6/17.
 */

public interface DetailVideoDataResource {

  void getDetailVideo(@NonNull DetailVideoGetDataCallBack detailVideoGetDataCallBack);

  interface DetailVideoGetDataCallBack {

    void onSuccessDetailVideo(List<VideosItem> data, String msg);

    void onError(String msg);

  }

}
