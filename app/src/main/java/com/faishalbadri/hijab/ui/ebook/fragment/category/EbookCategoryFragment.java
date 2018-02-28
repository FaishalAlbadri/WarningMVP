package com.faishalbadri.hijab.ui.ebook.fragment.category;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EbookCategoryFragment extends Fragment {

  View view;

  public EbookCategoryFragment() {
    // Required empty public constructor
  }

  public static EbookCategoryFragment instance() {
    return new EbookCategoryFragment();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    view = inflater.inflate(R.layout.fragment_ebook_category, container, false);
    ButterKnife.bind(this, view);
    return view;
  }
}
