package me.jodoin.mining.pool.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

import me.jodoin.mining.pool.StratumRequestVisitor;

public class MiningAuthorizeRequest extends StratumRequest {

	@JsonIgnore
	public String getUsername() {
		return getParam(0);
	}

	@JsonIgnore
	public String getPassword() {
		return getParam(1);
	}

	@Override
	public <T> T accept(StratumRequestVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
