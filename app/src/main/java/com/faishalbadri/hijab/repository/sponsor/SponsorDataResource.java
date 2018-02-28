package com.faishalbadri.hijab.repository.sponsor;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.sponsor.SponsorItem;
import java.util.List;

/**
 * Created by faishal on 15/11/17.
 */

public interface SponsorDataResource {

  void getSponsorResult(@NonNull SponsorGetCallback sponsorGetCallback);

  interface SponsorGetCallback {

    void onSuccesSponsor(List<SponsorItem> data, String msg);

    void onErrorSponsor(String msg);
  }

}
