package com.faishalbadri.hijab.data;

import android.os.Parcel;
import java.util.List;

/**
 * Created by faishal on 11/6/17.
 */

public class PojoSlider {

  /**
   * error : false
   * message : ADA
   * slider : [{"slider_id":2,"slider_title":"asd","slider_desc":"<p>asd<\/p>\r\n","slider_img":"assets/slide_images/IMG_1513618223.png","slider_viewers":0}]
   */

  private boolean error;
  private String message;
  private List<SliderBean> slider;

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

  public List<SliderBean> getSlider() {
    return slider;
  }

  public void setSlider(List<SliderBean> slider) {
    this.slider = slider;
  }

  public static class SliderBean implements android.os.Parcelable {

    public static final Creator<SliderBean> CREATOR = new Creator<SliderBean>() {
      @Override
      public SliderBean createFromParcel(Parcel source) {
        return new SliderBean(source);
      }

      @Override
      public SliderBean[] newArray(int size) {
        return new SliderBean[size];
      }
    };
    /**
     * slider_id : 2
     * slider_title : asd
     * slider_desc : <p>asd</p>

     * slider_img : assets/slide_images/IMG_1513618223.png
     * slider_viewers : 0
     */

    private String slider_id;
    private String slider_title;
    private String slider_desc;
    private String slider_img;
    private int slider_viewers;

    public SliderBean() {
    }

    protected SliderBean(Parcel in) {
      this.slider_id = in.readString();
      this.slider_title = in.readString();
      this.slider_desc = in.readString();
      this.slider_img = in.readString();
      this.slider_viewers = in.readInt();
    }

    public String getSlider_id() {
      return slider_id;
    }

    public void setSlider_id(String slider_id) {
      this.slider_id = slider_id;
    }

    public String getSlider_title() {
      return slider_title;
    }

    public void setSlider_title(String slider_title) {
      this.slider_title = slider_title;
    }

    public String getSlider_desc() {
      return slider_desc;
    }

    public void setSlider_desc(String slider_desc) {
      this.slider_desc = slider_desc;
    }

    public String getSlider_img() {
      return slider_img;
    }

    public void setSlider_img(String slider_img) {
      this.slider_img = slider_img;
    }

    public int getSlider_viewers() {
      return slider_viewers;
    }

    public void setSlider_viewers(int slider_viewers) {
      this.slider_viewers = slider_viewers;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.slider_id);
      dest.writeString(this.slider_title);
      dest.writeString(this.slider_desc);
      dest.writeString(this.slider_img);
      dest.writeInt(this.slider_viewers);
    }
  }
}
