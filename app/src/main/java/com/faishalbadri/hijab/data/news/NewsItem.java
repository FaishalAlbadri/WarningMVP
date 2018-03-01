package com.faishalbadri.hijab.data.news;

import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class NewsItem {

  @SerializedName("news_description")
  private String newsDescription;

  @SerializedName("news_author")
  private NewsAuthor newsAuthor;

  @SerializedName("news_total_viewers")
  private String newsTotalViewers;

  @SerializedName("news_created_at")
  private String newsCreatedAt;

  @SerializedName("news_title")
  private String newsTitle;

  @SerializedName("news_images")
  private String newsImages;

  @SerializedName("news_category")
  private String newsCategory;

  @SerializedName("news_id")
  private String newsId;

  public String getNewsDescription() {
    return newsDescription;
  }

  public void setNewsDescription(String newsDescription) {
    this.newsDescription = newsDescription;
  }

  public NewsAuthor getNewsAuthor() {
    return newsAuthor;
  }

  public void setNewsAuthor(NewsAuthor newsAuthor) {
    this.newsAuthor = newsAuthor;
  }

  public String getNewsTotalViewers() {
    return newsTotalViewers;
  }

  public void setNewsTotalViewers(String newsTotalViewers) {
    this.newsTotalViewers = newsTotalViewers;
  }

  public String getNewsCreatedAt() {
    return newsCreatedAt;
  }

  public void setNewsCreatedAt(String newsCreatedAt) {
    this.newsCreatedAt = newsCreatedAt;
  }

  public String getNewsTitle() {
    return newsTitle;
  }

  public void setNewsTitle(String newsTitle) {
    this.newsTitle = newsTitle;
  }

  public String getNewsImages() {
    return newsImages;
  }

  public void setNewsImages(String newsImages) {
    this.newsImages = newsImages;
  }

  public String getNewsCategory() {
    return newsCategory;
  }

  public void setNewsCategory(String newsCategory) {
    this.newsCategory = newsCategory;
  }

  public String getNewsId() {
    return newsId;
  }

  public void setNewsId(String newsId) {
    this.newsId = newsId;
  }

  @Override
  public String toString() {
    return
        "NewsItem{" +
            "news_description = '" + newsDescription + '\'' +
            ",news_author = '" + newsAuthor + '\'' +
            ",news_total_viewers = '" + newsTotalViewers + '\'' +
            ",news_created_at = '" + newsCreatedAt + '\'' +
            ",news_title = '" + newsTitle + '\'' +
            ",news_images = '" + newsImages + '\'' +
            ",news_category = '" + newsCategory + '\'' +
            ",news_id = '" + newsId + '\'' +
            "}";
  }
}