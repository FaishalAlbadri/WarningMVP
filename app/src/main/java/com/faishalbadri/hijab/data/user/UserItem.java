package com.faishalbadri.hijab.data.user;

import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class UserItem {

  @SerializedName("user_verified_code")
  private String userVerifiedCode;

  @SerializedName("user_email")
  private String userEmail;

  @SerializedName("user_password")
  private String userPassword;

  @SerializedName("user_apikey")
  private String userApikey;

  @SerializedName("user_id")
  private String userId;

  @SerializedName("user_image")
  private String userImage;

  @SerializedName("user_name")
  private String userName;

  @SerializedName("user_verify_code")
  private String userVerifyCode;

  @SerializedName("user_handphone_number")
  private String userHandphoneNumber;

  @SerializedName("user_gender")
  private String userGender;

  public String getUserVerifiedCode() {
    return userVerifiedCode;
  }

  public void setUserVerifiedCode(String userVerifiedCode) {
    this.userVerifiedCode = userVerifiedCode;
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

  public String getUserApikey() {
    return userApikey;
  }

  public void setUserApikey(String userApikey) {
    this.userApikey = userApikey;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserImage() {
    return userImage;
  }

  public void setUserImage(String userImage) {
    this.userImage = userImage;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserVerifyCode() {
    return userVerifyCode;
  }

  public void setUserVerifyCode(String userVerifyCode) {
    this.userVerifyCode = userVerifyCode;
  }

  public String getUserHandphoneNumber() {
    return userHandphoneNumber;
  }

  public void setUserHandphoneNumber(String userHandphoneNumber) {
    this.userHandphoneNumber = userHandphoneNumber;
  }

  public String getUserGender() {
    return userGender;
  }

  public void setUserGender(String userGender) {
    this.userGender = userGender;
  }

  @Override
  public String toString() {
    return
        "UserItem{" +
            "user_verified_code = '" + userVerifiedCode + '\'' +
            ",user_email = '" + userEmail + '\'' +
            ",user_password = '" + userPassword + '\'' +
            ",user_apikey = '" + userApikey + '\'' +
            ",user_id = '" + userId + '\'' +
            ",user_image = '" + userImage + '\'' +
            ",user_name = '" + userName + '\'' +
            ",user_verify_code = '" + userVerifyCode + '\'' +
            ",user_handphone_number = '" + userHandphoneNumber + '\'' +
            ",user_gender = '" + userGender + '\'' +
            "}";
  }
}