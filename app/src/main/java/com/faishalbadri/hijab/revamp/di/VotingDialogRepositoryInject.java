package com.faishalbadri.hijab.revamp.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.voting_dialog.VotingDialogRepository;
import com.faishalbadri.hijab.repository.voting_dialog.remote.VotingDialogDataRemote;

/**
 * Created by faishal on 11/2/17.
 */

public class VotingDialogRepositoryInject {

  public static VotingDialogRepository provideToVotingDialogRepository(Context context) {
    return new VotingDialogRepository(new VotingDialogDataRemote(context));
  }

}
