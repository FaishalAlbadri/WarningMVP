package com.faishalbadri.hijab.revamp.ui.event_by_city;

import com.faishalbadri.hijab.revamp.base.BasePresenter;
import com.faishalbadri.hijab.revamp.data.PojoEvent.EventBean;
import java.util.List;

/**
 * Created by faishal on 11/11/17.
 */

public class EventByCityContract {

  public interface EventByCityView {

    void onSuccesEventByCity(List<EventBean> data, String msg);

    void onErrorEventByCity(String msg);
  }

  public interface EventByCityPresenter extends BasePresenter<EventByCityView> {

    void getDataEventByCity(String id_city_event);
  }

}
