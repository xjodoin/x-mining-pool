package me.jodoin.mining.pool.response;

import java.util.concurrent.atomic.AtomicLong;

public abstract class StratumResponse<T> {

	private static final AtomicLong counter = new AtomicLong(1);
	
	private Long id = counter.getAndIncrement();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public abstract T getResult();
	
}
