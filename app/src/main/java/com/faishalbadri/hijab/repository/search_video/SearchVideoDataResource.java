package com.faishalbadri.hijab.repository.search_video;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoVideo;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public interface SearchVideoDataResource {

  interface SearchVideoGetCallback {

    void onSuccesSearchVideo(List<PojoVideo.VideoBean> data, String msg);

    void onWrongSearchVideo(String msg);

    void onErrorSearchVideo(String msg);
  }

  void getSearchVideoResult(String key , @NonNull SearchVideoGetCallback searchVideoGetCallback);

}
