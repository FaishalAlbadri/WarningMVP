package com.faishalbadri.hijab.revamp.di;

import android.content.Context;
import com.faishalbadri.hijab.revamp.repository.event.EventRepository;
import com.faishalbadri.hijab.revamp.repository.event.remote.EventDataRemote;

/**
 * Created by faishal on 11/7/17.
 */

public class EventRepositoryInject {

  public static EventRepository provideToEventRepository(Context context) {
    return new EventRepository(new EventDataRemote(context));
  }
}
