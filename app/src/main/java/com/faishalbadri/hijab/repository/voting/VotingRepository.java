package com.faishalbadri.hijab.repository.voting;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 11/2/17.
 */

public class VotingRepository implements VotingDataResource {

  private VotingDataResource votingDataResource;

  public VotingRepository(
      VotingDataResource votingDataResource) {
    this.votingDataResource = votingDataResource;
  }

  @Override
  public void getVotingResult(@NonNull VotingGetCallback votingGetCallback) {
    votingDataResource.getVotingResult(votingGetCallback);
  }
}
