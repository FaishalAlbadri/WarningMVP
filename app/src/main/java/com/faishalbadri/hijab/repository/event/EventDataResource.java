package com.faishalbadri.hijab.repository.event;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.event.EventItem;
import java.util.List;

/**
 * Created by faishal on 11/6/17.
 */

public interface EventDataResource {

  void getEventResult(int PAGE, @NonNull EventGetCallback eventGetCallback);

  interface EventGetCallback {

    void onSuccesEvent(List<EventItem> data, String msg);

    void onErrorEvent(String msg);
  }

}
