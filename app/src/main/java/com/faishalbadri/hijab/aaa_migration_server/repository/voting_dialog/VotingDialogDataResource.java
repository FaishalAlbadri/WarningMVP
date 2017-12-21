package com.faishalbadri.hijab.aaa_migration_server.repository.voting_dialog;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 11/2/17.
 */

public interface VotingDialogDataResource {

  void getResulVotingDialogGetSession(String id_user, String id_voting,
      @NonNull VotingDialogGetSessionGetCallback votingDialogGetSessionGetCallback);

  void getResulVotingDialogVotingRate(String voting_id, String user_id, String type, String
      voting_session_id, @NonNull VotingDialogVotingRateGetCallback votingDialogVotingRateGetCallback);


  interface VotingDialogGetSessionGetCallback {

    void onSuccesVotingDialogGetSession(String msg, String id_session, String status_session);

    void onSuccesVotingDialogGetSessionNull(String msg);

    void onErrorVotingDialogGetSession(String msg);
  }

  interface VotingDialogVotingRateGetCallback {

    void onSuccesVotingDialogVotingRate(String msg);

    void onErrorVotingDialogVotingRate(String msg);
  }


}
