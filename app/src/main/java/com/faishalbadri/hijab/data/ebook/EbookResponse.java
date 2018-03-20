package com.faishalbadri.hijab.data.ebook;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class EbookResponse {

  @SerializedName("ebook")
  private List<EbookItem> ebook;

  @SerializedName("error")
  private boolean error;

  @SerializedName("message")
  private String message;

  public List<EbookItem> getEbook() {
    return ebook;
  }

  public void setEbook(List<EbookItem> ebook) {
    this.ebook = ebook;
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
        "EbookResponse{" +
            "ebook = '" + ebook + '\'' +
            ",error = '" + error + '\'' +
            ",message = '" + message + '\'' +
            "}";
  }
}