package com.faishalbadri.hijab.ui.sponsor;

import com.faishalbadri.hijab.data.sponsor.SponsorItem;
import com.faishalbadri.hijab.repository.sponsor.SponsorDataResource.SponsorGetCallback;
import com.faishalbadri.hijab.repository.sponsor.SponsorRepository;
import com.faishalbadri.hijab.ui.sponsor.SponsorContract.SponsorView;
import java.util.List;

/**
 * Created by faishal on 15/11/17.
 */

public class SponsorPresenter implements SponsorContract.SponsorPresenter {

  private SponsorContract.SponsorView sponsorView;
  private SponsorRepository sponsorRepository;

  public SponsorPresenter(
      SponsorRepository sponsorRepository) {
    this.sponsorRepository = sponsorRepository;
  }

  @Override
  public void onAttachView(SponsorView view) {
    this.sponsorView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataSponsor() {
    sponsorRepository.getSponsorResult(new SponsorGetCallback() {
      @Override
      public void onSuccesSponsor(List<SponsorItem> data, String msg) {
        sponsorView.onSuccesSponsor(data, msg);
      }

      @Override
      public void onErrorSponsor(String msg) {
        sponsorView.onErrorSponsor(msg);
      }
    });
  }
}
