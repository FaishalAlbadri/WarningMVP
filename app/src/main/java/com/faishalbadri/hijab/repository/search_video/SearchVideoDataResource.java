package com.faishalbadri.hijab.repository.search_video;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.videos.VideosItem;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public interface SearchVideoDataResource {

  void getSearchVideoResult(String key, @NonNull SearchVideoGetCallback searchVideoGetCallback);

  interface SearchVideoGetCallback {

    void onSuccesSearchVideo(List<VideosItem> data, String msg);

    void onWrongSearchVideo(String msg);

    void onErrorSearchVideo(String msg);
  }

}
