package me.jodoin.mining.pool.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import me.jodoin.mining.pool.response.StratumResponse;

public class ClientGetVersionRequest extends StratumRequest {

	public static final String METHOD_NAME = "client.get_version";

	@Override
	public StratumResponse accept(StratumRequestVisitor visitor) {
		return visitor.visit(this);
	}


}
