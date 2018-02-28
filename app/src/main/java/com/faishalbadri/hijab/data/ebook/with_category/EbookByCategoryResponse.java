package com.faishalbadri.hijab.data.ebook.with_category;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class EbookByCategoryResponse {

  @SerializedName("data")
  private List<EbookCategoryItem> data;

  @SerializedName("error")
  private boolean error;

  @SerializedName("message")
  private String message;

  public List<EbookCategoryItem> getData() {
    return data;
  }

  public void setData(List<EbookCategoryItem> data) {
    this.data = data;
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
        "EbookByCategoryResponse{" +
            "data = '" + data + '\'' +
            ",error = '" + error + '\'' +
            ",message = '" + message + '\'' +
            "}";
  }
}