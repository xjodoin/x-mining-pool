package me.jodoin.mining.pool;

import me.jodoin.mining.pool.request.ClientGetVersionRequest;
import me.jodoin.mining.pool.request.GetworkRequest;
import me.jodoin.mining.pool.request.MiningAuthorizeRequest;
import me.jodoin.mining.pool.request.MiningExtranonceSubscribeRequest;
import me.jodoin.mining.pool.request.MiningGetTransactionsRequest;
import me.jodoin.mining.pool.request.MiningSubmitRequest;
import me.jodoin.mining.pool.request.MiningSubscribeRequest;
import me.jodoin.mining.pool.request.MiningSuggestDifficultyRequest;

public interface StratumRequestVisitor<T> {

	T visit(GetworkRequest getworkRequest);

	T visit(ClientGetVersionRequest clientGetVersionRequest);

	T visit(MiningAuthorizeRequest miningAuthorizeRequest);

	T visit(MiningExtranonceSubscribeRequest miningExtranonceSubscribeRequest);

	T visit(MiningGetTransactionsRequest miningGetTransactionsRequest);

	T visit(MiningSubmitRequest miningSubmitRequest);

	T visit(MiningSubscribeRequest miningSubscribeRequest);

	T visit(MiningSuggestDifficultyRequest miningSuggestDifficultyRequest);

}
