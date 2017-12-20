package com.faishalbadri.hijab.revamp.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/30/17.
 */

public class PojoUser {

  /**
   * user : [{"user_id":8,"user_name":"oo","user_email":"faishalalbadri1@gmail.com","user_handphone_number":"123","user_image":"IMG-20171207-PH-11127628925a296365b7eb39.384673005a296365b7f66.jpg","user_password":"e47ca7a09cf6781e29634502345930a7","user_verify_code":"592222","user_verified_code":"592222","user_gender":"Male","user_apikey":"aea6fbb5f33fafcf0d3b9ed635b08e41"}]
   * error : false
   * message : Login Successfull
   */

  private boolean error;
  private String message;
  private List<UserBean> user;

  public boolean isError() {
    return error;
  }

  public void setError(boolean error) {
    this.error = error;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<UserBean> getUser() {
    return user;
  }

  public void setUser(List<UserBean> user) {
    this.user = user;
  }

  public static class UserBean implements android.os.Parcelable {

    /**
     * user_id : 8
     * user_name : oo
     * user_email : faishalalbadri1@gmail.com
     * user_handphone_number : 123
     * user_image : IMG-20171207-PH-11127628925a296365b7eb39.384673005a296365b7f66.jpg
     * user_password : e47ca7a09cf6781e29634502345930a7
     * user_verify_code : 592222
     * user_verified_code : 592222
     * user_gender : Male
     * user_apikey : aea6fbb5f33fafcf0d3b9ed635b08e41
     */

    private String user_id;
    private String user_name;
    private String user_email;
    private String user_handphone_number;
    private String user_image;
    private String user_password;
    private String user_verify_code;
    private String user_verified_code;
    private String user_gender;
    private String user_apikey;

    public String getUser_id() {
      return user_id;
    }

    public void setUser_id(String user_id) {
      this.user_id = user_id;
    }

    public String getUser_name() {
      return user_name;
    }

    public void setUser_name(String user_name) {
      this.user_name = user_name;
    }

    public String getUser_email() {
      return user_email;
    }

    public void setUser_email(String user_email) {
      this.user_email = user_email;
    }

    public String getUser_handphone_number() {
      return user_handphone_number;
    }

    public void setUser_handphone_number(String user_handphone_number) {
      this.user_handphone_number = user_handphone_number;
    }

    public String getUser_image() {
      return user_image;
    }

    public void setUser_image(String user_image) {
      this.user_image = user_image;
    }

    public String getUser_password() {
      return user_password;
    }

    public void setUser_password(String user_password) {
      this.user_password = user_password;
    }

    public String getUser_verify_code() {
      return user_verify_code;
    }

    public void setUser_verify_code(String user_verify_code) {
      this.user_verify_code = user_verify_code;
    }

    public String getUser_verified_code() {
      return user_verified_code;
    }

    public void setUser_verified_code(String user_verified_code) {
      this.user_verified_code = user_verified_code;
    }

    public String getUser_gender() {
      return user_gender;
    }

    public void setUser_gender(String user_gender) {
      this.user_gender = user_gender;
    }

    public String getUser_apikey() {
      return user_apikey;
    }

    public void setUser_apikey(String user_apikey) {
      this.user_apikey = user_apikey;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.user_id);
      dest.writeString(this.user_name);
      dest.writeString(this.user_email);
      dest.writeString(this.user_handphone_number);
      dest.writeString(this.user_image);
      dest.writeString(this.user_password);
      dest.writeString(this.user_verify_code);
      dest.writeString(this.user_verified_code);
      dest.writeString(this.user_gender);
      dest.writeString(this.user_apikey);
    }

    public UserBean() {
    }

    protected UserBean(Parcel in) {
      this.user_id = in.readString();
      this.user_name = in.readString();
      this.user_email = in.readString();
      this.user_handphone_number = in.readString();
      this.user_image = in.readString();
      this.user_password = in.readString();
      this.user_verify_code = in.readString();
      this.user_verified_code = in.readString();
      this.user_gender = in.readString();
      this.user_apikey = in.readString();
    }

    public static final Creator<UserBean> CREATOR = new Creator<UserBean>() {
      @Override
      public UserBean createFromParcel(Parcel source) {
        return new UserBean(source);
      }

      @Override
      public UserBean[] newArray(int size) {
        return new UserBean[size];
      }
    };
  }
}
