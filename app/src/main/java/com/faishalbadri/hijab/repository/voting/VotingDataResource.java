package com.faishalbadri.hijab.repository.voting;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.voting.VotingItem;
import java.util.List;

/**
 * Created by faishal on 11/2/17.
 */

public interface VotingDataResource {

  void getVotingResult(int PAGE, @NonNull VotingDataResource.VotingGetCallback votingGetCallback);

  interface VotingGetCallback {

    void onSuccesVoting(List<VotingItem> list, String msg);

    void onErrorVoting(String msg);
  }

}
