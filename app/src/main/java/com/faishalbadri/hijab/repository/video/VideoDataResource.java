package com.faishalbadri.hijab.repository.video;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoVideo.VideosBean;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public interface VideoDataResource {

  void getVideoList(int PAGE,@NonNull VideoGetCallBack videoGetCallBack);

  interface VideoGetCallBack {

    void onSuccessVideo(List<VideosBean> data, String msg);

    void onErrorVideo(String msg);

  }

}
