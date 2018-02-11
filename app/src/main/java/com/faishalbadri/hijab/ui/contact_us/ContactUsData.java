package com.faishalbadri.hijab.ui.contact_us;

/**
 * Created by fikriimaduddin on 11/02/18.
 */

public class ContactUsData {

  private String caption;
  private int image;

  public ContactUsData(String caption, int image) {
    this.caption = caption;
    this.image = image;
  }

  public String getCaption() {
    return caption;
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }

  public int getImage() {
    return image;
  }

  public void setImage(int image) {
    this.image = image;
  }
}
