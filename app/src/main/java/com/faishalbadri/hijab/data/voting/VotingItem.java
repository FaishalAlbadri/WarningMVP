package com.faishalbadri.hijab.data.voting;

import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class VotingItem {

	@SerializedName("voting_nickname")
	private String votingNickname;

	@SerializedName("voting_img")
	private String votingImg;

	@SerializedName("voting_id")
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