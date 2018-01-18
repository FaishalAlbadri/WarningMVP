package com.faishalbadri.hijab.repository.sponsor;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 15/11/17.
 */

public class SponsorRepository implements SponsorDataResource {

  private SponsorDataResource sponsorDataResource;

  public SponsorRepository(
      SponsorDataResource sponsorDataResource) {
    this.sponsorDataResource = sponsorDataResource;
  }

  @Override
  public void getSponsorResult(@NonNull SponsorGetCallback sponsorGetCallback) {
    sponsorDataResource.getSponsorResult(sponsorGetCallback);
  }
}
