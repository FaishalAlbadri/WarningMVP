package com.faishalbadri.hijab.repository.voting_dialog;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 11/2/17.
 */

public interface VotingDialogDataResource {

  interface VotingDialogGetSessionGetCallback {

    void onSuccesVotingDialogGetSession(String msg,String id_session, String status_session);

    void onSuccesVotingDialogGetSessionNull(String msg);

    void onErrorVotingDialogGetSession(String msg);
  }

  void getResulVotingDialogGetSession(String id_user, String id_voting,
      @NonNull VotingDialogGetSessionGetCallback votingDialogGetSessionGetCallback);

  interface VotingDialogLikeGetCallback {

    void onSuccesVotingDialogLike(String msg);

    void onErrorVotingDialogLike(String msg);
  }

  void getResulVotingDialogLike(String id_voting, String id_user,
      @NonNull VotingDialogLikeGetCallback votingDialogLikeGetCallback);

  interface VotingDialogUnlikeGetCallback {

    void onSuccesVotingDialogUnlike(String msg);

    void onErrorVotingDialogUnlike(String msg);
  }

  void getResulVotingDialogUnlike(String id_voting, String id_session,
      @NonNull VotingDialogUnlikeGetCallback votingDialogUnlikeGetCallback);

}
