package com.faishalbadri.hijab.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public class PojoVideoPerkat {

  /**
   * video : [{"id":"1","judul_video":"Hampir Di Cium HARUKA!!","video":"ehcyDLnTWuQ","duration":"3:46","id_kategori":"1"},{"id":"2","judul_video":"REFRESHER MONKEY KING DOTA 2 PATCH 7.06 NEW META PRO GAMEPLAY","video":"MLbvrYpLOLw","duration":"10:02","id_kategori":"1"}]
   * status : 1
   * msg : Data Semua Video
   */

  private String status;
  private String msg;
  private List<VideoBean> video;

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

  public List<VideoBean> getVideo() {
    return video;
  }

  public void setVideo(List<VideoBean> video) {
    this.video = video;
  }

  public static class VideoBean implements Parcelable{

    /**
     * id : 1
     * judul_video : Hampir Di Cium HARUKA!!
     * video : ehcyDLnTWuQ
     * duration : 3:46
     * id_kategori : 1
     */

    private String id;
    private String judul_video;
    private String video;
    private String duration;
    private String id_kategori;

    protected VideoBean(Parcel in) {
      id = in.readString();
      judul_video = in.readString();
      video = in.readString();
      duration = in.readString();
      id_kategori = in.readString();
    }

    public static final Creator<VideoBean> CREATOR = new Creator<VideoBean>() {
      @Override
      public VideoBean createFromParcel(Parcel in) {
        return new VideoBean(in);
      }

      @Override
      public VideoBean[] newArray(int size) {
        return new VideoBean[size];
      }
    };

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getJudul_video() {
      return judul_video;
    }

    public void setJudul_video(String judul_video) {
      this.judul_video = judul_video;
    }

    public String getVideo() {
      return video;
    }

    public void setVideo(String video) {
      this.video = video;
    }

    public String getDuration() {
      return duration;
    }

    public void setDuration(String duration) {
      this.duration = duration;
    }

    public String getId_kategori() {
      return id_kategori;
    }

    public void setId_kategori(String id_kategori) {
      this.id_kategori = id_kategori;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(id);
      dest.writeString(judul_video);
      dest.writeString(video);
      dest.writeString(duration);
      dest.writeString(id_kategori);
    }
  }
}
