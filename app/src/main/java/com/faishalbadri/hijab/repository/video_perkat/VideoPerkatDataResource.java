package com.faishalbadri.hijab.repository.video_perkat;

import android.content.Context;
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

}
