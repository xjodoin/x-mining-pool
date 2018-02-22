package me.jodoin.mining.pool.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MiningAuthorizeResponse extends StratumResponse<Boolean> {

	@JsonIgnore
	private boolean authorized;

	public boolean isAuthorized() {
		return authorized;
	}

	public void setAuthorized(boolean authorized) {
		this.authorized = authorized;
	}

	@Override
	public Boolean getResult() {
		return authorized;
	}

}
