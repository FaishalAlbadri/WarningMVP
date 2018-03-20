package com.faishalbadri.hijab.ui.search_event;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.event.EventItem;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchEventContract {

  public interface SearchEventView {

    void onSuccesSearchEvent(List<EventItem> data, String msg);

    void onWrongSearchEvent(String msg);

    void onErrorSearchEvent(String msg);
  }

  public interface SearchEventPresenter extends BasePresenter<SearchEventView> {

    void getDataSearchEvent(String key);
  }

}
