package com.faishalbadri.hijab.ui.video.fragment.category_video;

import com.faishalbadri.hijab.revamp.data.PojoCategory;
import com.faishalbadri.hijab.revamp.base.BasePresenter;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class CatergoryVideoContract {

  public interface categoryVideoView {

    void onSuccesCategoryVideo(List<PojoCategory.CategoriesBean> category, String msg);

    void onErrorCategoryVideo(String msg);
  }

  public interface categoryVideoPresenter extends BasePresenter<categoryVideoView> {

    void getDataCategoryVideo();
  }

}
