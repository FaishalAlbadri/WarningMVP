package com.faishalbadri.hijab.aaa_migration_server.data;

import android.os.Parcel;
import java.util.List;

/**
 * Created by faishal on 11/6/17.
 */

public class PojoEvent {

  /**
   * error : false
   * message : ADA
   * event : [{"event_id":1,"event_title":"Sample","event_date":"2017-11-10","event_detail":"Sample Detail","event_image":"assets/event_images/IMG_1513584128.jpg","event_address":"Jl. Jalan","event_link":"event_link","event_city_id":1,"event_city_name":"Jakarta"}]
   */

  private boolean error;
  private String message;
  private List<EventBean> event;

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

  public List<EventBean> getEvent() {
    return event;
  }

  public void setEvent(List<EventBean> event) {
    this.event = event;
  }

  public static class EventBean implements android.os.Parcelable {

    /**
     * event_id : 1
     * event_title : Sample
     * event_date : 2017-11-10
     * event_detail : Sample Detail
     * event_image : assets/event_images/IMG_1513584128.jpg
     * event_address : Jl. Jalan
     * event_link : event_link
     * event_city_id : 1
     * event_city_name : Jakarta
     */

    private String event_id;
    private String event_title;
    private String event_date;
    private String event_detail;
    private String event_image;
    private String event_address;
    private String event_link;
    private int event_city_id;
    private String event_city_name;

    public String getEvent_id() {
      return event_id;
    }

    public void setEvent_id(String event_id) {
      this.event_id = event_id;
    }

    public String getEvent_title() {
      return event_title;
    }

    public void setEvent_title(String event_title) {
      this.event_title = event_title;
    }

    public String getEvent_date() {
      return event_date;
    }

    public void setEvent_date(String event_date) {
      this.event_date = event_date;
    }

    public String getEvent_detail() {
      return event_detail;
    }

    public void setEvent_detail(String event_detail) {
      this.event_detail = event_detail;
    }

    public String getEvent_image() {
      return event_image;
    }

    public void setEvent_image(String event_image) {
      this.event_image = event_image;
    }

    public String getEvent_address() {
      return event_address;
    }

    public void setEvent_address(String event_address) {
      this.event_address = event_address;
    }

    public String getEvent_link() {
      return event_link;
    }

    public void setEvent_link(String event_link) {
      this.event_link = event_link;
    }

    public int getEvent_city_id() {
      return event_city_id;
    }

    public void setEvent_city_id(int event_city_id) {
      this.event_city_id = event_city_id;
    }

    public String getEvent_city_name() {
      return event_city_name;
    }

    public void setEvent_city_name(String event_city_name) {
      this.event_city_name = event_city_name;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.event_id);
      dest.writeString(this.event_title);
      dest.writeString(this.event_date);
      dest.writeString(this.event_detail);
      dest.writeString(this.event_image);
      dest.writeString(this.event_address);
      dest.writeString(this.event_link);
      dest.writeInt(this.event_city_id);
      dest.writeString(this.event_city_name);
    }

    public EventBean() {
    }

    protected EventBean(Parcel in) {
      this.event_id = in.readString();
      this.event_title = in.readString();
      this.event_date = in.readString();
      this.event_detail = in.readString();
      this.event_image = in.readString();
      this.event_address = in.readString();
      this.event_link = in.readString();
      this.event_city_id = in.readInt();
      this.event_city_name = in.readString();
    }

    public static final Creator<EventBean> CREATOR = new Creator<EventBean>() {
      @Override
      public EventBean createFromParcel(Parcel source) {
        return new EventBean(source);
      }

      @Override
      public EventBean[] newArray(int size) {
        return new EventBean[size];
      }
    };
  }
}
