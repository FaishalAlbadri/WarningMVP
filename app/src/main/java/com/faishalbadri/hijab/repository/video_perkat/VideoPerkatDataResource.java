package com.faishalbadri.hijab.repository.video_perkat;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoVideoPerkat;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public interface VideoPerkatDataResource {

  interface VideoPerkatGetDataCallBack{

    void onSuccessVideoPerkat(List<PojoVideoPerkat.VideoBean> video, String msg);

    void onError(String msg);

  }

  void getAccountResult(String id, @NonNull VideoPerkatDataResource.VideoPerkatGetDataCallBack videoPerkatGetDataCallBack);

}
