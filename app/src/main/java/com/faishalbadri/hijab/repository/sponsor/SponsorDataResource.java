package com.faishalbadri.hijab.repository.sponsor;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoSponsor.SponsorBean;
import java.util.List;

/**
 * Created by faishal on 15/11/17.
 */

public interface SponsorDataResource {

  interface SponsorGetCallback {

    void onSuccesSponsor(List<SponsorBean> data, String msg);

    void onErrorSponsor(String msg);
  }

  void getSponsorResult(@NonNull SponsorGetCallback sponsorGetCallback);

}