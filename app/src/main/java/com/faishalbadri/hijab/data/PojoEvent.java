package com.faishalbadri.hijab.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;

/**
 * Created by faishal on 11/6/17.
 */

public class PojoEvent {

  /**
   * event : [{"id_event":"16","id_city_event":"1","city_event":"Jakarta","event_title":"Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia","event_time":"2017-11-25","event_detail":"Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia","event_image":"eew.png","event_link":"http://www.faishalbadri.com/"},{"id_event":"15","id_city_event":"1","city_event":"Jakarta","event_title":"Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia","event_time":"2017-11-25","event_detail":"Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia","event_image":"eew.png","event_link":"http://www.faishalbadri.com/"},{"id_event":"14","id_city_event":"1","city_event":"Jakarta","event_title":"Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia","event_time":"2017-11-25","event_detail":"Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia","event_image":"eew.png","event_link":"http://www.faishalbadri.com/"},{"id_event":"13","id_city_event":"1","city_event":"Jakarta","event_title":"Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia","event_time":"2017-11-25","event_detail":"Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia","event_image":"eew.png","event_link":"http://www.faishalbadri.com/"},{"id_event":"12","id_city_event":"1","city_event":"Jakarta","event_title":"Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia","event_time":"2017-11-25","event_detail":"Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia","event_image":"eew.png","event_link":"http://www.faishalbadri.com/"},{"id_event":"11","id_city_event":"1","city_event":"Jakarta","event_title":"Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia","event_time":"2017-11-25","event_detail":"Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia","event_image":"eew.png","event_link":"http://www.faishalbadri.com/"},{"id_event":"10","id_city_event":"1","city_event":"Jakarta","event_title":"Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia","event_time":"2017-11-25","event_detail":"Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia","event_image":"eew.png","event_link":"http://www.faishalbadri.com/"},{"id_event":"9","id_city_event":"1","city_event":"Jakarta","event_title":"Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia","event_time":"2017-11-25","event_detail":"Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia\r\n Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia","event_image":"eew.png","event_link":"http://www.faishalbadri.com/"}]
   * status : 1
   * msg : Data Semua Event
   */

  private String status;
  private String msg;
  private List<EventBean> event;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public List<EventBean> getEvent() {
    return event;
  }

  public void setEvent(List<EventBean> event) {
    this.event = event;
  }

  public static class EventBean implements android.os.Parcelable {

    /**
     * id_event : 16
     * id_city_event : 1
     * city_event : Jakarta
     * event_title : Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia
     * event_time : 2017-11-25
     * event_detail : Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia
     Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia
     Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia
     Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia
     Google Developer Festival Extended Jakarta 2017 by Google Developer Grup Indonesia
     * event_image : eew.png
     * event_link : http://www.faishalbadri.com/
     */

    private String id_event;
    private String id_city_event;
    private String city_event;
    private String event_title;
    private String event_time;
    private String event_detail;
    private String event_image;
    private String event_link;

    public String getId_event() {
      return id_event;
    }

    public void setId_event(String id_event) {
      this.id_event = id_event;
    }

    public String getId_city_event() {
      return id_city_event;
    }

    public void setId_city_event(String id_city_event) {
      this.id_city_event = id_city_event;
    }

    public String getCity_event() {
      return city_event;
    }

    public void setCity_event(String city_event) {
      this.city_event = city_event;
    }

    public String getEvent_title() {
      return event_title;
    }

    public void setEvent_title(String event_title) {
      this.event_title = event_title;
    }

    public String getEvent_time() {
      return event_time;
    }

    public void setEvent_time(String event_time) {
      this.event_time = event_time;
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

    public String getEvent_link() {
      return event_link;
    }

    public void setEvent_link(String event_link) {
      this.event_link = event_link;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.id_event);
      dest.writeString(this.id_city_event);
      dest.writeString(this.city_event);
      dest.writeString(this.event_title);
      dest.writeString(this.event_time);
      dest.writeString(this.event_detail);
      dest.writeString(this.event_image);
      dest.writeString(this.event_link);
    }

    public EventBean() {
    }

    protected EventBean(Parcel in) {
      this.id_event = in.readString();
      this.id_city_event = in.readString();
      this.city_event = in.readString();
      this.event_title = in.readString();
      this.event_time = in.readString();
      this.event_detail = in.readString();
      this.event_image = in.readString();
      this.event_link = in.readString();
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
