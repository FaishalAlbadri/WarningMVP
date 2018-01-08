package com.faishalbadri.hijab.ui.event.fragment.event_city;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.faishalbadri.hijab.data.PojoCityEvent.EventCityBean;
import com.faishalbadri.hijab.di.CityEventRepositoryInject;
import com.faishalbadri.hijab.ui.event.fragment.event_city.EventCityContract.eventCityView;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventCityFragment extends Fragment implements eventCityView {


  private static final String save_city_event = "saveCityEvent";
  @BindView(R.id.recyclerview_fragment_event_city)
  RecyclerView recyclerviewFragmentEventCity;
  EventCityPresenter eventCityPresenter;
  ArrayList<EventCityBean> list_data;
  EventCityAdapter eventCityAdapter;
  @BindView(R.id.layout_no_internet_acces)
  RelativeLayout layoutNoInternetAcces;

  public EventCityFragment() {
    // Required empty public constructor
  }

  public static EventCityFragment instance() {
    return new EventCityFragment();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_event_city, container, false);
    ButterKnife.bind(this, v);
    setView();
    eventCityPresenter.onAttachView(this);
    eventCityAdapter.notifyDataSetChanged();
    eventCityPresenter.getDataEventCity();
    return v;
  }

  private void setView() {
    eventCityPresenter = new EventCityPresenter(
        CityEventRepositoryInject.provideToEventCityRepository(getActivity()));
    list_data = new ArrayList<>();
    eventCityAdapter = new EventCityAdapter(getActivity(), list_data);
    LinearLayoutManager llm = new LinearLayoutManager(getActivity());
    llm.setOrientation(LinearLayoutManager.VERTICAL);
    recyclerviewFragmentEventCity.setLayoutManager(llm);
    recyclerviewFragmentEventCity.setAdapter(eventCityAdapter);
  }

//  @Override
//  public void onSaveInstanceState(Bundle outState) {
//    super.onSaveInstanceState(outState);
//    outState.putParcelableArrayList(save_city_event, list_data);
//  }

  @Override
  public void onSuccesEventCity(List<EventCityBean> data, String msg) {
    list_data.clear();
    list_data.addAll(data);
    eventCityAdapter.notifyDataSetChanged();
    recyclerviewFragmentEventCity.setVisibility(View.VISIBLE);
    layoutNoInternetAcces.setVisibility(View.GONE);
  }

  @Override
  public void onErrorEventCity(String msg) {
    recyclerviewFragmentEventCity.setVisibility(View.GONE);
    layoutNoInternetAcces.setVisibility(View.VISIBLE);
  }

  @OnClick(R.id.layout_no_internet_acces)
  public void onViewClicked() {
    eventCityPresenter.getDataEventCity();
  }
}
