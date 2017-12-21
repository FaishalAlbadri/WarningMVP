package com.faishalbadri.hijab.aaa_migration_server.di;

import android.content.Context;
import com.faishalbadri.hijab.aaa_migration_server.repository.voting.VotingRepository;
import com.faishalbadri.hijab.aaa_migration_server.repository.voting.remote.VotingDataRemote;

/**
 * Created by faishal on 11/2/17.
 */

public class VotingRepositoryInject {

  public static VotingRepository provideToVotingRepository(Context context) {
    return new VotingRepository(new VotingDataRemote(context));
  }

}
