package com.faishalbadri.hijab.data;

import android.os.Parcel;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class PojoNews {

  /**
   * error : false message : ADA news : [{"news_id":8,"news_category":"Financial","news_total_viewers":0,"news_author":{"news_author_id":1,"news_author_name":"Andi"},"news_title":"hgfjhg","news_created_at":"2017-12-18
   * 17:13:23","news_description":"<p>gfhcg<\/p>\r\n","news_images":"assets/news_images/IMG_1513617203.png"}]
   */

  private boolean error;
  private String message;
  private List<NewsBean> news;

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

  public List<NewsBean> getNews() {
    return news;
  }

  public void setNews(List<NewsBean> news) {
    this.news = news;
  }

  public static class NewsBean implements android.os.Parcelable {

    public static final Creator<NewsBean> CREATOR = new Creator<NewsBean>() {
      @Override
      public NewsBean createFromParcel(Parcel source) {
        return new NewsBean(source);
      }

      @Override
      public NewsBean[] newArray(int size) {
        return new NewsBean[size];
      }
    };
    /**
     * news_id : 8
     * news_category : Financial
     * news_total_viewers : 0
     * news_author : {"news_author_id":1,"news_author_name":"Andi"}
     * news_title : hgfjhg
     * news_created_at : 2017-12-18 17:13:23
     * news_description : <p>gfhcg</p>
     *
     * news_images : assets/news_images/IMG_1513617203.png
     */

    private String news_id;
    private String news_category;
    private String news_total_viewers;
    private NewsAuthorBean news_author;
    private String news_title;
    private String news_created_at;
    private String news_description;
    private String news_images;

    public NewsBean() {
    }

    protected NewsBean(Parcel in) {
      this.news_id = in.readString();
      this.news_category = in.readString();
      this.news_total_viewers = in.readString();
      this.news_author = in.readParcelable(NewsAuthorBean.class.getClassLoader());
      this.news_title = in.readString();
      this.news_created_at = in.readString();
      this.news_description = in.readString();
      this.news_images = in.readString();
    }

    public String getNews_id() {
      return news_id;
    }

    public void setNews_id(String news_id) {
      this.news_id = news_id;
    }

    public String getNews_category() {
      return news_category;
    }

    public void setNews_category(String news_category) {
      this.news_category = news_category;
    }

    public String getNews_total_viewers() {
      return news_total_viewers;
    }

    public void setNews_total_viewers(String news_total_viewers) {
      this.news_total_viewers = news_total_viewers;
    }

    public NewsAuthorBean getNews_author() {
      return news_author;
    }

    public void setNews_author(NewsAuthorBean news_author) {
      this.news_author = news_author;
    }

    public String getNews_title() {
      return news_title;
    }

    public void setNews_title(String news_title) {
      this.news_title = news_title;
    }

    public String getNews_created_at() {
      return news_created_at;
    }

    public void setNews_created_at(String news_created_at) {
      this.news_created_at = news_created_at;
    }

    public String getNews_description() {
      return news_description;
    }

    public void setNews_description(String news_description) {
      this.news_description = news_description;
    }

    public String getNews_images() {
      return news_images;
    }

    public void setNews_images(String news_images) {
      this.news_images = news_images;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.news_id);
      dest.writeString(this.news_category);
      dest.writeString(this.news_total_viewers);
      dest.writeParcelable(this.news_author, flags);
      dest.writeString(this.news_title);
      dest.writeString(this.news_created_at);
      dest.writeString(this.news_description);
      dest.writeString(this.news_images);
    }

    public static class NewsAuthorBean implements android.os.Parcelable {

      public static final Creator<NewsAuthorBean> CREATOR = new Creator<NewsAuthorBean>() {
        @Override
        public NewsAuthorBean createFromParcel(Parcel source) {
          return new NewsAuthorBean(source);
        }

        @Override
        public NewsAuthorBean[] newArray(int size) {
          return new NewsAuthorBean[size];
        }
      };
      /**
       * news_author_id : 1
       * news_author_name : Andi
       */

      private String news_author_id;
      private String news_author_name;

      public NewsAuthorBean() {
      }

      protected NewsAuthorBean(Parcel in) {
        this.news_author_id = in.readString();
        this.news_author_name = in.readString();
      }

      public String getNews_author_id() {
        return news_author_id;
      }

      public void setNews_author_id(String news_author_id) {
        this.news_author_id = news_author_id;
      }

      public String getNews_author_name() {
        return news_author_name;
      }

      public void setNews_author_name(String news_author_name) {
        this.news_author_name = news_author_name;
      }

      @Override
      public int describeContents() {
        return 0;
      }

      @Override
      public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.news_author_id);
        dest.writeString(this.news_author_name);
      }
    }
  }
}
