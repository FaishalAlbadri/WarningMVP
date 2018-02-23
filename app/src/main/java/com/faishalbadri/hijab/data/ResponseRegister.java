package com.faishalbadri.hijab.data;

import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ResponseRegister {

  @SerializedName("error")
  private boolean error;

  @SerializedName("message")
  private String message;

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
        "ResponseRegister{" +
            "error = '" + error + '\'' +
            ",message = '" + message + '\'' +
            "}";
  }
}