package com.faishalbadri.hijab.ui.event.fragment.event_city;

import com.faishalbadri.hijab.data.PojoCityEvent.EventCityBean;
import com.faishalbadri.hijab.repository.city_event.EventCityDataResource.EventCityGetCallback;
import com.faishalbadri.hijab.repository.city_event.EventCityRepository;
import com.faishalbadri.hijab.ui.event.fragment.event_city.EventCityContract.eventCityView;
import java.util.List;

/**
 * Created by faishal on 11/7/17.
 */

public class EventCityPresenter implements EventCityContract.eventCityPresenter {

  EventCityContract.eventCityView eventCityView;
  EventCityRepository eventCityRepository;

  public EventCityPresenter(
      EventCityRepository eventCityRepository) {
    this.eventCityRepository = eventCityRepository;
  }

  @Override
  public void onAttachView(eventCityView view) {
    this.eventCityView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataEventCity() {
    eventCityRepository.getEventCityResult(new EventCityGetCallback() {
      @Override
      public void onSuccesEventCity(List<EventCityBean> data, String msg) {
        eventCityView.onSuccesEventCity(data, msg);
      }

      @Override
      public void onErrorEventCity(String msg) {
        eventCityView.onErrorEventCity(msg);
      }
    });
  }
}
