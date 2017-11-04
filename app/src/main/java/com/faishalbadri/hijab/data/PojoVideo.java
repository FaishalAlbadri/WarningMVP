package com.faishalbadri.hijab.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class PojoVideo {

  /**
   * video : [{"id":"8","judul_video":"Dimitri Vegas & Like Mike vs David Guetta feat. Kiiara - Complicated (Official Music Video)\r\n","video":"w0EF3AxJwLU","duration":" 3:09"},{"id":"7","judul_video":"Martin Garrix & Troye Sivan - There For You (Official Video)","video":"pNNMr5glICM","duration":"3:40"},{"id":"6","judul_video":"Dimitri Vegas & Like Mike vs David Guetta feat. Kiiara - Complicated (Official Music Video)\n","video":"w0EF3AxJwLU","duration":" 3:09"},{"id":"5","judul_video":"Martin Garrix & Troye Sivan - There For You (Official Video)","video":"pNNMr5glICM","duration":"3:40"},{"id":"4","judul_video":"Wendy Bete Karena Dituduh Mengambil Snack - Ini Talk Show 23 April 2016 (3/6)\n","video":"L5NT-m5GGPg","duration":"15:23"},{"id":"3","judul_video":"6 RAPIERS ON PHANTOM ASSASSIN IN-GAME DOTA 2","video":"VNTH1CCVtJA","duration":"45:08"},{"id":"2","judul_video":"REFRESHER MONKEY KING DOTA 2 PATCH 7.06 NEW META PRO GAMEPLAY","video":"MLbvrYpLOLw","duration":"10:02"},{"id":"1","judul_video":"Hampir Di Cium HARUKA!!","video":"ehcyDLnTWuQ","duration":"3:46"}]
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
     * id : 8
     * judul_video : Dimitri Vegas & Like Mike vs David Guetta feat. Kiiara - Complicated (Official Music Video)

     * video : w0EF3AxJwLU
     * duration :  3:09
     */

    private String id;
    private String judul_video;
    private String video;
    private String duration;

    protected VideoBean(Parcel in) {
      id = in.readString();
      judul_video = in.readString();
      video = in.readString();
      duration = in.readString();
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
    }
  }
}
