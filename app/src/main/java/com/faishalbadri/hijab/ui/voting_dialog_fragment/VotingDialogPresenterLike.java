package com.faishalbadri.hijab.ui.voting_dialog_fragment;

import com.faishalbadri.hijab.repository.voting_dialog.VotingDialogDataResource.VotingDialogLikeGetCallback;
import com.faishalbadri.hijab.repository.voting_dialog.VotingDialogRepository;
import com.faishalbadri.hijab.ui.voting_dialog_fragment.VotingDialogContract.VotingDialogViewLike;

/**
 * Created by faishal on 11/2/17.
 */

public class VotingDialogPresenterLike implements VotingDialogContract.VotingDialogPresenterLike {

  VotingDialogContract.VotingDialogViewLike viewLike;
  VotingDialogRepository votingDialogRepository;

  public VotingDialogPresenterLike(
      VotingDialogRepository votingDialogRepository) {
    this.votingDialogRepository = votingDialogRepository;
  }

  @Override
  public void onAttachView(VotingDialogViewLike view) {
    this.viewLike = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataVotingDialogLike(String id_voting, String id_user) {
    votingDialogRepository.getResulVotingDialogLike(id_voting, id_user,
        new VotingDialogLikeGetCallback() {
          @Override
          public void onSuccesVotingDialogLike(String msg) {
            viewLike.onSuccesVotingDialogLike(msg);
          }

          @Override
          public void onErrorVotingDialogLike(String msg) {
            viewLike.onErrorVotingDialogLike(msg);
          }
        });
  }
}
