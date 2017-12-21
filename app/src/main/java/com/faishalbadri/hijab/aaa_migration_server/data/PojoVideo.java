package com.faishalbadri.hijab.aaa_migration_server.data;

import android.os.Parcel;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class PojoVideo {

  /**
   * error : false
   * message : ADA
   * videos : [{"video_id":4,"video_title":"YOUTUBE REWIND GAMING INDONESIA 2017 | REACTION","video_url":"-u9EZ5V-yGE","video_duration":"","video_description":"<p>Afif Yulistian<\/p>\r\n","video_category_id":8,"video_category_title":"LifeStyle"},{"video_id":3,"video_title":"SUCRD - NGOMONGIN INSTAGRAM","video_url":"qonMgEaU0ZQ","video_duration":"","video_description":"<p>Raditya Dika<\/p>\r\n","video_category_id":12,"video_category_title":"Kisahmu"}]
   */

  private boolean error;
  private String message;
  private List<VideosBean> videos;

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

  public List<VideosBean> getVideos() {
    return videos;
  }

  public void setVideos(List<VideosBean> videos) {
    this.videos = videos;
  }

  public static class VideosBean implements android.os.Parcelable {

    /**
     * video_id : 4
     * video_title : YOUTUBE REWIND GAMING INDONESIA 2017 | REACTION
     * video_url : -u9EZ5V-yGE
     * video_duration :
     * video_description : <p>Afif Yulistian</p>

     * video_category_id : 8
     * video_category_title : LifeStyle
     */

    private String video_id;
    private String video_title;
    private String video_url;
    private String video_duration;
    private String video_description;
    private String video_category_id;
    private String video_category_title;

    public String getVideo_id() {
      return video_id;
    }

    public void setVideo_id(String video_id) {
      this.video_id = video_id;
    }

    public String getVideo_title() {
      return video_title;
    }

    public void setVideo_title(String video_title) {
      this.video_title = video_title;
    }

    public String getVideo_url() {
      return video_url;
    }

    public void setVideo_url(String video_url) {
      this.video_url = video_url;
    }

    public String getVideo_duration() {
      return video_duration;
    }

    public void setVideo_duration(String video_duration) {
      this.video_duration = video_duration;
    }

    public String getVideo_description() {
      return video_description;
    }

    public void setVideo_description(String video_description) {
      this.video_description = video_description;
    }

    public String getVideo_category_id() {
      return video_category_id;
    }

    public void setVideo_category_id(String video_category_id) {
      this.video_category_id = video_category_id;
    }

    public String getVideo_category_title() {
      return video_category_title;
    }

    public void setVideo_category_title(String video_category_title) {
      this.video_category_title = video_category_title;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.video_id);
      dest.writeString(this.video_title);
      dest.writeString(this.video_url);
      dest.writeString(this.video_duration);
      dest.writeString(this.video_description);
      dest.writeString(this.video_category_id);
      dest.writeString(this.video_category_title);
    }

    public VideosBean() {
    }

    protected VideosBean(Parcel in) {
      this.video_id = in.readString();
      this.video_title = in.readString();
      this.video_url = in.readString();
      this.video_duration = in.readString();
      this.video_description = in.readString();
      this.video_category_id = in.readString();
      this.video_category_title = in.readString();
    }

    public static final Creator<VideosBean> CREATOR = new Creator<VideosBean>() {
      @Override
      public VideosBean createFromParcel(Parcel source) {
        return new VideosBean(source);
      }

      @Override
      public VideosBean[] newArray(int size) {
        return new VideosBean[size];
      }
    };
  }
}
