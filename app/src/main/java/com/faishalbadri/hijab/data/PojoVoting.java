package com.faishalbadri.hijab.data;

import android.os.Parcel;
import java.util.List;

/**
 * Created by faishal on 11/2/17.
 */

public class PojoVoting {


  /**
   * voting : [{"id_voting":"1","voting_nickname":"Faishal","voting_img":"Hijab-Muslimah.jpg","voting_like":"1"},{"id_voting":"2","voting_nickname":"Faishal","voting_img":"Hijab-Muslimah.jpg","voting_like":"0"},{"id_voting":"3","voting_nickname":"Faishal","voting_img":"Hijab-Muslimah.jpg","voting_like":"0"},{"id_voting":"4","voting_nickname":"Faishal","voting_img":"Hijab-Muslimah.jpg","voting_like":"0"},{"id_voting":"5","voting_nickname":"Faishal","voting_img":"Hijab-Muslimah.jpg","voting_like":"0"},{"id_voting":"6","voting_nickname":"Faishal","voting_img":"example.png","voting_like":"0"}]
   * status : 1 msg : Data Semua Voting
   */

  private String status;
  private String msg;
  private List<VotingBean> voting;

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

  public List<VotingBean> getVoting() {
    return voting;
  }

  public void setVoting(List<VotingBean> voting) {
    this.voting = voting;
  }

  public static class VotingBean implements android.os.Parcelable {

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
    /**
     * id_voting : 1
     * voting_nickname : Faishal
     * voting_img : Hijab-Muslimah.jpg
     * voting_like : 1
     */

    private String id_voting;
    private String voting_nickname;
    private String voting_img;
    private Double voting_like;

    public VotingBean() {
    }

    protected VotingBean(Parcel in) {
      this.id_voting = in.readString();
      this.voting_nickname = in.readString();
      this.voting_img = in.readString();
      this.voting_like = (Double) in.readValue(Double.class.getClassLoader());
    }

    public String getId_voting() {
      return id_voting;
    }

    public void setId_voting(String id_voting) {
      this.id_voting = id_voting;
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

    public Double getVoting_like() {
      return voting_like;
    }

    public void setVoting_like(Double voting_like) {
      this.voting_like = voting_like;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.id_voting);
      dest.writeString(this.voting_nickname);
      dest.writeString(this.voting_img);
      dest.writeValue(this.voting_like);
    }
  }
}
