package com.faishalbadri.hijab.repository.voting_dialog;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 11/2/17.
 */

public class VotingDialogRepository implements VotingDialogDataResource {

  private VotingDialogDataResource votingDialogDataResource;

  public VotingDialogRepository(
      VotingDialogDataResource votingDialogDataResource) {
    this.votingDialogDataResource = votingDialogDataResource;
  }

  @Override
  public void getResulVotingDialogGetSession(String id_user, String id_voting,
      @NonNull VotingDialogGetSessionGetCallback votingDialogGetSessionGetCallback) {
    votingDialogDataResource
        .getResulVotingDialogGetSession(id_user, id_voting, votingDialogGetSessionGetCallback);
  }

  @Override
  public void getResulVotingDialogVotingRate(String voting_id, String user_id, String type,
      String voting_session_id,
      @NonNull VotingDialogVotingRateGetCallback votingDialogVotingRateGetCallback) {
    votingDialogDataResource.getResulVotingDialogVotingRate(voting_id, user_id, type, voting_session_id, votingDialogVotingRateGetCallback);
  }

}
