package com.faishalbadri.hijab.data.news;

import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class NewsAuthor {

  @SerializedName("news_author_id")
  private String newsAuthorId;

  @SerializedName("news_author_name")
  private String newsAuthorName;

  public String getNewsAuthorId() {
    return newsAuthorId;
  }

  public void setNewsAuthorId(String newsAuthorId) {
    this.newsAuthorId = newsAuthorId;
  }

  public String getNewsAuthorName() {
    return newsAuthorName;
  }

  public void setNewsAuthorName(String newsAuthorName) {
    this.newsAuthorName = newsAuthorName;
  }

  @Override
  public String toString() {
    return
        "NewsAuthor{" +
            "news_author_id = '" + newsAuthorId + '\'' +
            ",news_author_name = '" + newsAuthorName + '\'' +
            "}";
  }
}