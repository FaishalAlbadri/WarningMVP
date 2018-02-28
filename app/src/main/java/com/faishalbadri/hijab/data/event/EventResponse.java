package com.faishalbadri.hijab.data.event;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class EventResponse {

  @SerializedName("error")
  private boolean error;

  @SerializedName("message")
  private String message;

  @SerializedName("event")
  private List<EventItem> event;

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

  public List<EventItem> getEvent() {
    return event;
  }

  public void setEvent(List<EventItem> event) {
    this.event = event;
  }

  @Override
  public String toString() {
    return
        "EventResponse{" +
            "error = '" + error + '\'' +
            ",message = '" + message + '\'' +
            ",event = '" + event + '\'' +
            "}";
  }
}