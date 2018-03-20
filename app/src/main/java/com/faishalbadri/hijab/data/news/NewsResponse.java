package com.faishalbadri.hijab.data.news;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class NewsResponse {

  @SerializedName("news")
  private List<NewsItem> news;

  @SerializedName("error")
  private boolean error;

  @SerializedName("message")
  private String message;

  public List<NewsItem> getNews() {
    return news;
  }

  public void setNews(List<NewsItem> news) {
    this.news = news;
  }

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

  @Override
  public String toString() {
    return
        "NewsResponse{" +
            "news = '" + news + '\'' +
            ",error = '" + error + '\'' +
            ",message = '" + message + '\'' +
            "}";
  }
}