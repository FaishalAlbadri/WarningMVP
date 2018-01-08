package com.faishalbadri.hijab.data;

import java.util.List;

/**
 * Created by faishal on 11/6/17.
 */

public class PojoCityEvent {

  /**
   * error : false
   * message : ADA
   * event_city : [{"event_city_id":5,"event_city_name":"Bekasi"},{"event_city_id":2,"event_city_name":"Bogor"},{"event_city_id":3,"event_city_name":"Depok"},{"event_city_id":1,"event_city_name":"Jakarta"},{"event_city_id":4,"event_city_name":"Tangerang"}]
   */

  private boolean error;
  private String message;
  private List<EventCityBean> event_city;

  public boolean isError() {
    return error;
  }

  public void setError(boolean error) {
    this.error = error;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<EventCityBean> getEvent_city() {
    return event_city;
  }

  public void setEvent_city(List<EventCityBean> event_city) {
    this.event_city = event_city;
  }

  public static class EventCityBean {

    /**
     * event_city_id : 5
     * event_city_name : Bekasi
     */

    private String event_city_id;
    private String event_city_name;

    public String getEvent_city_id() {
      return event_city_id;
    }

    public void setEvent_city_id(String event_city_id) {
      this.event_city_id = event_city_id;
    }

    public String getEvent_city_name() {
      return event_city_name;
    }

    public void setEvent_city_name(String event_city_name) {
      this.event_city_name = event_city_name;
    }
  }
}
