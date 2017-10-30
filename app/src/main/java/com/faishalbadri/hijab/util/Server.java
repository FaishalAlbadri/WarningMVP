package com.faishalbadri.hijab.util;

import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * Created by faishal on 10/30/17.
 */

public class Server {

  public final static String BASE_URL = "http://api.santriprogrammer.com/hijab/library/";
  public final static String BASE_IMG = "http://api.santriprogrammer.com/hijab/img/";

  public static boolean isEmpty(MaterialEditText materialEditText) {
        /*jika banyak huruf lebih dari 0*/
    if (materialEditText.getText().toString().trim().length() > 0) {
            /*tidak dikembalikan*/
      return false;
    } else {
            /*kembalikan*/
      return true;
    }
  }

}
