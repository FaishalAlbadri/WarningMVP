package com.faishalbadri.hijab.repository.event_by_city;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 11/6/17.
 */

public class EventByCityRepository implements EventByCityDataResource {

  EventByCityDataResource eventByCityDataResource;

  public EventByCityRepository(
      EventByCityDataResource eventByCityDataResource) {
    this.eventByCityDataResource = eventByCityDataResource;
  }

  @Override
  public void getEventByCityResult(String id_city_event,
      @NonNull EventByCityGetCallback eventByCityGetCallback) {
    eventByCityDataResource.getEventByCityResult(id_city_event, eventByCityGetCallback);
  }
}
