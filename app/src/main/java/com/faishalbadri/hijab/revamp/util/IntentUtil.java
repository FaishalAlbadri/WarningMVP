package com.faishalbadri.hijab.revamp.util;

import android.content.Context;
import android.content.Intent;

/**
 * Created by faishal on 18/11/17.
 */

public class IntentUtil {

  Context context;

  public IntentUtil(Context context) {
    this.context = context;
  }

  public void IntentShare(String subject, String text) {
    Intent share = new Intent(Intent.ACTION_SEND);
    share.setType("text/plain");
    share.putExtra(Intent.EXTRA_SUBJECT, subject);
    share.putExtra(Intent.EXTRA_TEXT, text);
    context.startActivity(Intent.createChooser(share, "Bagikan dengan"));
  }
}
