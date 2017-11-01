package com.faishalbadri.hijab.ui.home.fragment.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.DataHomeFragment;
import com.faishalbadri.hijab.util.SessionManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


  @BindView(R.id.recyclerview_fragment_home)
  RecyclerView recyclerviewFragmentHome;
  HomeFragmentAdapter homeFragmentAdapter;
  List<DataHomeFragment> data_list;
  String event, ebook, news, voting, video, community;
  String eventDetail, ebookDetail, newsDetail, votingDetail, videoDetail, communityDetail;
  int[] image;


  public HomeFragment() {
    // Required empty public constructor
  }

  public static HomeFragment instance() {
    return new HomeFragment();
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_home, container, false);
    ButterKnife.bind(this, view);
    setView();
    setString();
    dataHomeFragment();
    return view;
  }

  private void setString() {
    image = new int[]{
        R.mipmap.ic_launcher,
        R.mipmap.ic_launcher,
        R.mipmap.ic_launcher,
        R.mipmap.ic_launcher,
        R.mipmap.ic_launcher,
        R.mipmap.ic_launcher
    };
    event = getActivity().getResources().getString(R.string.text_pinky_hijab_event);
    ebook = getActivity().getResources().getString(R.string.text_pinky_hijab_ebook);
    news = getActivity().getResources().getString(R.string.text_pinky_hijab_news);
    voting = getActivity().getResources().getString(R.string.text_pinky_hijab_voting);
    video = getActivity().getResources().getString(R.string.text_pinky_hijab_video);
    community = getActivity().getResources().getString(R.string.text_pinky_hijab_community);

    eventDetail = getActivity().getResources().getString(R.string.text_pinky_hijab_event_detail);
    ebookDetail = getActivity().getResources().getString(R.string.text_pinky_hijab_ebook_detail);
    newsDetail = getActivity().getResources().getString(R.string.text_pinky_hijab_news_detail);
    votingDetail = getActivity().getResources().getString(R.string.text_pinky_hijab_voting_detail);
    videoDetail = getActivity().getResources().getString(R.string.text_pinky_hijab_video_detail);
    communityDetail = getActivity().getResources()
        .getString(R.string.text_pinky_hijab_community_detail);
  }


  private void setView() {
    data_list = new ArrayList<>();
    homeFragmentAdapter = new HomeFragmentAdapter(getActivity(), data_list);
    LinearLayoutManager llmHomeFragment = new LinearLayoutManager(getActivity());
    llmHomeFragment.setOrientation(LinearLayoutManager.VERTICAL);
    recyclerviewFragmentHome.setLayoutManager(llmHomeFragment);
    recyclerviewFragmentHome.setAdapter(homeFragmentAdapter);
  }

  private void dataHomeFragment() {
    data_list.add(new DataHomeFragment(news, newsDetail, image[0]));
    data_list.add(new DataHomeFragment(video, videoDetail, image[1]));
    data_list.add(new DataHomeFragment(voting, votingDetail, image[2]));
    data_list.add(new DataHomeFragment(event, eventDetail, image[3]));
    data_list.add(new DataHomeFragment(ebook, ebookDetail, image[4]));
    data_list.add(new DataHomeFragment(community, communityDetail, image[5]));
    homeFragmentAdapter.notifyDataSetChanged();
  }

}
