package com.faishalbadri.hijab.data.city;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class CityResponse {

  @SerializedName("event_city")
  private List<CityItem> eventCity;

  @SerializedName("error")
  private boolean error;

  @SerializedName("message")
  private String message;

  public List<CityItem> getEventCity() {
    return eventCity;
  }

  public void setEventCity(List<CityItem> eventCity) {
    this.eventCity = eventCity;
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
        "CityResponse{" +
            "event_city = '" + eventCity + '\'' +
            ",error = '" + error + '\'' +
            ",message = '" + message + '\'' +
            "}";
  }
}