package com.faishalbadri.hijab.data.ebook.with_category;

import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class EbookByCategoryItem {

  @SerializedName("ebook_publisher")
  private String ebookPublisher;

  @SerializedName("ebook_image")
  private String ebookImage;

  @SerializedName("id_ebook_category")
  private String idEbookCategory;

  @SerializedName("ebook_description")
  private String ebookDescription;

  @SerializedName("ebook_title")
  private String ebookTitle;

  @SerializedName("ebook_writer")
  private String ebookWriter;

  @SerializedName("ebook_released")
  private String ebookReleased;

  @SerializedName("ebook_category_title")
  private String ebookCategoryTitle;

  @SerializedName("ebook_link")
  private String ebookLink;

  @SerializedName("id_ebook")
  private String idEbook;

  public String getEbookPublisher() {
    return ebookPublisher;
  }

  public void setEbookPublisher(String ebookPublisher) {
    this.ebookPublisher = ebookPublisher;
  }

  public String getEbookImage() {
    return ebookImage;
  }

  public void setEbookImage(String ebookImage) {
    this.ebookImage = ebookImage;
  }

  public String getIdEbookCategory() {
    return idEbookCategory;
  }

  public void setIdEbookCategory(String idEbookCategory) {
    this.idEbookCategory = idEbookCategory;
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

  public String getEbookReleased() {
    return ebookReleased;
  }

  public void setEbookReleased(String ebookReleased) {
    this.ebookReleased = ebookReleased;
  }

  public String getEbookCategoryTitle() {
    return ebookCategoryTitle;
  }

  public void setEbookCategoryTitle(String ebookCategoryTitle) {
    this.ebookCategoryTitle = ebookCategoryTitle;
  }

  public String getEbookLink() {
    return ebookLink;
  }

  public void setEbookLink(String ebookLink) {
    this.ebookLink = ebookLink;
  }

  public String getIdEbook() {
    return idEbook;
  }

  public void setIdEbook(String idEbook) {
    this.idEbook = idEbook;
  }

  @Override
  public String toString() {
    return
        "EbookByCategoryItem{" +
            "ebook_publisher = '" + ebookPublisher + '\'' +
            ",ebook_image = '" + ebookImage + '\'' +
            ",id_ebook_category = '" + idEbookCategory + '\'' +
            ",ebook_description = '" + ebookDescription + '\'' +
            ",ebook_title = '" + ebookTitle + '\'' +
            ",ebook_writer = '" + ebookWriter + '\'' +
            ",ebook_released = '" + ebookReleased + '\'' +
            ",ebook_category_title = '" + ebookCategoryTitle + '\'' +
            ",ebook_link = '" + ebookLink + '\'' +
            ",id_ebook = '" + idEbook + '\'' +
            "}";
  }
}