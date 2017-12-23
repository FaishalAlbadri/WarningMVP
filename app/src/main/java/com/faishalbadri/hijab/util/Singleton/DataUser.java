package com.faishalbadri.hijab.util.Singleton;

/**
 * Created by faishal on 23/12/17.
 */

public class DataUser {

  private static DataUser mInstance = null;
  private String userId, userName, userEmail, userPassword, userHandphoneNumber, userImage, userVerifyCode, userVerifiedCode, userGender, userApiKey;

  public DataUser() {
    userId = null;
    userName = null;
    userEmail = null;
    userPassword = null;
    userHandphoneNumber = null;
    userImage = null;
    userVerifyCode = null;
    userVerifiedCode = null;
    userGender = null;
    userApiKey = null;
  }

  public static DataUser getInstance() {
    if (mInstance == null) {
      mInstance = new DataUser();
    }
    return mInstance;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public String getUserHandphoneNumber() {
    return userHandphoneNumber;
  }

  public void setUserHandphoneNumber(String userHandphoneNumber) {
    this.userHandphoneNumber = userHandphoneNumber;
  }

  public String getUserImage() {
    return userImage;
  }

  public void setUserImage(String userImage) {
    this.userImage = userImage;
  }

  public String getUserVerifyCode() {
    return userVerifyCode;
  }

  public void setUserVerifyCode(String userVerifyCode) {
    this.userVerifyCode = userVerifyCode;
  }

  public String getUserVerifiedCode() {
    return userVerifiedCode;
  }

  public void setUserVerifiedCode(String userVerifiedCode) {
    this.userVerifiedCode = userVerifiedCode;
  }

  public String getUserGender() {
    return userGender;
  }

  public void setUserGender(String userGender) {
    this.userGender = userGender;
  }

  public String getUserApiKey() {
    return userApiKey;
  }

  public void setUserApiKey(String userApiKey) {
    this.userApiKey = userApiKey;
  }
}
