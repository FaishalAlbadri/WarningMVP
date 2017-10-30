package com.faishalbadri.hijab.ui.home.fragment;


import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


  @BindView(R.id.cardview_news_fragment_home)
  CardView cardviewNewsFragmentHome;
  @BindView(R.id.cardview_voting_fragment_home)
  CardView cardviewVotingFragmentHome;
  @BindView(R.id.cardview_video_fragment_home)
  CardView cardviewVideoFragmentHome;
  @BindView(R.id.cardview_community_fragment_home)
  CardView cardviewCommunityFragmentHome;

  public HomeFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_home, container, false);
    ButterKnife.bind(this, view);
    setCardViewSelecttableItemBackground();
    return view;
  }

  private void setCardViewSelecttableItemBackground() {
    cardviewNewsFragmentHome.setForeground(getSelectedItemDrawable());
    cardviewVotingFragmentHome.setForeground(getSelectedItemDrawable());
    cardviewVideoFragmentHome.setForeground(getSelectedItemDrawable());
    cardviewCommunityFragmentHome.setForeground(getSelectedItemDrawable());
    cardviewNewsFragmentHome.setClickable(true);
    cardviewVotingFragmentHome.setClickable(true);
    cardviewVideoFragmentHome.setClickable(true);
    cardviewCommunityFragmentHome.setClickable(true);
  }

  @OnClick(R.id.cardview_news_fragment_home)
  public void onCardviewNewsFragmentHomeClicked() {

  }

  @OnClick(R.id.cardview_voting_fragment_home)
  public void onCardviewVotingFragmentHomeClicked() {

  }

  @OnClick(R.id.cardview_video_fragment_home)
  public void onCardviewVideoFragmentHomeClicked() {

  }

  @OnClick(R.id.cardview_community_fragment_home)
  public void onCardviewCommunityFragmentHomeClicked() {

  }

  public Drawable getSelectedItemDrawable() {
    int[] attrs = new int[]{R.attr.selectableItemBackground};
    TypedArray ta = getActivity().obtainStyledAttributes(attrs);
    Drawable selectedItemDrawable = ta.getDrawable(0);
    ta.recycle();
    return selectedItemDrawable;
  }

}
