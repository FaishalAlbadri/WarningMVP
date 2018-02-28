package com.faishalbadri.hijab.ui.event.fragment.event;


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
import com.faishalbadri.hijab.data.event.EventItem;
import com.faishalbadri.hijab.di.EventRepositoryInject;
import com.faishalbadri.hijab.ui.event.fragment.event.EventContract.eventView;
import com.faishalbadri.hijab.util.Singleton.DataServerProgress;
import com.faishalbadri.hijab.util.Singleton.LoadingStatus;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment implements eventView {


  @BindView(R.id.recyclerview_fragment_event)
  RecyclerView recyclerviewFragmentEvent;
  EventPresenter eventPresenter;
  ArrayList<EventItem> list_data;
  EventAdapter eventAdapter;
  @BindView(R.id.refresh_fragment_event)
  SwipeRefreshLayout refreshFragmentEvent;
  @BindView(R.id.layout_no_internet_acces)
  RelativeLayout layoutNoInternetAcces;
  @BindView(R.id.layout_loading)
  RelativeLayout layoutLoading;
  private int PAGE = 1;

  public EventFragment() {
    // Required empty public constructor
  }

  public static EventFragment instance() {
    return new EventFragment();
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_event, container, false);
    ButterKnife.bind(this, v);
    setView();
    eventPresenter.onAttachView(this);
    eventPresenter.getDataEvent(1);
    refreshFragmentEvent.setOnRefreshListener(() -> {
      PAGE = 1;
      this.list_data.clear();
      refreshFragmentEvent.setRefreshing(false);
      eventPresenter.getDataEvent(1);
    });

    return v;
  }

  private void setView() {
    eventPresenter = new EventPresenter(
        EventRepositoryInject.provideToEventRepository(getActivity()));
    list_data = new ArrayList<>();
    eventAdapter = new EventAdapter(getActivity(), list_data, EventFragment.this);
    LinearLayoutManager llm = new LinearLayoutManager(getActivity());
    llm.setOrientation(LinearLayoutManager.VERTICAL);
    recyclerviewFragmentEvent.setLayoutManager(llm);
    recyclerviewFragmentEvent.setAdapter(eventAdapter);
    refreshFragmentEvent.setColorSchemeResources(
        android.R.color.holo_blue_bright,
        android.R.color.holo_green_light,
        android.R.color.holo_orange_light,
        android.R.color.holo_red_light);
  }

  @Override
  public void onSuccesEvent(List<EventItem> data, String msg) {
    PAGE++;
    list_data.addAll(data);
    LoadingStatus.getInstance().setStatus(null);
    eventAdapter.notifyDataSetChanged();
    DataServerProgress.getInstance().onSuccesData(refreshFragmentEvent, layoutLoading);
  }

  @Override
  public void onErrorEvent(String msg) {
    if (msg.equals("Data Null")) {
      LoadingStatus.getInstance().setStatus("error");
      eventAdapter.notifyDataSetChanged();
    } else if (msg.equals("Data Pagination Error")) {
      eventAdapter.onErrorPagination();
    } else {
      whenError();
    }
  }

  public void getData() {
    eventPresenter.getDataEvent(PAGE);
  }

  @OnClick(R.id.layout_no_internet_acces)
  public void onViewClicked() {
    layoutLoading.setVisibility(View.VISIBLE);
    layoutNoInternetAcces.setVisibility(View.GONE);
    whenError();
  }

  private void whenError() {
    DataServerProgress.getInstance().onErrorData(layoutNoInternetAcces, layoutLoading);
    if (DataServerProgress.getInstance().getStatus().equals("error")) {
      eventPresenter.getDataEvent(PAGE);
    }
  }

}
