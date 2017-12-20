package com.faishalbadri.hijab.revamp.ui.event.fragment.event_city;

import com.faishalbadri.hijab.revamp.data.PojoCityEvent;
import com.faishalbadri.hijab.revamp.base.BasePresenter;
import java.util.List;

/**
 * Created by faishal on 11/7/17.
 */

public class EventCityContract {

  public interface eventCityView {

    void onSuccesEventCity(List<PojoCityEvent.EventCityBean> data, String msg);

    void onErrorEventCity(String msg);


  }

  public interface eventCityPresenter extends BasePresenter<eventCityView> {

    void getDataEventCity();


  }

}
