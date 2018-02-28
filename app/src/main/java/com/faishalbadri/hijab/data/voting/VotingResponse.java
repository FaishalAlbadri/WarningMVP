package com.faishalbadri.hijab.data.voting;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class VotingResponse {

	@SerializedName("voting")
	private List<VotingItem> voting;

	@SerializedName("error")
	private boolean error;

	@SerializedName("message")
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