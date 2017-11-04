package com.faishalbadri.hijab.ui.video.fragment.search_video;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.faishalbadri.hijab.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


  public SearchFragment() {
    // Required empty public constructor
  }

  public static SearchFragment instance() {
    return new SearchFragment();
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_search, container, false);
  }

}
