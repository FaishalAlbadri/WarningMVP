package com.faishalbadri.hijab.data.videos;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class VideosResponse {

  @SerializedName("videos")
  private List<VideosItem> videos;

  @SerializedName("error")
  private boolean error;

  @SerializedName("message")
  private String message;

  public List<VideosItem> getVideos() {
    return videos;
  }

  public void setVideos(List<VideosItem> videos) {
    this.videos = videos;
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
        "VideosResponse{" +
            "videos = '" + videos + '\'' +
            ",error = '" + error + '\'' +
            ",message = '" + message + '\'' +
            "}";
  }
}