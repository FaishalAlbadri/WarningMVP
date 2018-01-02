package com.faishalbadri.hijab.ui.video.fragment.video;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoVideo.VideosBean;
import com.faishalbadri.hijab.di.VideoRepositoryInject;
import com.faishalbadri.hijab.ui.video.fragment.video.VideoContract.VideoView;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment implements VideoView {


  private static final String SAVE_DATA_VIDEO = "save";
  VideoPresenter videoPresenter;
  VideoAdapter videoAdapter;
  ArrayList<VideosBean> resultItem;
  View v;
  @BindView(R.id.recyclerview_fragment_video)
  RecyclerView recyclerviewFragmentVideo;
  @BindView(R.id.refresh_fragment_video)
  SwipeRefreshLayout refreshFragmentVideo;
  @BindView(R.id.layout_no_internet_acces)
  RelativeLayout layoutNoInternetAcces;

  public VideoFragment() {
    // Required empty public constructor
  }

  public static VideoFragment instance() {
    return new VideoFragment();
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    v = inflater.inflate(R.layout.fragment_video, container, false);
    ButterKnife.bind(this, v);
    setView();
    if (savedInstanceState != null) {
      ArrayList<VideosBean> resultArray = savedInstanceState
          .getParcelableArrayList(SAVE_DATA_VIDEO);
      this.resultItem.clear();
      this.resultItem.addAll(resultArray);
      videoAdapter.notifyDataSetChanged();
    } else {
      videoPresenter.getDataVideo();
    }

    refreshFragmentVideo.setOnRefreshListener(() -> {
      refreshFragmentVideo.setRefreshing(false);
      videoPresenter.getDataVideo();
    });
    return v;
  }

  private void setView() {
    videoPresenter = new VideoPresenter(
        VideoRepositoryInject.provideToCategoryVideoRepositories(getActivity()));
    videoPresenter.onAttachView(this);
    resultItem = new ArrayList<>();
    videoAdapter = new VideoAdapter(getActivity(), resultItem);
    recyclerviewFragmentVideo.setLayoutManager(new LinearLayoutManager(getActivity()));
    recyclerviewFragmentVideo.setAdapter(videoAdapter);
    refreshFragmentVideo.setColorSchemeResources(
        android.R.color.holo_blue_bright,
        android.R.color.holo_green_light,
        android.R.color.holo_orange_light,
        android.R.color.holo_red_light);
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putParcelableArrayList(SAVE_DATA_VIDEO, resultItem);
  }

  @Override
  public void onSuccesVideo(List<VideosBean> video, String msg) {
    resultItem.clear();
    resultItem.addAll(video);
    videoAdapter.notifyDataSetChanged();
    refreshFragmentVideo.setVisibility(View.VISIBLE);
    layoutNoInternetAcces.setVisibility(View.GONE);
  }

  @Override
  public void onErrorVideo(String msg) {
    refreshFragmentVideo.setVisibility(View.GONE);
    layoutNoInternetAcces.setVisibility(View.VISIBLE);
  }

  @OnClick(R.id.layout_no_internet_acces)
  public void onViewClicked() {
    videoPresenter.getDataVideo();
  }
}
