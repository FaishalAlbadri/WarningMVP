package com.faishalbadri.hijab.ui.voting_dialog_fragment;

import com.faishalbadri.hijab.revamp.base.BasePresenter;

/**
 * Created by faishal on 11/2/17.
 */

public class VotingDialogContract {

  public interface VotingDialogViewGetSession {

    void onSuccesVotingDialogGetSession(String msg, String id_session, String status_session);

    void onSuccesVotingDialogGetSessionNull(String msg);

    void onErrorVotingDialogGetSession(String msg);
  }

  public interface VotingDialogPresenterGetSession extends
      BasePresenter<VotingDialogContract.VotingDialogViewGetSession> {

    void getDataVotingDialogGetSession(String id_user, String id_voting);
  }

  public interface VotingDialogViewLike {

    void onSuccesVotingDialogLike(String msg);

    void onErrorVotingDialogLike(String msg);
  }

  public interface VotingDialogPresenterLike extends
      BasePresenter<VotingDialogContract.VotingDialogViewLike> {

    void getDataVotingDialogLike(String id_voting, String id_user);
  }

  public interface VotingDialogViewUnlike {

    void onSuccesVotingDialogUnlike(String msg);

    void onErrorVotingDialogUnlike(String msg);
  }

  public interface VotingDialogPresenterUnlike extends
      BasePresenter<VotingDialogContract.VotingDialogViewUnlike> {

    void getDataVotingDialogUnlike(String id_voting, String id_session);
  }

}
