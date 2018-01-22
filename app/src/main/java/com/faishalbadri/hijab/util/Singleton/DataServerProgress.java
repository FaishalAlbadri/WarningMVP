package com.faishalbadri.hijab.util.Singleton;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
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

  public void onErrorData(RelativeLayout noInternet, RelativeLayout loading) {
    count++;
    if (count < 5) {
      status = "error";
    } else {
      count = 0;
      loading.setVisibility(View.GONE);
      noInternet.setVisibility(View.VISIBLE);
      status = "";
    }
  }

  public void onSuccesData(ScrollView scrollView, RelativeLayout loading) {
    count = 0;
    loading.setVisibility(View.GONE);
    scrollView.setVisibility(View.VISIBLE);
  }

  public void onSuccesData(RecyclerView recyclerView, RelativeLayout loading) {
    count = 0;
    loading.setVisibility(View.GONE);
    recyclerView.setVisibility(View.VISIBLE);
  }

  public void onSuccesData(SwipeRefreshLayout swipeRefreshLayout, RelativeLayout loading) {
    count = 0;
    loading.setVisibility(View.GONE);
    swipeRefreshLayout.setVisibility(View.VISIBLE);
  }

}
