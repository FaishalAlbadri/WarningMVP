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
  public void getResulVotingDialogLike(String id_voting, String id_user,
      @NonNull VotingDialogLikeGetCallback votingDialogLikeGetCallback) {
    votingDialogDataResource
        .getResulVotingDialogLike(id_voting, id_user, votingDialogLikeGetCallback);
  }

  @Override
  public void getResulVotingDialogUnlike(String id_voting, String id_session,
      @NonNull VotingDialogUnlikeGetCallback votingDialogUnlikeGetCallback) {
    votingDialogDataResource
        .getResulVotingDialogUnlike(id_voting, id_session, votingDialogUnlikeGetCallback);
  }
}
