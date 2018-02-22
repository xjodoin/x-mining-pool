package me.jodoin.mining.pool;

import me.jodoin.mining.pool.response.StratumResponse;

public class StratumRequestHandlerFactory implements StratumRequestVisitorFactory<StratumResponse<?>> {

	@Override
	public StratumRequestVisitor<StratumResponse<?>> create(StratumSession session) {
		return new StratumRequestHandler(session);
	}

}
