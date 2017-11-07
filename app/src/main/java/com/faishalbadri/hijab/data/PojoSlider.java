package com.faishalbadri.hijab.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;

/**
 * Created by faishal on 11/6/17.
 */

public class PojoSlider {

  /**
   * slider : [{"id_slider":"8","slider_judul":"Coba","slider_gambar":"eew.png","slider_keterangan":"COba","slider_view":"0"},{"id_slider":"9","slider_judul":"Coba","slider_gambar":"eew.png","slider_keterangan":"COba","slider_view":"0"},{"id_slider":"10","slider_judul":"Coba","slider_gambar":"eew.png","slider_keterangan":"COba","slider_view":"0"},{"id_slider":"11","slider_judul":"Coba","slider_gambar":"eew.png","slider_keterangan":"COba","slider_view":"0"}]
   * status : 1
   * msg : Data Semua Slider
   */

  private String status;
  private String msg;
  private List<SliderBean> slider;

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

  public List<SliderBean> getSlider() {
    return slider;
  }

  public void setSlider(List<SliderBean> slider) {
    this.slider = slider;
  }

  public static class SliderBean implements android.os.Parcelable {

    /**
     * id_slider : 8
     * slider_judul : Coba
     * slider_gambar : eew.png
     * slider_keterangan : COba
     * slider_view : 0
     */

    private String id_slider;
    private String slider_judul;
    private String slider_gambar;
    private String slider_keterangan;
    private String slider_view;

    public String getId_slider() {
      return id_slider;
    }

    public void setId_slider(String id_slider) {
      this.id_slider = id_slider;
    }

    public String getSlider_judul() {
      return slider_judul;
    }

    public void setSlider_judul(String slider_judul) {
      this.slider_judul = slider_judul;
    }

    public String getSlider_gambar() {
      return slider_gambar;
    }

    public void setSlider_gambar(String slider_gambar) {
      this.slider_gambar = slider_gambar;
    }

    public String getSlider_keterangan() {
      return slider_keterangan;
    }

    public void setSlider_keterangan(String slider_keterangan) {
      this.slider_keterangan = slider_keterangan;
    }

    public String getSlider_view() {
      return slider_view;
    }

    public void setSlider_view(String slider_view) {
      this.slider_view = slider_view;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.id_slider);
      dest.writeString(this.slider_judul);
      dest.writeString(this.slider_gambar);
      dest.writeString(this.slider_keterangan);
      dest.writeString(this.slider_view);
    }

    public SliderBean() {
    }

    protected SliderBean(Parcel in) {
      this.id_slider = in.readString();
      this.slider_judul = in.readString();
      this.slider_gambar = in.readString();
      this.slider_keterangan = in.readString();
      this.slider_view = in.readString();
    }

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
  }
}
