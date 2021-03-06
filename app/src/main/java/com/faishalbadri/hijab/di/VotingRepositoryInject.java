package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.voting.VotingRepository;
import com.faishalbadri.hijab.repository.voting.remote.VotingDataRemote;

/**
 * Created by faishal on 11/2/17.
 */

public class VotingRepositoryInject {

  public static VotingRepository provideToVotingRepository(Context context) {
    return new VotingRepository(new VotingDataRemote(context));
  }

}
