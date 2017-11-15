package com.faishalbadri.hijab.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;

/**
 * Created by faishal on 15/11/17.
 */

public class PojoSponsor {


  /**
   * sponsor : [{"id_sponsor":"1","sponsor_title":"asd","sponsor_image":"eew.png","sponsor_link":"google.com"}]
   * status : 1
   * msg : Data Semua sponsor
   */

  private String status;
  private String msg;
  private List<SponsorBean> sponsor;

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

  public List<SponsorBean> getSponsor() {
    return sponsor;
  }

  public void setSponsor(List<SponsorBean> sponsor) {
    this.sponsor = sponsor;
  }

  public static class SponsorBean implements android.os.Parcelable {

    /**
     * id_sponsor : 1
     * sponsor_title : asd
     * sponsor_image : eew.png
     * sponsor_link : google.com
     */

    private String id_sponsor;
    private String sponsor_title;
    private String sponsor_image;
    private String sponsor_link;

    public String getId_sponsor() {
      return id_sponsor;
    }

    public void setId_sponsor(String id_sponsor) {
      this.id_sponsor = id_sponsor;
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
      dest.writeString(this.id_sponsor);
      dest.writeString(this.sponsor_title);
      dest.writeString(this.sponsor_image);
      dest.writeString(this.sponsor_link);
    }

    public SponsorBean() {
    }

    protected SponsorBean(Parcel in) {
      this.id_sponsor = in.readString();
      this.sponsor_title = in.readString();
      this.sponsor_image = in.readString();
      this.sponsor_link = in.readString();
    }

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
  }
}
