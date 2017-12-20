package com.faishalbadri.hijab.revamp.di;

import android.content.Context;
import com.faishalbadri.hijab.revamp.repository.slider_home.SliderHomeRepository;
import com.faishalbadri.hijab.revamp.repository.slider_home.remote.SliderHomeDataRemote;

/**
 * Created by faishal on 20/12/17.
 */

public class SliderHomeRepositoryInject {

  public static SliderHomeRepository provideToSliderHomeRepository(Context context) {
    return new SliderHomeRepository(new SliderHomeDataRemote(context));
  }
}
