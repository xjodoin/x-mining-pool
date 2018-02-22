package me.jodoin.mining.pool.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MiningSubmitResponse extends StratumResponse<Boolean> {

	@JsonIgnore
	private boolean accepted;

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	@Override
	public Boolean getResult() {
		return accepted;
	}

}
