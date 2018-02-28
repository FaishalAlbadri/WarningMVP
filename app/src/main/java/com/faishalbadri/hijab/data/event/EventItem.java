package com.faishalbadri.hijab.data.event;

import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class EventItem {

  @SerializedName("event_detail")
  private String eventDetail;

  @SerializedName("event_id")
  private String eventId;

  @SerializedName("event_city_id")
  private String eventCityId;

  @SerializedName("event_date")
  private String eventDate;

  @SerializedName("event_link")
  private String eventLink;

  @SerializedName("event_city_name")
  private String eventCityName;

  @SerializedName("event_image")
  private String eventImage;

  @SerializedName("event_address")
  private String eventAddress;

  @SerializedName("event_title")
  private String eventTitle;

  public String getEventDetail() {
    return eventDetail;
  }

  public void setEventDetail(String eventDetail) {
    this.eventDetail = eventDetail;
  }

  public String getEventId() {
    return eventId;
  }

  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  public String getEventCityId() {
    return eventCityId;
  }

  public void setEventCityId(String eventCityId) {
    this.eventCityId = eventCityId;
  }

  public String getEventDate() {
    return eventDate;
  }

  public void setEventDate(String eventDate) {
    this.eventDate = eventDate;
  }

  public String getEventLink() {
    return eventLink;
  }

  public void setEventLink(String eventLink) {
    this.eventLink = eventLink;
  }

  public String getEventCityName() {
    return eventCityName;
  }

  public void setEventCityName(String eventCityName) {
    this.eventCityName = eventCityName;
  }

  public String getEventImage() {
    return eventImage;
  }

  public void setEventImage(String eventImage) {
    this.eventImage = eventImage;
  }

  public String getEventAddress() {
    return eventAddress;
  }

  public void setEventAddress(String eventAddress) {
    this.eventAddress = eventAddress;
  }

  public String getEventTitle() {
    return eventTitle;
  }

  public void setEventTitle(String eventTitle) {
    this.eventTitle = eventTitle;
  }

  @Override
  public String toString() {
    return
        "EventItem{" +
            "event_detail = '" + eventDetail + '\'' +
            ",event_id = '" + eventId + '\'' +
            ",event_city_id = '" + eventCityId + '\'' +
            ",event_date = '" + eventDate + '\'' +
            ",event_link = '" + eventLink + '\'' +
            ",event_city_name = '" + eventCityName + '\'' +
            ",event_image = '" + eventImage + '\'' +
            ",event_address = '" + eventAddress + '\'' +
            ",event_title = '" + eventTitle + '\'' +
            "}";
  }
}