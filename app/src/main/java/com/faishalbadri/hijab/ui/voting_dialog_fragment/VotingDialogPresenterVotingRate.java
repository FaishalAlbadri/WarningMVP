package com.faishalbadri.hijab.ui.voting_dialog_fragment;

import com.faishalbadri.hijab.repository.voting_dialog.VotingDialogDataResource.VotingDialogVotingRateGetCallback;
import com.faishalbadri.hijab.repository.voting_dialog.VotingDialogRepository;
import com.faishalbadri.hijab.ui.voting_dialog_fragment.VotingDialogContract.VotingDialogViewVotingRate;

/**
 * Created by faishal on 21/12/17.
 */

public class VotingDialogPresenterVotingRate implements
    VotingDialogContract.VotingDialogPresenterVotingRate {

  VotingDialogContract.VotingDialogViewVotingRate viewVotingRate;
  VotingDialogRepository votingDialogRepository;

  public VotingDialogPresenterVotingRate(VotingDialogRepository votingDialogRepository) {
    this.votingDialogRepository = votingDialogRepository;
  }

  @Override
  public void onAttachView(VotingDialogViewVotingRate view) {
    this.viewVotingRate = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataVotingDialogViewVotingRate(String voting_id, String type,
      String voting_session_id) {
    votingDialogRepository.getResulVotingDialogVotingRate(voting_id, type,
        voting_session_id, new VotingDialogVotingRateGetCallback() {
          @Override
          public void onSuccesVotingDialogVotingRate(String msg) {
            viewVotingRate.onSuccesVotingDialogViewVotingRate(msg);
          }

          @Override
          public void onErrorVotingDialogVotingRate(String msg) {
            viewVotingRate.onErrorVotingDialogViewVotingRate(msg);
          }
        });
  }
}
