package com.faishalbadri.hijab.data;

import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class PojoNews {

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

  public static class NewsBean {

    private String news_id;
    private String news_category;
    private String news_category_id;
    private String news_total_viewers;
    private NewsAuthorBean news_author;
    private String news_title;
    private String news_created_at;
    private String news_description;
    private String news_images;

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

    public String getNews_category_id() {
      return news_category_id;
    }

    public void setNews_category_id(String news_category_id) {
      this.news_category_id = news_category_id;
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

    public static class NewsAuthorBean {

      /**
       * news_author_id : 2
       * news_author_name : admin
       */

      private String news_author_id;
      private String news_author_name;

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
    }
  }
}
