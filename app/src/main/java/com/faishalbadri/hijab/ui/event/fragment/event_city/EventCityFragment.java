package com.faishalbadri.hijab.ui.event.fragment.event_city;


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
import com.faishalbadri.hijab.data.PojoCityEvent;
import com.faishalbadri.hijab.data.PojoCityEvent.CityEventBean;
import com.faishalbadri.hijab.data.PojoNews.IsiBean;
import com.faishalbadri.hijab.di.CityEventRepositoryInject;
import com.faishalbadri.hijab.di.EventByCityRepositoryInject;
import com.faishalbadri.hijab.di.NewsRepositoryInject;
import com.faishalbadri.hijab.ui.event.fragment.event_city.EventCityContract.eventCityView;
import com.faishalbadri.hijab.ui.news.fragment.news.NewsAdapter;
import com.faishalbadri.hijab.ui.news.fragment.news.NewsPresenter;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventCityFragment extends Fragment implements eventCityView {


  @BindView(R.id.recyclerview_fragment_event_city)
  RecyclerView recyclerviewFragmentEventCity;
  EventCityPresenter eventCityPresenter;
  ArrayList<PojoCityEvent.CityEventBean> list_data;
  EventCityAdapter eventCityAdapter;
  private static final String save_city_event = "saveCityEvent";

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

    if (savedInstanceState != null) {
      ArrayList<PojoCityEvent.CityEventBean> data = savedInstanceState
          .getParcelableArrayList(save_city_event);
      this.list_data.clear();
      this.list_data.addAll(data);
      eventCityAdapter.notifyDataSetChanged();
    } else {
      eventCityPresenter.getDataEventCity();
    }
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

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putParcelableArrayList(save_city_event, list_data);
  }

  @Override
  public void onSuccesEventCity(List<CityEventBean> data, String msg) {
    list_data.clear();
    list_data.addAll(data);
    eventCityAdapter.notifyDataSetChanged();
  }

  @Override
  public void onErrorEventCity(String msg) {

  }
}
