package com.faishalbadri.hijab.repository.event;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 11/6/17.
 */

public class EventRepository implements EventDataResource {

  EventDataResource eventDataResource;

  public EventRepository(EventDataResource eventDataResource) {
    this.eventDataResource = eventDataResource;
  }

  @Override
  public void getEventResult(int PAGE, @NonNull EventGetCallback eventGetCallback) {
    eventDataResource.getEventResult(PAGE, eventGetCallback);
  }
}
