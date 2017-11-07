package com.faishalbadri.hijab.ui.event.fragment.event_city;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.PojoCityEvent.CityEventBean;
import java.util.List;

/**
 * Created by faishal on 11/7/17.
 */

public class EventCityContract {

  public interface eventCityView {

    void onSuccesEventCity(List<CityEventBean> data, String msg);

    void onErrorEventCity(String msg);


  }

  public interface eventCityPresenter extends BasePresenter<eventCityView> {

    void getDataEventCity();


  }

}
