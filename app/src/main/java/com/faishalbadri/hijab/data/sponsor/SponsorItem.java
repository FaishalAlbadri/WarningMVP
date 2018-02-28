package com.faishalbadri.hijab.data.sponsor;

import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class SponsorItem {

  @SerializedName("sponsor_title")
  private String sponsorTitle;

  @SerializedName("sponsor_link")
  private String sponsorLink;

  @SerializedName("sponsor_image")
  private String sponsorImage;

  @SerializedName("sponsor_id")
  private String sponsorId;

  public String getSponsorTitle() {
    return sponsorTitle;
  }

  public void setSponsorTitle(String sponsorTitle) {
    this.sponsorTitle = sponsorTitle;
  }

  public String getSponsorLink() {
    return sponsorLink;
  }

  public void setSponsorLink(String sponsorLink) {
    this.sponsorLink = sponsorLink;
  }

  public String getSponsorImage() {
    return sponsorImage;
  }

  public void setSponsorImage(String sponsorImage) {
    this.sponsorImage = sponsorImage;
  }

  public String getSponsorId() {
    return sponsorId;
  }

  public void setSponsorId(String sponsorId) {
    this.sponsorId = sponsorId;
  }

  @Override
  public String toString() {
    return
        "SponsorItem{" +
            "sponsor_title = '" + sponsorTitle + '\'' +
            ",sponsor_link = '" + sponsorLink + '\'' +
            ",sponsor_image = '" + sponsorImage + '\'' +
            ",sponsor_id = '" + sponsorId + '\'' +
            "}";
  }
}