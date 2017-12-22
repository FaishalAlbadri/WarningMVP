package com.faishalbadri.hijab.data;

import android.os.Parcel;
import java.util.List;

/**
 * Created by faishal on 15/11/17.
 */

public class PojoSponsor {

  /**
   * error : false
   * message : ADA
   * sponsor : [{"sponsor_id":2,"sponsor_title":"asd","sponsor_image":"assets/sponsor_images/IMG_1513618241.png","sponsor_link":"google.com"}]
   */

  private boolean error;
  private String message;
  private List<SponsorBean> sponsor;

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

  public List<SponsorBean> getSponsor() {
    return sponsor;
  }

  public void setSponsor(List<SponsorBean> sponsor) {
    this.sponsor = sponsor;
  }

  public static class SponsorBean implements android.os.Parcelable {

    public static final Creator<SponsorBean> CREATOR = new Creator<SponsorBean>() {
      @Override
      public SponsorBean createFromParcel(Parcel source) {
        return new SponsorBean(source);
      }

      @Override
      public SponsorBean[] newArray(int size) {
        return new SponsorBean[size];
      }
    };
    /**
     * sponsor_id : 2
     * sponsor_title : asd
     * sponsor_image : assets/sponsor_images/IMG_1513618241.png
     * sponsor_link : google.com
     */

    private String sponsor_id;
    private String sponsor_title;
    private String sponsor_image;
    private String sponsor_link;

    public SponsorBean() {
    }

    protected SponsorBean(Parcel in) {
      this.sponsor_id = in.readString();
      this.sponsor_title = in.readString();
      this.sponsor_image = in.readString();
      this.sponsor_link = in.readString();
    }

    public String getSponsor_id() {
      return sponsor_id;
    }

    public void setSponsor_id(String sponsor_id) {
      this.sponsor_id = sponsor_id;
    }

    public String getSponsor_title() {
      return sponsor_title;
    }

    public void setSponsor_title(String sponsor_title) {
      this.sponsor_title = sponsor_title;
    }

    public String getSponsor_image() {
      return sponsor_image;
    }

    public void setSponsor_image(String sponsor_image) {
      this.sponsor_image = sponsor_image;
    }

    public String getSponsor_link() {
      return sponsor_link;
    }

    public void setSponsor_link(String sponsor_link) {
      this.sponsor_link = sponsor_link;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.sponsor_id);
      dest.writeString(this.sponsor_title);
      dest.writeString(this.sponsor_image);
      dest.writeString(this.sponsor_link);
    }
  }
}
