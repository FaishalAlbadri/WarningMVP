package com.faishalbadri.hijab.ui.ebook;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.PojoEbook;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public class EbookContract {

  public interface EbookView {

    void onSuccessEbook(List<PojoEbook.EbookBean> ebook, String msg);

    void onNullEbook(String msg);

    void onErrorEbook(String msg);

  }

  public interface EbookPresenter extends BasePresenter<EbookView> {

    void getData();

  }

}
