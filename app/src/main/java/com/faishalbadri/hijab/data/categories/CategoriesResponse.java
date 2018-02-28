package com.faishalbadri.hijab.data.categories;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class CategoriesResponse {

  @SerializedName("categories")
  private List<CategoriesItem> categories;

  @SerializedName("error")
  private boolean error;

  @SerializedName("message")
  private String message;

  public List<CategoriesItem> getCategories() {
    return categories;
  }

  public void setCategories(List<CategoriesItem> categories) {
    this.categories = categories;
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
        "CategoriesResponse{" +
            "categories = '" + categories + '\'' +
            ",error = '" + error + '\'' +
            ",message = '" + message + '\'' +
            "}";
  }
}