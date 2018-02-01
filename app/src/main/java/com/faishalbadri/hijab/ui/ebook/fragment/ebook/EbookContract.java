package com.faishalbadri.hijab.ui.ebook.fragment.ebook;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.PojoEbookWithCategory;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public class EbookContract {

  public interface EbookView {

    void onSuccessEbook(List<PojoEbookWithCategory.DataBean> ebook, String msg);

    void onNullEbook(String msg);

    void onErrorEbook(String msg);

  }

  public interface EbookPresenter extends BasePresenter<EbookView> {

    void getData();

  }

}
