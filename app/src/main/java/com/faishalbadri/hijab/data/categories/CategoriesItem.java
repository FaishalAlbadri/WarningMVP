package com.faishalbadri.hijab.data.categories;

import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class CategoriesItem {

  @SerializedName("category_name")
  private String categoryName;

  @SerializedName("category_id")
  private String categoryId;

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public String getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

  @Override
  public String toString() {
    return
        "CategoriesItem{" +
            "category_name = '" + categoryName + '\'' +
            ",category_id = '" + categoryId + '\'' +
            "}";
  }
}