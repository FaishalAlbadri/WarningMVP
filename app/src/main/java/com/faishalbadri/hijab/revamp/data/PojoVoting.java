package com.faishalbadri.hijab.revamp.data;

import android.os.Parcel;
import java.util.List;

/**
 * Created by faishal on 11/2/17.
 */

public class PojoVoting {

  /**
   * error : false message : ADA voting : [{"voting_id":1,"voting_nickname":"User","voting_img":"assets/voting_images/IMG_1513579818.jpg","voting_count":1000}]
   */

  private boolean error;
  private String message;
  private List<VotingBean> voting;

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

  public List<VotingBean> getVoting() {
    return voting;
  }

  public void setVoting(List<VotingBean> voting) {
    this.voting = voting;
  }

  public static class VotingBean implements android.os.Parcelable {

    /**
     * voting_id : 1
     * voting_nickname : User
     * voting_img : assets/voting_images/IMG_1513579818.jpg
     * voting_count : 1000
     */

    private String voting_id;
    private String voting_nickname;
    private String voting_img;
    private int voting_count;

    public String getVoting_id() {
      return voting_id;
    }

    public void setVoting_id(String voting_id) {
      this.voting_id = voting_id;
    }

    public String getVoting_nickname() {
      return voting_nickname;
    }

    public void setVoting_nickname(String voting_nickname) {
      this.voting_nickname = voting_nickname;
    }

    public String getVoting_img() {
      return voting_img;
    }

    public void setVoting_img(String voting_img) {
      this.voting_img = voting_img;
    }

    public int getVoting_count() {
      return voting_count;
    }

    public void setVoting_count(int voting_count) {
      this.voting_count = voting_count;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.voting_id);
      dest.writeString(this.voting_nickname);
      dest.writeString(this.voting_img);
      dest.writeInt(this.voting_count);
    }

    public VotingBean() {
    }

    protected VotingBean(Parcel in) {
      this.voting_id = in.readString();
      this.voting_nickname = in.readString();
      this.voting_img = in.readString();
      this.voting_count = in.readInt();
    }

    public static final Creator<VotingBean> CREATOR = new Creator<VotingBean>() {
      @Override
      public VotingBean createFromParcel(Parcel source) {
        return new VotingBean(source);
      }

      @Override
      public VotingBean[] newArray(int size) {
        return new VotingBean[size];
      }
    };
  }
}
