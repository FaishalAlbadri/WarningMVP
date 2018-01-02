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
import com.faishalbadri.hijab.data.PojoEvent.EventBean;
import com.faishalbadri.hijab.di.EventRepositoryInject;
import com.faishalbadri.hijab.ui.event.fragment.event.EventContract.eventView;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment implements eventView {


  private static final String save_event = "saveEvent";
  @BindView(R.id.recyclerview_fragment_event)
  RecyclerView recyclerviewFragmentEvent;
  EventPresenter eventPresenter;
  ArrayList<EventBean> list_data;
  EventAdapter eventAdapter;
  @BindView(R.id.refresh_fragment_event)
  SwipeRefreshLayout refreshFragmentEvent;
  @BindView(R.id.layout_no_internet_acces)
  RelativeLayout layoutNoInternetAcces;


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

    if (savedInstanceState != null) {
      ArrayList<EventBean> data = savedInstanceState.getParcelableArrayList(save_event);
      this.list_data.clear();
      this.list_data.addAll(data);
      eventAdapter.notifyDataSetChanged();
    } else {
      eventPresenter.getDataEvent();
    }

    refreshFragmentEvent.setOnRefreshListener(() -> {
      refreshFragmentEvent.setRefreshing(false);
      eventPresenter.getDataEvent();
    });

    return v;
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putParcelableArrayList(save_event, list_data);
  }

  private void setView() {
    eventPresenter = new EventPresenter(
        EventRepositoryInject.provideToEventRepository(getActivity()));
    list_data = new ArrayList<>();
    eventAdapter = new EventAdapter(getActivity(), list_data);
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
  public void onSuccesEvent(List<EventBean> data, String msg) {
    list_data.clear();
    list_data.addAll(data);
    eventAdapter.notifyDataSetChanged();
    refreshFragmentEvent.setVisibility(View.VISIBLE);
    layoutNoInternetAcces.setVisibility(View.GONE);
  }

  @Override
  public void onErrorEvent(String msg) {
    refreshFragmentEvent.setVisibility(View.GONE);
    layoutNoInternetAcces.setVisibility(View.VISIBLE);
  }

  @OnClick(R.id.layout_no_internet_acces)
  public void onViewClicked() {
    eventPresenter.getDataEvent();
  }
}
