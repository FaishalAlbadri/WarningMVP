package com.faishalbadri.hijab.ui.video.fragment.category_video;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.PojoCategory.KategoriBean;
import com.faishalbadri.hijab.data.PojoEbook.EbookBean;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class CatergoryVideoContract {

  public interface categoryVideoView {

    void onSuccesCategoryVideo(List<KategoriBean> category, String msg);

    void onErrorCategoryVideo(String msg);
  }

  public interface categoryVideoPresenter extends BasePresenter<categoryVideoView> {

    void getDataCategoryVideo();
  }

}
