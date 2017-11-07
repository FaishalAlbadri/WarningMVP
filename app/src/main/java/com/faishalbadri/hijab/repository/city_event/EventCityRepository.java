package com.faishalbadri.hijab.repository.city_event;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 11/6/17.
 */

public class EventCityRepository implements EventCityDataResource {

  EventCityDataResource eventCityDataResource;

  public EventCityRepository(
      EventCityDataResource eventCityDataResource) {
    this.eventCityDataResource = eventCityDataResource;
  }

  @Override
  public void getEventCityResult(@NonNull EventCityGetCallback eventCityGetCallback) {
    eventCityDataResource.getEventCityResult(eventCityGetCallback);
  }
}
