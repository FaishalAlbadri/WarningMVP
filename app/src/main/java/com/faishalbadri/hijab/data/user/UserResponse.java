package com.faishalbadri.hijab.data.user;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class UserResponse {

  @SerializedName("error")
  private boolean error;

  @SerializedName("message")
  private String message;

  @SerializedName("user")
  private List<UserItem> user;

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

  public List<UserItem> getUser() {
    return user;
  }

  public void setUser(List<UserItem> user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return
        "UserResponse{" +
            "error = '" + error + '\'' +
            ",message = '" + message + '\'' +
            ",user = '" + user + '\'' +
            "}";
  }
}