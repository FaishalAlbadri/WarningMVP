package com.faishalbadri.hijab.aaa_migration_server.repository.voting;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoVoting.VotingBean;
import java.util.List;

/**
 * Created by faishal on 11/2/17.
 */

public interface VotingDataResource {

  void getVotingResult(@NonNull VotingDataResource.VotingGetCallback votingGetCallback);

  interface VotingGetCallback {

    void onSuccesVoting(List<VotingBean> list, String msg);

    void onDataVotingNull(String msg);

    void onErrorVoting(String msg);
  }

}
