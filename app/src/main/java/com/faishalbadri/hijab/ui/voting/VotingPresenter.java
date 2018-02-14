package com.faishalbadri.hijab.ui.voting;

import com.faishalbadri.hijab.data.PojoVoting.VotingBean;
import com.faishalbadri.hijab.repository.voting.VotingDataResource.VotingGetCallback;
import com.faishalbadri.hijab.repository.voting.VotingRepository;
import java.util.List;

/**
 * Created by faishal on 11/2/17.
 */

public class VotingPresenter implements VotingContract.votingPresenter {

  private VotingContract.votingView votingView;
  private VotingRepository votingRepository;

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
  public void getDataVoting(int PAGE) {
    votingRepository.getVotingResult(PAGE, new VotingGetCallback() {
      @Override
      public void onSuccesVoting(List<VotingBean> list, String msg) {
        votingView.onSuccesVoting(list, msg);
      }

      @Override
      public void onErrorVoting(String msg) {
        votingView.onErrorVoting(msg);
      }
    });
  }
}
