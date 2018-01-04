package com.faishalbadri.hijab.ui.event.fragment.event;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.PojoEvent.EventBean;
import java.util.List;

/**
 * Created by faishal on 11/7/17.
 */

public class EventContract {

  public interface eventView {

    void onSuccesEvent(List<EventBean> data, String msg);

    void onErrorEvent(String msg);


  }

  public interface eventPresenter extends BasePresenter<EventContract.eventView> {

    void getDataEvent(int PAGE);


  }
}
