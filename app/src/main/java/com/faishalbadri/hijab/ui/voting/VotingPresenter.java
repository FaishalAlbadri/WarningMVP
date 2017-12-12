package com.faishalbadri.hijab.ui.voting;

import com.faishalbadri.hijab.data.PojoVoting.VotingBean;
import com.faishalbadri.hijab.repository.voting.VotingDataResource.VotingGetCallback;
import com.faishalbadri.hijab.repository.voting.VotingRepository;
import com.faishalbadri.hijab.ui.voting.VotingContract.votingView;
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
  public void onAttachView(votingView view) {
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
