package me.jodoin.mining.pool;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import javax.xml.bind.DatatypeConverter;

import me.jodoin.mining.pool.request.ClientGetVersionRequest;
import me.jodoin.mining.pool.request.GetworkRequest;
import me.jodoin.mining.pool.request.MiningAuthorizeRequest;
import me.jodoin.mining.pool.request.MiningExtranonceSubscribeRequest;
import me.jodoin.mining.pool.request.MiningGetTransactionsRequest;
import me.jodoin.mining.pool.request.MiningSubmitRequest;
import me.jodoin.mining.pool.request.MiningSubscribeRequest;
import me.jodoin.mining.pool.request.MiningSuggestDifficultyRequest;
import me.jodoin.mining.pool.response.MiningAuthorizeResponse;
import me.jodoin.mining.pool.response.MiningSubscribeResponse;
import me.jodoin.mining.pool.response.StratumResponse;

public class StratumRequestHandler implements StratumRequestVisitor<StratumResponse<?>> {

	private static AtomicInteger nonceCounter = new AtomicInteger(1);
	
	private StratumSession session;
	
	public StratumRequestHandler(StratumSession session) {
		this.session = session;
	}

	@Override
	public StratumResponse<?> visit(GetworkRequest getworkRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StratumResponse<?> visit(ClientGetVersionRequest clientGetVersionRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StratumResponse<?> visit(MiningAuthorizeRequest miningAuthorizeRequest) {
		MiningAuthorizeResponse response = new MiningAuthorizeResponse();
		response.setAuthorized(true);
		return response;
	}

	@Override
	public StratumResponse<?> visit(MiningExtranonceSubscribeRequest miningExtranonceSubscribeRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StratumResponse<?> visit(MiningGetTransactionsRequest miningGetTransactionsRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StratumResponse<?> visit(MiningSubmitRequest miningSubmitRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StratumResponse<?> visit(MiningSubscribeRequest miningSubscribeRequest) {
		MiningSubscribeResponse response = new MiningSubscribeResponse();
		byte[] nonce = ByteBuffer.allocate(4).putInt(nonceCounter.getAndIncrement()).array();
		response.setExtranonce1(DatatypeConverter.printHexBinary(nonce));
		response.setExtranonce2Size(4);
		return response;
	}

	@Override
	public StratumResponse<?> visit(MiningSuggestDifficultyRequest miningSuggestDifficultyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
