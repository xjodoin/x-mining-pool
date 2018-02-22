package me.jodoin.mining.pool;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LoggerStratumRequestVisitorFactory<T> implements StratumRequestVisitorFactory<T> {

	private StratumRequestVisitorFactory<T> visitorFactory;
	private ObjectMapper mapper;

	public LoggerStratumRequestVisitorFactory(ObjectMapper mapper,StratumRequestVisitorFactory<T> visitorFactory) {
		this.mapper = mapper;
		this.visitorFactory = visitorFactory;
	}
	
	@Override
	public StratumRequestVisitor<T> create(StratumSession session) {
		return new LoggerRequestVisitor<>(mapper, visitorFactory.create(session));
	}

}
