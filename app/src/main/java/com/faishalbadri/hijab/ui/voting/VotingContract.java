package com.faishalbadri.hijab.ui.voting;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.PojoVoting.VotingBean;
import java.util.List;

/**
 * Created by faishal on 11/2/17.
 */

public class VotingContract {

  public interface votingView {

    void onSuccesVoting(List<VotingBean> list, String msg);

    void onDataVotingNull(String msg);

    void onErrorVoting(String msg);
  }

  public interface votingPresenter extends BasePresenter<votingView> {

    void getDataVoting();
  }

}