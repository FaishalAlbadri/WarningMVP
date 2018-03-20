package com.faishalbadri.hijab.ui.event_by_city;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.event.EventItem;
import java.util.List;

/**
 * Created by faishal on 11/11/17.
 */

public class EventByCityContract {

  public interface EventByCityView {

    void onSuccesEventByCity(List<EventItem> data, String msg);

    void onErrorEventByCity(String msg);
  }

  public interface EventByCityPresenter extends BasePresenter<EventByCityView> {

    void getDataEventByCity(String id_city_event);
  }

}
