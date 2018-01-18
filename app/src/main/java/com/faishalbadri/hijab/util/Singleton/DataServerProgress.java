package com.faishalbadri.hijab.util.Singleton;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

/**
 * Created by faishal on 19/01/18.
 */

public class DataServerProgress {

  private static DataServerProgress mInstance = null;
  private String status;
  private int count;

  public DataServerProgress() {
    status = "";
    count = 0;
  }

  public static DataServerProgress getInstance() {
    if (mInstance == null) {
      mInstance = new DataServerProgress();
    }
    return mInstance;
  }

  public String getStatus() {
    return status;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public void onErrorData(RelativeLayout layoutNoInternetAcces, RelativeLayout layoutLoading) {
    count++;
    if (count < 5) {
      status = "error";
    } else {
      count = 0;
      layoutLoading.setVisibility(View.GONE);
      layoutNoInternetAcces.setVisibility(View.VISIBLE);
      status = "";
    }
  }

  public void onSuccesData(ScrollView scrollView, RelativeLayout
      loading) {
    count = 0;
    loading.setVisibility(View.GONE);
    scrollView.setVisibility(View.VISIBLE);
  }

}
