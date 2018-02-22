package me.jodoin.mining.pool.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import me.jodoin.mining.pool.StratumRequestVisitor;
import me.jodoin.mining.pool.response.StratumResponse;

public class ClientGetVersionRequest extends StratumRequest {

	public static final String METHOD_NAME = "client.get_version";

	@Override
	public <T> T accept(StratumRequestVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
