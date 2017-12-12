package com.faishalbadri.hijab.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/30/17.
 */

public class PojoUser {

  /**
   * user : [{"id_user":"10","username":"fikri","email":"fikri.im@gmail.com","password":"57ba172a6be125cca2f449826f9980ca","img_user":"IMG-20171007-WA0002.jpg"}]
   * status : 1 msg : Data Semua User
   */

  private String status;
  private String msg;
  private List<UserBean> user;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public List<UserBean> getUser() {
    return user;
  }

  public void setUser(List<UserBean> user) {
    this.user = user;
  }

  public static class UserBean implements Parcelable {

    public static final Creator<UserBean> CREATOR = new Creator<UserBean>() {
      @Override
      public UserBean createFromParcel(Parcel in) {
        return new UserBean(in);
      }

      @Override
      public UserBean[] newArray(int size) {
        return new UserBean[size];
      }
    };
    /**
     * id_user : 10
     * username : fikri
     * email : fikri.im@gmail.com
     * password : 57ba172a6be125cca2f449826f9980ca
     * img_user : IMG-20171007-WA0002.jpg
     */

    private String id_user;
    private String username;
    private String email;
    private String password;
    private String img_user;

    protected UserBean(Parcel in) {
      id_user = in.readString();
      username = in.readString();
      email = in.readString();
      password = in.readString();
      img_user = in.readString();
    }

    public String getId_user() {
      return id_user;
    }

    public void setId_user(String id_user) {
      this.id_user = id_user;
    }

    public String getUsername() {
      return username;
    }

    public void setUsername(String username) {
      this.username = username;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public String getImg_user() {
      return img_user;
    }

    public void setImg_user(String img_user) {
      this.img_user = img_user;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
      parcel.writeString(id_user);
      parcel.writeString(username);
      parcel.writeString(email);
      parcel.writeString(password);
      parcel.writeString(img_user);
    }
  }
}
