package com.faishalbadri.hijab.data;

/**
 * Created by faishal on 10/31/17.
 */

public class DataOtherFragment {

  private String title;
  private int image;

  public DataOtherFragment(String title, int image) {
    this.title = title;
    this.image = image;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getImage() {
    return image;
  }

  public void setImage(int image) {
    this.image = image;
  }
}


