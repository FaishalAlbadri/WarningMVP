package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.event_by_city.EventByCityRepository;
import com.faishalbadri.hijab.repository.event_by_city.remote.EventByCityDataRemote;

/**
 * Created by faishal on 11/7/17.
 */

public class EventByCityRepositoryInject {

  public static EventByCityRepository provideToEventByCityRepository(Context context) {
    return new EventByCityRepository(new EventByCityDataRemote(context));
  }
}
