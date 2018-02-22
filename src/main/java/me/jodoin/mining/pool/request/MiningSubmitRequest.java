package me.jodoin.mining.pool.request;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import me.jodoin.mining.pool.StratumRequestVisitor;
import me.jodoin.mining.pool.response.StratumResponse;

public class MiningSubmitRequest extends StratumRequest {

	@JsonIgnore
	public String getWorkerName() {
		return getParam(0);
	}

	@JsonIgnore
	public String getJobId() {
		return getParam(1);
	}

	@JsonIgnore
	public String getExtranonce2() {
		return getParam(2);
	}

	@JsonIgnore
	public String getNtime() {
		return getParam(3);
	}

	@JsonIgnore
	public String getNonce() {
		return getParam(4);
	}
	
	@Override
	public <T> T accept(StratumRequestVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
