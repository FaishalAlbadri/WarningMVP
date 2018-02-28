package com.faishalbadri.hijab.data.ebook;

import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class EbookItem {

  @SerializedName("ebook_publisher")
  private String ebookPublisher;

  @SerializedName("ebook_category_name")
  private String ebookCategoryName;

  @SerializedName("ebook_image")
  private String ebookImage;

  @SerializedName("ebook_description")
  private String ebookDescription;

  @SerializedName("ebook_title")
  private String ebookTitle;

  @SerializedName("ebook_writer")
  private String ebookWriter;

  @SerializedName("ebook_release_date")
  private String ebookReleaseDate;

  @SerializedName("ebook_category_id")
  private String ebookCategoryId;

  @SerializedName("ebook_id")
  private String ebookId;

  @SerializedName("ebook_link")
  private String ebookLink;

  public String getEbookPublisher() {
    return ebookPublisher;
  }

  public void setEbookPublisher(String ebookPublisher) {
    this.ebookPublisher = ebookPublisher;
  }

  public String getEbookCategoryName() {
    return ebookCategoryName;
  }

  public void setEbookCategoryName(String ebookCategoryName) {
    this.ebookCategoryName = ebookCategoryName;
  }

  public String getEbookImage() {
    return ebookImage;
  }

  public void setEbookImage(String ebookImage) {
    this.ebookImage = ebookImage;
  }

  public String getEbookDescription() {
    return ebookDescription;
  }

  public void setEbookDescription(String ebookDescription) {
    this.ebookDescription = ebookDescription;
  }

  public String getEbookTitle() {
    return ebookTitle;
  }

  public void setEbookTitle(String ebookTitle) {
    this.ebookTitle = ebookTitle;
  }

  public String getEbookWriter() {
    return ebookWriter;
  }

  public void setEbookWriter(String ebookWriter) {
    this.ebookWriter = ebookWriter;
  }

  public String getEbookReleaseDate() {
    return ebookReleaseDate;
  }

  public void setEbookReleaseDate(String ebookReleaseDate) {
    this.ebookReleaseDate = ebookReleaseDate;
  }

  public String getEbookCategoryId() {
    return ebookCategoryId;
  }

  public void setEbookCategoryId(String ebookCategoryId) {
    this.ebookCategoryId = ebookCategoryId;
  }

  public String getEbookId() {
    return ebookId;
  }

  public void setEbookId(String ebookId) {
    this.ebookId = ebookId;
  }

  public String getEbookLink() {
    return ebookLink;
  }

  public void setEbookLink(String ebookLink) {
    this.ebookLink = ebookLink;
  }

  @Override
  public String toString() {
    return
        "EbookByCategoryItem{" +
            "ebook_publisher = '" + ebookPublisher + '\'' +
            ",ebook_category_name = '" + ebookCategoryName + '\'' +
            ",ebook_image = '" + ebookImage + '\'' +
            ",ebook_description = '" + ebookDescription + '\'' +
            ",ebook_title = '" + ebookTitle + '\'' +
            ",ebook_writer = '" + ebookWriter + '\'' +
            ",ebook_release_date = '" + ebookReleaseDate + '\'' +
            ",ebook_category_id = '" + ebookCategoryId + '\'' +
            ",ebook_id = '" + ebookId + '\'' +
            ",ebook_link = '" + ebookLink + '\'' +
            "}";
  }
}