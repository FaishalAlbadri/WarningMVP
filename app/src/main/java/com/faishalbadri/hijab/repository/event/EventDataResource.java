package com.faishalbadri.hijab.repository.event;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoEvent;
import java.util.List;

/**
 * Created by faishal on 11/6/17.
 */

public interface EventDataResource {

  interface EventGetCallback {

    void onSuccesEvent(List<PojoEvent.EventBean> data, String msg);

    void onErrorEvent(String msg);
  }

  void getEventResult(@NonNull EventGetCallback eventGetCallback);

}
