package me.jodoin.mining.pool.request;

import me.jodoin.mining.pool.StratumRequestVisitor;
import me.jodoin.mining.pool.response.StratumResponse;

public class GetworkRequest extends StratumRequest {

	@Override
	public StratumResponse accept(StratumRequestVisitor visitor) {
		return visitor.visit(this);
	}

}
