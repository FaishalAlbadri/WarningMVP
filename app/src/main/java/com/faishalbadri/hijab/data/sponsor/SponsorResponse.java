package com.faishalbadri.hijab.data.sponsor;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class SponsorResponse {

  @SerializedName("sponsor")
  private List<SponsorItem> sponsor;

  @SerializedName("error")
  private boolean error;

  @SerializedName("message")
  private String message;

  public List<SponsorItem> getSponsor() {
    return sponsor;
  }

  public void setSponsor(List<SponsorItem> sponsor) {
    this.sponsor = sponsor;
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
        "SponsorResponse{" +
            "sponsor = '" + sponsor + '\'' +
            ",error = '" + error + '\'' +
            ",message = '" + message + '\'' +
            "}";
  }
}