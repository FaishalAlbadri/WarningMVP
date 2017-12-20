package com.faishalbadri.hijab.revamp.di;

import android.content.Context;
import com.faishalbadri.hijab.revamp.repository.voting.VotingRepository;
import com.faishalbadri.hijab.revamp.repository.voting.remote.VotingDataRemote;

/**
 * Created by faishal on 11/2/17.
 */

public class VotingRepositoryInject {

  public static VotingRepository provideToVotingRepository(Context context) {
    return new VotingRepository(new VotingDataRemote(context));
  }

}
