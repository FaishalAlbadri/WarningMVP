package com.faishalbadri.hijab.aaa_migration_server.ui.search_event;

import com.faishalbadri.hijab.aaa_migration_server.base.BasePresenter;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoEvent;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchEventContract {

  public interface SearchEventView {

    void onSuccesSearchEvent(List<PojoEvent.EventBean> data, String msg);

    void onWrongSearchEvent(String msg);

    void onErrorSearchEvent(String msg);
  }

  public interface SearchEventPresenter extends BasePresenter<SearchEventView> {

    void getDataSearchEvent(String key);
  }

}
