package com.faishalbadri.hijab.ui.event_by_city;

import com.faishalbadri.hijab.data.event.EventItem;
import com.faishalbadri.hijab.repository.event_by_city.EventByCityDataResource.EventByCityGetCallback;
import com.faishalbadri.hijab.repository.event_by_city.EventByCityRepository;
import com.faishalbadri.hijab.ui.event_by_city.EventByCityContract.EventByCityView;
import java.util.List;

/**
 * Created by faishal on 11/11/17.
 */

public class EventByCityPresenter implements EventByCityContract.EventByCityPresenter {

  EventByCityContract.EventByCityView eventByCityView;
  EventByCityRepository eventByCityRepository;

  public EventByCityPresenter(
      EventByCityRepository eventByCityRepository) {
    this.eventByCityRepository = eventByCityRepository;
  }

  @Override
  public void onAttachView(EventByCityView view) {
    this.eventByCityView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataEventByCity(String id_city_event) {
    eventByCityRepository.getEventByCityResult(id_city_event, new EventByCityGetCallback() {
      @Override
      public void onSuccesEventByCity(List<EventItem> data, String msg) {
        eventByCityView.onSuccesEventByCity(data, msg);
      }

      @Override
      public void onErrorEventByCity(String msg) {
        eventByCityView.onErrorEventByCity(msg);
      }
    });
  }
}
