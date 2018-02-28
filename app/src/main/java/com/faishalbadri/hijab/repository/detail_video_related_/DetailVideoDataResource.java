package com.faishalbadri.hijab.repository.detail_video_related_;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoVideo;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/6/17.
 */

public interface DetailVideoDataResource {

  void getDetailVideo(String limit,@NonNull DetailVideoGetDataCallBack detailVideoGetDataCallBack);

  interface DetailVideoGetDataCallBack {

    void onSuccessDetailVideo(List<PojoVideo.VideosBean> data, String msg);

    void onError(String msg);

  }

}
