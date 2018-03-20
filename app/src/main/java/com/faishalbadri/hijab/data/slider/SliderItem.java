package com.faishalbadri.hijab.data.slider;

import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class SliderItem {

  @SerializedName("slider_viewers")
  private String sliderViewers;

  @SerializedName("slider_img")
  private String sliderImg;

  @SerializedName("slider_desc")
  private String sliderDesc;

  @SerializedName("slider_title")
  private String sliderTitle;

  @SerializedName("slider_id")
  private String sliderId;

  public String getSliderViewers() {
    return sliderViewers;
  }

  public void setSliderViewers(String sliderViewers) {
    this.sliderViewers = sliderViewers;
  }

  public String getSliderImg() {
    return sliderImg;
  }

  public void setSliderImg(String sliderImg) {
    this.sliderImg = sliderImg;
  }

  public String getSliderDesc() {
    return sliderDesc;
  }

  public void setSliderDesc(String sliderDesc) {
    this.sliderDesc = sliderDesc;
  }

  public String getSliderTitle() {
    return sliderTitle;
  }

  public void setSliderTitle(String sliderTitle) {
    this.sliderTitle = sliderTitle;
  }

  public String getSliderId() {
    return sliderId;
  }

  public void setSliderId(String sliderId) {
    this.sliderId = sliderId;
  }

  @Override
  public String toString() {
    return
        "SliderItem{" +
            "slider_viewers = '" + sliderViewers + '\'' +
            ",slider_img = '" + sliderImg + '\'' +
            ",slider_desc = '" + sliderDesc + '\'' +
            ",slider_title = '" + sliderTitle + '\'' +
            ",slider_id = '" + sliderId + '\'' +
            "}";
  }
}