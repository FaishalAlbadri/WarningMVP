package com.faishalbadri.hijab.aaa_migration_server.ui.voting_dialog_fragment;

import com.faishalbadri.hijab.aaa_migration_server.repository.voting_dialog.VotingDialogDataResource.VotingDialogGetSessionGetCallback;
import com.faishalbadri.hijab.aaa_migration_server.repository.voting_dialog.VotingDialogRepository;
import com.faishalbadri.hijab.aaa_migration_server.ui.voting_dialog_fragment.VotingDialogContract.VotingDialogViewGetSession;

/**
 * Created by faishal on 11/2/17.
 */

public class VotingDialogPresenterGetSession implements
    VotingDialogContract.VotingDialogPresenterGetSession {

  VotingDialogContract.VotingDialogViewGetSession viewGetSession;
  VotingDialogRepository votingDialogRepository;

  public VotingDialogPresenterGetSession(
      VotingDialogRepository votingDialogRepository) {
    this.votingDialogRepository = votingDialogRepository;
  }

  @Override
  public void onAttachView(VotingDialogViewGetSession view) {
    this.viewGetSession = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataVotingDialogGetSession(String id_user, String id_voting) {
    votingDialogRepository.getResulVotingDialogGetSession(id_user, id_voting,
        new VotingDialogGetSessionGetCallback() {
          @Override
          public void onSuccesVotingDialogGetSession(String msg, String id_session,
              String status_session) {
            viewGetSession.onSuccesVotingDialogGetSession(msg, id_session, status_session);
          }

          @Override
          public void onSuccesVotingDialogGetSessionNull(String msg) {
            viewGetSession.onSuccesVotingDialogGetSessionNull(msg);
          }


          @Override
          public void onErrorVotingDialogGetSession(String msg) {
            viewGetSession.onErrorVotingDialogGetSession(msg);
          }
        });
  }
}
