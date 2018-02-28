package com.faishalbadri.hijab.data.voting;

public class VotingItem {

  private String votingNickname;
  private String votingImg;
  private String votingId;

  public String getVotingNickname() {
    return votingNickname;
  }

  public void setVotingNickname(String votingNickname) {
    this.votingNickname = votingNickname;
  }

  public String getVotingImg() {
    return votingImg;
  }

  public void setVotingImg(String votingImg) {
    this.votingImg = votingImg;
  }

  public String getVotingId() {
    return votingId;
  }

  public void setVotingId(String votingId) {
    this.votingId = votingId;
  }

  @Override
  public String toString() {
    return
        "VotingItem{" +
            "voting_nickname = '" + votingNickname + '\'' +
            ",voting_img = '" + votingImg + '\'' +
            ",voting_id = '" + votingId + '\'' +
            "}";
  }
}
