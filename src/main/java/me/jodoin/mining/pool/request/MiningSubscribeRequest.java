package me.jodoin.mining.pool.request;

import me.jodoin.mining.pool.StratumRequestVisitor;

public class MiningSubscribeRequest extends StratumRequest {

	@Override
	public <T> T accept(StratumRequestVisitor<T> visitor) {
		return visitor.visit(this);
	}


}
