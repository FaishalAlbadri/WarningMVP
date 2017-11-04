package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.category_video.CategoryVideoRepository;
import com.faishalbadri.hijab.repository.category_video.remote.CategoryVideoDataRemote;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class CategoryVideoRepositoryInject {
  public static CategoryVideoRepository provideToCategoryVideoRepositories(Context context){
    return new CategoryVideoRepository(new CategoryVideoDataRemote(context));
  }
}
