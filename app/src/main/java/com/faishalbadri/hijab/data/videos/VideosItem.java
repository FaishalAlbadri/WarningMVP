package com.faishalbadri.hijab.data.videos;

import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class VideosItem {

  @SerializedName("video_description")
  private String videoDescription;

  @SerializedName("video_duration")
  private String videoDuration;

  @SerializedName("video_url")
  private String videoUrl;

  @SerializedName("video_category_id")
  private String videoCategoryId;

  @SerializedName("video_title")
  private String videoTitle;

  @SerializedName("video_category_title")
  private String videoCategoryTitle;

  @SerializedName("video_id")
  private String videoId;

  public String getVideoDescription() {
    return videoDescription;
  }

  public void setVideoDescription(String videoDescription) {
    this.videoDescription = videoDescription;
  }

  public String getVideoDuration() {
    return videoDuration;
  }

  public void setVideoDuration(String videoDuration) {
    this.videoDuration = videoDuration;
  }

  public String getVideoUrl() {
    return videoUrl;
  }

  public void setVideoUrl(String videoUrl) {
    this.videoUrl = videoUrl;
  }

  public String getVideoCategoryId() {
    return videoCategoryId;
  }

  public void setVideoCategoryId(String videoCategoryId) {
    this.videoCategoryId = videoCategoryId;
  }

  public String getVideoTitle() {
    return videoTitle;
  }

  public void setVideoTitle(String videoTitle) {
    this.videoTitle = videoTitle;
  }

  public String getVideoCategoryTitle() {
    return videoCategoryTitle;
  }

  public void setVideoCategoryTitle(String videoCategoryTitle) {
    this.videoCategoryTitle = videoCategoryTitle;
  }

  public String getVideoId() {
    return videoId;
  }

  public void setVideoId(String videoId) {
    this.videoId = videoId;
  }

  @Override
  public String toString() {
    return
        "VideosItem{" +
            "video_description = '" + videoDescription + '\'' +
            ",video_duration = '" + videoDuration + '\'' +
            ",video_url = '" + videoUrl + '\'' +
            ",video_category_id = '" + videoCategoryId + '\'' +
            ",video_title = '" + videoTitle + '\'' +
            ",video_category_title = '" + videoCategoryTitle + '\'' +
            ",video_id = '" + videoId + '\'' +
            "}";
  }
}