package me.jodoin.mining.pool;

import me.jodoin.mining.pool.request.GetworkRequest;
import me.jodoin.mining.pool.response.StratumResponse;

public interface StratumRequestVisitor {

	StratumResponse visit(GetworkRequest getworkRequest);

}
