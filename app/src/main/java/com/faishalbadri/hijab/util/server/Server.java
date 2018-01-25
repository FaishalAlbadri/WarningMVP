package com.faishalbadri.hijab.util.server;

import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * Created by faishal on 10/30/17.
 */

public class Server {

  public final static String BASE_URL_REVAMP = "http://pinkfame.com/api/v1/index.php/";
  public final static String BASE_ASSETS = "http://pinkfame.com/api/";
  public static final String EMAIL = "instagramofficialcourse@gmail.com";
  public static final String PASSWORD = "instaindo";
  public static String BASE_IMG_YT = "https://i.ytimg.com/vi/";
  public static String IMG_YT_FORMAT = "/mqdefault.jpg";
  public static String YT_CODE = "AIzaSyAZtqvIpixBElGAIewxDbfOABF0V35TWTY";

  public static boolean isEmpty(MaterialEditText materialEditText) {
    return materialEditText.getText().toString().trim().length() <= 0;
  }
}
