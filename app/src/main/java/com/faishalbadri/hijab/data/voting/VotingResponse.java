package com.faishalbadri.hijab.data.voting;

import java.util.List;

public class VotingResponse {

  private List<VotingItem> voting;
  private boolean error;
  private String message;

  public List<VotingItem> getVoting() {
    return voting;
  }

  public void setVoting(List<VotingItem> voting) {
    this.voting = voting;
  }

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

  @Override
  public String toString() {
    return
        "VotingResponse{" +
            "voting = '" + voting + '\'' +
            ",error = '" + error + '\'' +
            ",message = '" + message + '\'' +
            "}";
  }
}