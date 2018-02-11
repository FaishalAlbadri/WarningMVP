package com.faishalbadri.hijab.ui.about;

/**
 * Created by fikriimaduddin on 10/02/18.
 */

public class AboutData {

  private Integer image;
  private String text;

  public AboutData(Integer image, String text) {
    this.image = image;
    this.text = text;
  }

  public Integer getImage() {
    return image;
  }

  public void setImage(Integer image) {
    this.image = image;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
