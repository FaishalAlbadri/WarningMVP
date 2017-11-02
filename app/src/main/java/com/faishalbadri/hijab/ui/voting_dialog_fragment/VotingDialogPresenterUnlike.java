package com.faishalbadri.hijab.ui.voting_dialog_fragment;

import com.faishalbadri.hijab.repository.voting_dialog.VotingDialogDataResource.VotingDialogUnlikeGetCallback;
import com.faishalbadri.hijab.repository.voting_dialog.VotingDialogRepository;
import com.faishalbadri.hijab.ui.voting_dialog_fragment.VotingDialogContract.VotingDialogViewUnlike;

/**
 * Created by faishal on 11/2/17.
 */

public class VotingDialogPresenterUnlike implements VotingDialogContract.VotingDialogPresenterUnlike {

  VotingDialogContract.VotingDialogViewUnlike viewUnlike;
  VotingDialogRepository votingDialogRepository;

  public VotingDialogPresenterUnlike(
      VotingDialogRepository votingDialogRepository) {
    this.votingDialogRepository = votingDialogRepository;
  }

  @Override
  public void onAttachView(VotingDialogViewUnlike view) {
    this.viewUnlike = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataVotingDialogUnlike(String id_voting, String id_session) {
    votingDialogRepository.getResulVotingDialogUnlike(id_voting, id_session,
        new VotingDialogUnlikeGetCallback() {
          @Override
          public void onSuccesVotingDialogUnlike(String msg) {
            viewUnlike.onSuccesVotingDialogUnlike(msg);
          }

          @Override
          public void onErrorVotingDialogUnlike(String msg) {
            viewUnlike.onErrorVotingDialogUnlike(msg);
          }
        });
  }
}
