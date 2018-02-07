package com.faishalbadri.hijab.util.server;

import com.rengwuxian.materialedittext.MaterialEditText;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by faishal on 10/30/17.
 */

public class Server {

  public final static String BASE_URL_REVAMP = "http://pinkfame.com/api/v1/";
  public final static String BASE_ASSETS = "http://pinkfame.com/api/";
  public static final String EMAIL = "instagramofficialcourse@gmail.com";
  public static final String PASSWORD = "instaindo";
  public static String BASE_IMG_YT = "https://i.ytimg.com/vi/";
  public static String IMG_YT_FORMAT = "/mqdefault.jpg";
  public static String YT_CODE = "AIzaSyAZtqvIpixBElGAIewxDbfOABF0V35TWTY";

  public static boolean isEmpty(MaterialEditText materialEditText) {
    return materialEditText.getText().toString().trim().length() <= 0;
  }

  public static String convertPassMd5(String pass) {
    String password = null;
    MessageDigest mdEnc;
    try {
      mdEnc = MessageDigest.getInstance("MD5");
      mdEnc.update(pass.getBytes(), 0, pass.length());
      pass = new BigInteger(1, mdEnc.digest()).toString(16);
      while (pass.length() < 32) {
        pass = "0" + pass;
      }
      password = pass;
    } catch (NoSuchAlgorithmException e1) {
      e1.printStackTrace();
    }
    return password;
  }
}
