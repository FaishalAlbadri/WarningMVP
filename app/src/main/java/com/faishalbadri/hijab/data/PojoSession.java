package com.faishalbadri.hijab.data;

import android.os.Parcel;
import java.util.List;

/**
 * Created by faishal on 11/2/17.
 */

public class PojoSession {

  /**
   * error : false
   * message : ADA
   * session : [{"session_id":5,"session_user_id":8,"session_voting_id":1,"session_status":1}]
   */

  private boolean error;
  private String message;
  private List<SessionBean> session;

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

  public List<SessionBean> getSession() {
    return session;
  }

  public void setSession(List<SessionBean> session) {
    this.session = session;
  }

  public static class SessionBean implements android.os.Parcelable {

    public static final Creator<SessionBean> CREATOR = new Creator<SessionBean>() {
      @Override
      public SessionBean createFromParcel(Parcel source) {
        return new SessionBean(source);
      }

      @Override
      public SessionBean[] newArray(int size) {
        return new SessionBean[size];
      }
    };
    /**
     * session_id : 5
     * session_user_id : 8
     * session_voting_id : 1
     * session_status : 1
     */

    private String session_id;
    private String session_user_id;
    private String session_voting_id;
    private String session_status;

    public SessionBean() {
    }

    protected SessionBean(Parcel in) {
      this.session_id = in.readString();
      this.session_user_id = in.readString();
      this.session_voting_id = in.readString();
      this.session_status = in.readString();
    }

    public String getSession_id() {
      return session_id;
    }

    public void setSession_id(String session_id) {
      this.session_id = session_id;
    }

    public String getSession_user_id() {
      return session_user_id;
    }

    public void setSession_user_id(String session_user_id) {
      this.session_user_id = session_user_id;
    }

    public String getSession_voting_id() {
      return session_voting_id;
    }

    public void setSession_voting_id(String session_voting_id) {
      this.session_voting_id = session_voting_id;
    }

    public String getSession_status() {
      return session_status;
    }

    public void setSession_status(String session_status) {
      this.session_status = session_status;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.session_id);
      dest.writeString(this.session_user_id);
      dest.writeString(this.session_voting_id);
      dest.writeString(this.session_status);
    }
  }
}
