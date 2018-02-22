package me.jodoin.mining.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import me.jodoin.mining.pool.request.ClientGetVersionRequest;
import me.jodoin.mining.pool.request.GetworkRequest;
import me.jodoin.mining.pool.request.MiningAuthorizeRequest;
import me.jodoin.mining.pool.request.MiningExtranonceSubscribeRequest;
import me.jodoin.mining.pool.request.MiningGetTransactionsRequest;
import me.jodoin.mining.pool.request.MiningSubmitRequest;
import me.jodoin.mining.pool.request.MiningSubscribeRequest;
import me.jodoin.mining.pool.request.MiningSuggestDifficultyRequest;
import me.jodoin.mining.pool.request.StratumRequest;

public class LoggerRequestVisitor<T> implements StratumRequestVisitor<T> {

	private static Logger logger = LoggerFactory.getLogger(LoggerRequestVisitor.class);
	
	private final ObjectMapper mapper;
	private final StratumRequestVisitor<T> visitor;

	public LoggerRequestVisitor(ObjectMapper mapper, StratumRequestVisitor<T> visitor) {
		this.mapper = mapper;
		this.visitor = visitor;
	}
	
	@Override
	public T visit(GetworkRequest request) {
		return log(request);
	}

	@Override
	public T visit(ClientGetVersionRequest request) {
		return log(request);
	}

	@Override
	public T visit(MiningAuthorizeRequest request) {
		return log(request);
	}

	@Override
	public T visit(MiningExtranonceSubscribeRequest request) {
		return log(request);
	}

	@Override
	public T visit(MiningGetTransactionsRequest request) {
		return log(request);
	}

	@Override
	public T visit(MiningSubmitRequest request) {
		return log(request);
	}

	@Override
	public T visit(MiningSubscribeRequest request) {
		return log(request);
	}

	@Override
	public T visit(MiningSuggestDifficultyRequest request) {
		return log(request);
	}
	
	private T log(StratumRequest req) {
		try {
			logger.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(req));
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		return req.accept(visitor);
	}

}
