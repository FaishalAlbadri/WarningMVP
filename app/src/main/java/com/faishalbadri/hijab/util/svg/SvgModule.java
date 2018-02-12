package com.faishalbadri.hijab.util.svg;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.caverock.androidsvg.SVG;
import java.io.InputStream;

/**
 * Created by faishal on 12/02/18.
 */

@GlideModule
public class SvgModule extends AppGlideModule {

  public void registerComponents(Context context, Registry registry) {
    registry.register(SVG.class, PictureDrawable.class, new SvgDrawableTranscoder())
        .append(InputStream.class, SVG.class, new SvgDecoder());
  }

}
