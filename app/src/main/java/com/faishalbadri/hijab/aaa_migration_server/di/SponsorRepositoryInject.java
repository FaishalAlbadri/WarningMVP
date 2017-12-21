package com.faishalbadri.hijab.aaa_migration_server.di;

import android.content.Context;
import com.faishalbadri.hijab.aaa_migration_server.repository.sponsor.SponsorRepository;
import com.faishalbadri.hijab.aaa_migration_server.repository.sponsor.remote.SponsorDataRemote;

/**
 * Created by faishal on 15/11/17.
 */

public class SponsorRepositoryInject {

  public static SponsorRepository provideToSponsorRepository(Context context) {
    return new SponsorRepository(new SponsorDataRemote(context));
  }
}
