package com.faishalbadri.hijab.ui.event.fragment.event;

import com.faishalbadri.hijab.data.PojoEvent.EventBean;
import com.faishalbadri.hijab.repository.event.EventDataResource.EventGetCallback;
import com.faishalbadri.hijab.repository.event.EventRepository;
import java.util.List;

/**
 * Created by faishal on 11/7/17.
 */

public class EventPresenter implements EventContract.eventPresenter {

  EventContract.eventView eventView;
  EventRepository eventRepository;

  public EventPresenter(EventRepository eventRepository) {
    this.eventRepository = eventRepository;
  }

  @Override
  public void onAttachView(EventContract.eventView view) {
    this.eventView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataEvent(int PAGE) {
    eventRepository.getEventResult(PAGE, new EventGetCallback() {
      @Override
      public void onSuccesEvent(List<EventBean> data, String msg) {
        eventView.onSuccesEvent(data, msg);
      }

      @Override
      public void onErrorEvent(String msg) {
        eventView.onErrorEvent(msg);
      }
    });
  }
}
