package com.faishalbadri.hijab.util;

import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * Created by faishal on 10/30/17.
 */

public class Server {


  public final static String BASE_URL_REVAMP = "http://api.santriprogrammer.com/pinkyhijab/api/v1/";
  public final static String BASE_API = "http://api.santriprogrammer.com/pinkyhijab/api/";


  public final static String BASE_URL = "http://api.santriprogrammer.com/hijab/library/";
  public final static String BASE_IMG = "http://api.santriprogrammer.com/hijab/img/";
  public static String BASE_IMG_YT = "https://i.ytimg.com/vi/";
  public static String IMG_YT_FORMAT = "/mqdefault.jpg";
  public static String YT_CODE = "AIzaSyAZtqvIpixBElGAIewxDbfOABF0V35TWTY";

  public static final String EMAIL = "instagramofficialcourse@gmail.com";
  public static final String PASSWORD = "instaindo";

  public static boolean isEmpty(MaterialEditText materialEditText) {
        /*jika banyak huruf lebih dari 0*/
    return materialEditText.getText().toString().trim().length() <= 0;
  }

}
