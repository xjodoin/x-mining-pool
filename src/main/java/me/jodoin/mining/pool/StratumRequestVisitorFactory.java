package me.jodoin.mining.pool;

public interface StratumRequestVisitorFactory<T> {

	public StratumRequestVisitor<T> create(StratumSession session);
	
}
