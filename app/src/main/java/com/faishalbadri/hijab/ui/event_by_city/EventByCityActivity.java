package com.faishalbadri.hijab.ui.event_by_city;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoEvent.EventBean;
import com.faishalbadri.hijab.di.EventByCityRepositoryInject;
import com.faishalbadri.hijab.ui.event.fragment.event.EventAdapter;
import com.faishalbadri.hijab.ui.event_by_city.EventByCityContract.EventByCityView;
import java.util.ArrayList;
import java.util.List;

public class EventByCityActivity extends AppCompatActivity implements EventByCityView {

  private static final String save_event_by_city = "saveEventByCity";
  @BindView(R.id.button_back_general_toolbar_search)
  ImageView buttonBackGeneralToolbarSearch;
  @BindView(R.id.textview_general_toolbar_search)
  TextView textviewGeneralToolbarSearch;
  @BindView(R.id.button_search_general_toolbar_search)
  ImageView buttonSearchGeneralToolbarSearch;
  @BindView(R.id.recyclerview_activity_event_by_city)
  RecyclerView recyclerviewActivityEventByCity;
  ArrayList<EventBean> list_data;
  EventByCityPresenter eventByCityPresenter;
  EventAdapter eventByCityAdapter;
  String id, city;
  @BindView(R.id.refresh_fragment_event_by_city)
  SwipeRefreshLayout refreshFragmentEventByCity;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_event_by_city);
    ButterKnife.bind(this);
    setView();
    eventByCityPresenter.onAttachView(this);

    if (savedInstanceState != null) {
      ArrayList<EventBean> data = savedInstanceState.getParcelableArrayList(save_event_by_city);
      this.list_data.clear();
      this.list_data.addAll(data);
      eventByCityAdapter.notifyDataSetChanged();
    } else {
      eventByCityPresenter.getDataEventByCity(id);
    }

    refreshFragmentEventByCity.setOnRefreshListener(() -> {
      refreshFragmentEventByCity.setRefreshing(false);
      eventByCityPresenter.getDataEventByCity(id);
    });

  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putParcelableArrayList(save_event_by_city, list_data);
  }


  private void setView() {
    buttonSearchGeneralToolbarSearch.setVisibility(View.INVISIBLE);
    id = getIntent().getStringExtra("id");
    city = getIntent().getStringExtra("city");
    textviewGeneralToolbarSearch.setText(city);
    eventByCityPresenter = new EventByCityPresenter(
        EventByCityRepositoryInject.provideToEventByCityRepository(this));
    list_data = new ArrayList<>();
    eventByCityAdapter = new EventAdapter(this, list_data);
    recyclerviewActivityEventByCity.setLayoutManager(new LinearLayoutManager(this));
    recyclerviewActivityEventByCity.setAdapter(eventByCityAdapter);
    refreshFragmentEventByCity.setColorSchemeResources(
        android.R.color.holo_blue_bright,
        android.R.color.holo_green_light,
        android.R.color.holo_orange_light,
        android.R.color.holo_red_light);
  }

  @Override
  public void onSuccesEventByCity(List<EventBean> data, String msg) {
    list_data.clear();
    list_data.addAll(data);
    eventByCityAdapter.notifyDataSetChanged();
  }

  @Override
  public void onErrorEventByCity(String msg) {

  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    finish();
  }

  @OnClick(R.id.button_back_general_toolbar_search)
  public void onButtonBackGeneralToolbarSearchClicked() {
    onBackPressed();
  }
}
