package com.faishalbadri.hijab.ui.sponsor;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.PojoSponsor;
import java.util.List;

/**
 * Created by faishal on 15/11/17.
 */

public class SponsorContract {

  public interface SponsorView {

    void onSuccesSponsor(List<PojoSponsor.SponsorBean> data, String msg);

    void onErrorSponsor(String msg);


  }

  public interface SponsorPresenter extends BasePresenter<SponsorView> {

    void getDataSponsor();

  }

}