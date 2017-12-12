package com.faishalbadri.hijab.data;

import android.os.Parcel;
import java.util.List;

/**
 * Created by faishal on 11/6/17.
 */

public class PojoCityEvent {

  /**
   * city_event : [{"id_city_event":"4","city_event":"Android"},{"id_city_event":"2","city_event":"Bisnis"},{"id_city_event":"1","city_event":"Edukasi"},{"id_city_event":"5","city_event":"IOS"},{"id_city_event":"3","city_event":"Training"}]
   * status : 1 msg : Data Semua city Event
   */

  private String status;
  private String msg;
  private List<CityEventBean> city_event;

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

  public List<CityEventBean> getCity_event() {
    return city_event;
  }

  public void setCity_event(List<CityEventBean> city_event) {
    this.city_event = city_event;
  }

  public static class CityEventBean implements android.os.Parcelable {

    public static final Creator<CityEventBean> CREATOR = new Creator<CityEventBean>() {
      @Override
      public CityEventBean createFromParcel(Parcel source) {
        return new CityEventBean(source);
      }

      @Override
      public CityEventBean[] newArray(int size) {
        return new CityEventBean[size];
      }
    };
    /**
     * id_city_event : 4
     * city_event : Android
     */

    private String id_city_event;
    private String city_event;

    public CityEventBean() {
    }

    protected CityEventBean(Parcel in) {
      this.id_city_event = in.readString();
      this.city_event = in.readString();
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

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.id_city_event);
      dest.writeString(this.city_event);
    }
  }
}
