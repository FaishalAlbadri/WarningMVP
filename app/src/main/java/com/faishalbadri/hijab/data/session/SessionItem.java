package com.faishalbadri.hijab.data.session;

import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class SessionItem {

  @SerializedName("session_user_id")
  private String sessionUserId;

  @SerializedName("session_id")
  private String sessionId;

  @SerializedName("session_voting_id")
  private String sessionVotingId;

  @SerializedName("session_status")
  private String sessionStatus;

  public String getSessionUserId() {
    return sessionUserId;
  }

  public void setSessionUserId(String sessionUserId) {
    this.sessionUserId = sessionUserId;
  }

  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  public String getSessionVotingId() {
    return sessionVotingId;
  }

  public void setSessionVotingId(String sessionVotingId) {
    this.sessionVotingId = sessionVotingId;
  }

  public String getSessionStatus() {
    return sessionStatus;
  }

  public void setSessionStatus(String sessionStatus) {
    this.sessionStatus = sessionStatus;
  }

  @Override
  public String toString() {
    return
        "SessionItem{" +
            "session_user_id = '" + sessionUserId + '\'' +
            ",session_id = '" + sessionId + '\'' +
            ",session_voting_id = '" + sessionVotingId + '\'' +
            ",session_status = '" + sessionStatus + '\'' +
            "}";
  }
}