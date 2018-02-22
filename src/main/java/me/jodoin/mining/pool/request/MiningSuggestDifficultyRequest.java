package me.jodoin.mining.pool.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

import me.jodoin.mining.pool.StratumRequestVisitor;

public class MiningSuggestDifficultyRequest extends StratumRequest {

	@JsonIgnore
	public Double getSuggestedDifficulty() {
		return getParam(0);
	}

	@Override
	public <T> T accept(StratumRequestVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
