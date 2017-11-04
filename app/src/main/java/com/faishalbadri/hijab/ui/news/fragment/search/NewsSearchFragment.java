package com.faishalbadri.hijab.ui.news.fragment.search;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.faishalbadri.hijab.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsSearchFragment extends Fragment {


  public NewsSearchFragment() {
    // Required empty public constructor
  }

  public static NewsSearchFragment instance() {
    return new NewsSearchFragment();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_news_search, container, false);
  }
}
