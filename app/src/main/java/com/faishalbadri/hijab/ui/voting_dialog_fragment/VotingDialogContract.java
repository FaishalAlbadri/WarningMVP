package com.faishalbadri.hijab.ui.voting_dialog_fragment;

import com.faishalbadri.hijab.base.BasePresenter;

/**
 * Created by faishal on 11/2/17.
 */

public class VotingDialogContract {

  public interface VotingDialogViewGetSession {

    void onSuccesVotingDialogGetSession(String msg, String id_session, String status_session);

    void onSuccesVotingDialogGetSessionNull(String msg);

    void onErrorVotingDialogGetSession(String msg);
  }

  public interface VotingDialogPresenterGetSession extends BasePresenter<VotingDialogContract.VotingDialogViewGetSession> {

    void getDataVotingDialogGetSession(String id_voting);
  }


  public interface VotingDialogViewVotingRate {

    void onSuccesVotingDialogViewVotingRate(String msg);

    void onErrorVotingDialogViewVotingRate(String msg);
  }

  public interface VotingDialogPresenterVotingRate extends BasePresenter<VotingDialogContract
      .VotingDialogViewVotingRate> {

    void getDataVotingDialogViewVotingRate(String voting_id, String type, String voting_session_id);
  }

}
