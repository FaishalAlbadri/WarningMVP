package com.faishalbadri.hijab.ui.event_by_city;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoEvent.EventBean;
import com.faishalbadri.hijab.di.EventByCityRepositoryInject;
import com.faishalbadri.hijab.ui.event_by_city.EventByCityContract.EventByCityView;
import com.faishalbadri.hijab.util.Singleton.DataServerProgress;
import com.faishalbadri.hijab.util.UserUtil;
import java.util.ArrayList;
import java.util.List;

public class EventByCityActivity extends AppCompatActivity implements EventByCityView {

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
  EventByCityAdapter eventByCityAdapter;
  String id, city;
  @BindView(R.id.refresh_fragment_event_by_city)
  SwipeRefreshLayout refreshFragmentEventByCity;
  @BindView(R.id.layout_no_internet_acces)
  RelativeLayout layoutNoInternetAcces;
  @BindView(R.id.layout_loading)
  RelativeLayout layoutLoading;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_event_by_city);
    ButterKnife.bind(this);
    UserUtil.getInstance(getApplicationContext()).setDataUser();
    setView();
    eventByCityPresenter.onAttachView(this);
    eventByCityPresenter.getDataEventByCity(id);

    refreshFragmentEventByCity.setOnRefreshListener(() -> {
      refreshFragmentEventByCity.setRefreshing(false);
      eventByCityPresenter.getDataEventByCity(id);
    });

  }

  private void setView() {
    buttonSearchGeneralToolbarSearch.setVisibility(View.INVISIBLE);
    id = getIntent().getStringExtra("id");
    city = getIntent().getStringExtra("city");
    textviewGeneralToolbarSearch.setText(city);
    eventByCityPresenter = new EventByCityPresenter(
        EventByCityRepositoryInject.provideToEventByCityRepository(this));
    list_data = new ArrayList<>();
    eventByCityAdapter = new EventByCityAdapter(this, list_data);
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
    layoutNoInternetAcces.setVisibility(View.GONE);
    refreshFragmentEventByCity.setVisibility(View.VISIBLE);
    DataServerProgress.getInstance().onSuccesData(recyclerviewActivityEventByCity, layoutLoading);
  }

  @Override
  public void onErrorEventByCity(String msg) {
    layoutNoInternetAcces.setVisibility(View.VISIBLE);
    refreshFragmentEventByCity.setVisibility(View.GONE);
    layoutLoading.setVisibility(View.GONE);
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

  @OnClick(R.id.layout_no_internet_acces)
  public void onViewClicked() {
    eventByCityPresenter.getDataEventByCity(id);
  }
}
