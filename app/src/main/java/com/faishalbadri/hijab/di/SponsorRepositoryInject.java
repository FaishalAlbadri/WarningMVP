package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.sponsor.SponsorRepository;
import com.faishalbadri.hijab.repository.sponsor.remote.SponsorDataRemote;

/**
 * Created by faishal on 15/11/17.
 */

public class SponsorRepositoryInject {
  public static SponsorRepository provideToSponsorRepository(Context context){
    return new SponsorRepository(new SponsorDataRemote(context));
  }
}
