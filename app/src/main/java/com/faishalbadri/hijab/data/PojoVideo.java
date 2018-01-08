package com.faishalbadri.hijab.data;

import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class PojoVideo {

  /**
   * error : false
   * message : ADA
   * videos : [{"video_id":27,"video_title":"Desainer Of The Week | Harika","video_url":"0e2Cxo-Ntjc","video_duration":"","video_description":"<p>FOLLOW IG @pinkyhijabcommunity @pinkmuslimahcom<\/p>\r\n","video_category_id":1,"video_category_title":"Muslimah Inspiratif"},{"video_id":26,"video_title":"Artis  Of The Week | Livina","video_url":"ySFBL5-gvTo","video_duration":"","video_description":"<p>FOLLOW IG @pinkyhijabcommunity @pinkmuslimahcom<\/p>\r\n","video_category_id":1,"video_category_title":"Muslimah Inspiratif"},{"video_id":25,"video_title":"Desainer Of The Week | Zebu","video_url":"MOFI4sYBrNY","video_duration":"","video_description":"<p>FOLLOW IG @pinkyhijabcommunity @pinkmuslimahcom<\/p>\r\n","video_category_id":1,"video_category_title":"Muslimah Inspiratif"},{"video_id":24,"video_title":"Desainer Of The Week |  Moca Irma Nurul Hakim","video_url":"5mjAVfLxvSI","video_duration":"","video_description":"<p>FOLLOW IG @pinkyhijabcommunity @pinkmuslimahcom<\/p>\r\n","video_category_id":1,"video_category_title":"Muslimah Inspiratif"},{"video_id":23,"video_title":"Desainer Of The Week | Deni Anggraeni","video_url":"9Tyc0C_zNSo","video_duration":"","video_description":"<p>&nbsp;FOLLOW IG @pinkyhijabcommunity @pinkmuslimahcom<\/p>\r\n","video_category_id":1,"video_category_title":"Muslimah Inspiratif"},{"video_id":22,"video_title":"Lily Pink Lookbook | Pinky Hijab Community","video_url":"GxN_vSQLwTM","video_duration":"","video_description":"<p>FOLLOW IG @pinkyhijabcommunity @pinkmuslimahcom<\/p>\r\n","video_category_id":6,"video_category_title":"Fashion"},{"video_id":21,"video_title":"Beauty Pink Lookbook | Pinky Hijab Community","video_url":"PmbgjrnRmzw","video_duration":"","video_description":"<p>FOLLOW IG @pinkyhijabcommunity @pinkmuslimahcom<\/p>\r\n","video_category_id":6,"video_category_title":"Fashion"},{"video_id":20,"video_title":"Star Pink Lookbook | Pinky Hijab Community","video_url":"oWMu91V6fU0","video_duration":"","video_description":"<p>FOLLOW IG @pinkyhijabcommunity @pinkmuslimah<\/p>\r\n","video_category_id":6,"video_category_title":"Fashion"},{"video_id":19,"video_title":"Swallow Pink Lookbook | Pinky Hijab Community","video_url":"atmfetcrzWs","video_duration":"","video_description":"<p>FOLLOW IG @pinkyhijabcommunity @pinkmuslimah<\/p>\r\n","video_category_id":6,"video_category_title":"Fashion"},{"video_id":18,"video_title":"Snow Pink Lookbook | Pinky Hijab Community","video_url":"cZMdgHSmzCU","video_duration":"","video_description":"<p>FOLLOW IG @pinkyhijabcommunity @pinkmuslimah<\/p>\r\n","video_category_id":6,"video_category_title":"Fashion"}]
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

  public static class VideosBean {

    /**
     * video_id : 27
     * video_title : Desainer Of The Week | Harika
     * video_url : 0e2Cxo-Ntjc
     * video_duration :
     * video_description : <p>FOLLOW IG @pinkyhijabcommunity @pinkmuslimahcom</p>

     * video_category_id : 1
     * video_category_title : Muslimah Inspiratif
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
  }
}
