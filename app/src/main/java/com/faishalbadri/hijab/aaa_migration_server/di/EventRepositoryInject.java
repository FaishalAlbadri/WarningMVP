package com.faishalbadri.hijab.aaa_migration_server.di;

import android.content.Context;
import com.faishalbadri.hijab.aaa_migration_server.repository.event.EventRepository;
import com.faishalbadri.hijab.aaa_migration_server.repository.event.remote.EventDataRemote;

/**
 * Created by faishal on 11/7/17.
 */

public class EventRepositoryInject {

  public static EventRepository provideToEventRepository(Context context) {
    return new EventRepository(new EventDataRemote(context));
  }
}
