package com.faishalbadri.hijab.aaa_migration_server.repository.video;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoVideo;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public interface VideoDataResource {

  void getVideoList(@NonNull VideoGetCallBack videoGetCallBack);

  interface VideoGetCallBack {

    void onSuccessVideo(List<PojoVideo.VideosBean> data, String msg);

    void onErrorVideo(String msg);

  }

}
