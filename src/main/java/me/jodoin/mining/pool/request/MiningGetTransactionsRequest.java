package me.jodoin.mining.pool.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

import me.jodoin.mining.pool.response.StratumResponse;

public class MiningGetTransactionsRequest extends StratumRequest {

    @JsonIgnore
    public String getJobId() {
        return getParam(0);
    }

    @Override
    public StratumResponse accept(StratumRequestVisitor visitor) {
    	return visitor.visit(this);
    }

}
