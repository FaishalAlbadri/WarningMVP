package com.faishalbadri.hijab.util;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.hijab.util.server.Server;

/**
 * Created by fikriimaduddin on 19/02/18.
 */

public class ImageLoader {

  Context context;

  public ImageLoader(Context context) {
    this.context = context;
  }

  public void displayCircleImage(String image, int rounded, ImageView imageView) {
    RequestOptions options = new RequestOptions()
        .transform(new RoundedCorners(rounded))
        .format(DecodeFormat.PREFER_ARGB_8888);
    Glide.with(context)
        .load(Server.BASE_ASSETS + image)
        .apply(options)
        .into(imageView);
  }

  public void displayImage(String image, ImageView imageView) {
    RequestOptions options = new RequestOptions()
        .fitCenter()
        .format(DecodeFormat.PREFER_ARGB_8888)
        .override(200, 200);
    Glide.with(context)
        .load(Server.BASE_ASSETS + image)
        .apply(options)
        .into(imageView);
  }

  public void displayImageFromYoutube(String image, ImageView imageView) {
    RequestOptions options = new RequestOptions()
        .fitCenter()
        .format(DecodeFormat.PREFER_ARGB_8888)
        .override(200, 200);
    Glide.with(context)
        .load(Server.BASE_IMG_YT + image + Server.IMG_YT_FORMAT)
        .apply(options)
        .into(imageView);
  }
}
