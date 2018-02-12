package com.faishalbadri.hijab.util.svg;

import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.SimpleResource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.caverock.androidsvg.SVG;

/**
 * Created by faishal on 12/02/18.
 */

public class SvgDrawableTranscoder implements ResourceTranscoder<SVG, PictureDrawable> {

  @Nullable
  @Override
  public Resource<PictureDrawable> transcode(@NonNull Resource<SVG> toTranscode,
      @NonNull Options options) {
    SVG svg = toTranscode.get();
    Picture picture = svg.renderToPicture();
    PictureDrawable drawable = new PictureDrawable(picture);
    return new SimpleResource<PictureDrawable>(drawable);
  }
}
