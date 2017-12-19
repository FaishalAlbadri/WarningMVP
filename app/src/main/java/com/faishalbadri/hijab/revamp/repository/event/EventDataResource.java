package com.faishalbadri.hijab.revamp.repository.event;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.revamp.data.PojoEvent;
import java.util.List;

/**
 * Created by faishal on 11/6/17.
 */

public interface EventDataResource {

  void getEventResult(@NonNull EventGetCallback eventGetCallback);

  interface EventGetCallback {

    void onSuccesEvent(List<PojoEvent.EventBean> data, String msg);

    void onErrorEvent(String msg);
  }

}
