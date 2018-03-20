package com.faishalbadri.hijab.ui.voting;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.voting.VotingItem;
import java.util.List;

/**
 * Created by faishal on 11/2/17.
 */

public class VotingContract {

  public interface votingView {

    void onSuccesVoting(List<VotingItem> list, String msg);

    void onErrorVoting(String msg);
  }

  public interface votingPresenter extends BasePresenter<votingView> {

    void getDataVoting(int PAGE);
  }

}
