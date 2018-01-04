package com.faishalbadri.hijab.util.Singleton;

/**
 * Created by fikriimaduddin on 04/01/18.
 */

public class LoadingStatus {

  private static LoadingStatus mInstance = null;
  private String status;

  public LoadingStatus() {
    status = null;
  }

  public static LoadingStatus getInstance() {
    if (mInstance == null) {
      mInstance = new LoadingStatus();
    }
    return mInstance;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
