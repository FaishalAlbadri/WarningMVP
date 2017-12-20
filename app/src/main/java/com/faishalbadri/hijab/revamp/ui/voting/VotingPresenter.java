package com.faishalbadri.hijab.revamp.ui.voting;

import com.faishalbadri.hijab.revamp.data.PojoVoting.VotingBean;
import com.faishalbadri.hijab.revamp.repository.voting.VotingDataResource.VotingGetCallback;
import com.faishalbadri.hijab.revamp.repository.voting.VotingRepository;
import java.util.List;

/**
 * Created by faishal on 11/2/17.
 */

public class VotingPresenter implements VotingContract.votingPresenter {

  VotingContract.votingView votingView;
  VotingRepository votingRepository;

  public VotingPresenter(VotingRepository votingRepository) {
    this.votingRepository = votingRepository;
  }

  @Override
  public void onAttachView(VotingContract.votingView view) {
    this.votingView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataVoting() {
    votingRepository.getVotingResult(new VotingGetCallback() {
      @Override
      public void onSuccesVoting(List<VotingBean> list, String msg) {
        votingView.onSuccesVoting(list, msg);
      }

      @Override
      public void onDataVotingNull(String msg) {
        votingView.onDataVotingNull(msg);
      }

      @Override
      public void onErrorVoting(String msg) {
        votingView.onErrorVoting(msg);
      }
    });
  }
}
