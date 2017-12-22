package com.faishalbadri.hijab.repository.sponsor;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoSponsor;
import java.util.List;

/**
 * Created by faishal on 15/11/17.
 */

public interface SponsorDataResource {

  void getSponsorResult(@NonNull SponsorGetCallback sponsorGetCallback);

  interface SponsorGetCallback {

    void onSuccesSponsor(List<PojoSponsor.SponsorBean> data, String msg);

    void onErrorSponsor(String msg);
  }

}
