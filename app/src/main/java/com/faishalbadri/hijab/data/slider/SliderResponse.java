package com.faishalbadri.hijab.data.slider;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class SliderResponse {

  @SerializedName("slider")
  private List<SliderItem> slider;

  @SerializedName("error")
  private boolean error;

  @SerializedName("message")
  private String message;

  public List<SliderItem> getSlider() {
    return slider;
  }

  public void setSlider(List<SliderItem> slider) {
    this.slider = slider;
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
        "SliderResponse{" +
            "slider = '" + slider + '\'' +
            ",error = '" + error + '\'' +
            ",message = '" + message + '\'' +
            "}";
  }
}