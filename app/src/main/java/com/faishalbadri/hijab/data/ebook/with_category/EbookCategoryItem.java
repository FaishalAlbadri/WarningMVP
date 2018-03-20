package com.faishalbadri.hijab.data.ebook.with_category;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class EbookCategoryItem {

  @SerializedName("ebook_category_name")
  private String ebookCategoryName;

  @SerializedName("ebook")
  private List<EbookByCategoryItem> ebook;

  @SerializedName("ebook_category_id")
  private String ebookCategoryId;

  public String getEbookCategoryName() {
    return ebookCategoryName;
  }

  public void setEbookCategoryName(String ebookCategoryName) {
    this.ebookCategoryName = ebookCategoryName;
  }

  public List<EbookByCategoryItem> getEbook() {
    return ebook;
  }

  public void setEbook(List<EbookByCategoryItem> ebook) {
    this.ebook = ebook;
  }

  public String getEbookCategoryId() {
    return ebookCategoryId;
  }

  public void setEbookCategoryId(String ebookCategoryId) {
    this.ebookCategoryId = ebookCategoryId;
  }

  @Override
  public String toString() {
    return
        "EbookCategoryItem{" +
            "ebook_category_name = '" + ebookCategoryName + '\'' +
            ",ebook = '" + ebook + '\'' +
            ",ebook_category_id = '" + ebookCategoryId + '\'' +
            "}";
  }
}