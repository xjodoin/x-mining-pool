package me.jodoin.mining.pool.request;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import me.jodoin.mining.pool.response.StratumResponse;

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
	public StratumResponse accept(StratumRequestVisitor visitor) {
		return visitor.visit(this);
	}

}
