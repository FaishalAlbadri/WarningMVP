package com.faishalbadri.hijab.data.session;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class SessionResponse {

  @SerializedName("session")
  private List<SessionItem> session;

  @SerializedName("error")
  private boolean error;

  @SerializedName("message")
  private String message;

  public List<SessionItem> getSession() {
    return session;
  }

  public void setSession(List<SessionItem> session) {
    this.session = session;
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
        "SessionResponse{" +
            "session = '" + session + '\'' +
            ",error = '" + error + '\'' +
            ",message = '" + message + '\'' +
            "}";
  }
}