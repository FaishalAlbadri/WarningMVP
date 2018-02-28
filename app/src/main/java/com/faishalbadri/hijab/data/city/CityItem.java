package com.faishalbadri.hijab.data.city;

import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class CityItem {

  @SerializedName("event_city_id")
  private String eventCityId;

  @SerializedName("event_city_name")
  private String eventCityName;

  public String getEventCityId() {
    return eventCityId;
  }

  public void setEventCityId(String eventCityId) {
    this.eventCityId = eventCityId;
  }

  public String getEventCityName() {
    return eventCityName;
  }

  public void setEventCityName(String eventCityName) {
    this.eventCityName = eventCityName;
  }

  @Override
  public String toString() {
    return
        "CityItem{" +
            "event_city_id = '" + eventCityId + '\'' +
            ",event_city_name = '" + eventCityName + '\'' +
            "}";
  }
}