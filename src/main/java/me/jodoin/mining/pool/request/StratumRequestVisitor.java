package me.jodoin.mining.pool.request;

import me.jodoin.mining.pool.response.StratumResponse;

public interface StratumRequestVisitor {

	StratumResponse visit(GetworkRequest getworkRequest);

	StratumResponse visit(ClientGetVersionRequest clientGetVersionRequest);

	StratumResponse visit(MiningAuthorizeRequest miningAuthorizeRequest);

	StratumResponse visit(MiningExtranonceSubscribeRequest miningExtranonceSubscribeRequest);

	StratumResponse visit(MiningGetTransactionsRequest miningGetTransactionsRequest);

	StratumResponse visit(MiningSubmitRequest miningSubmitRequest);

	StratumResponse visit(MiningSubscribeRequest miningSubscribeRequest);

	StratumResponse visit(MiningSuggestDifficultyRequest miningSuggestDifficultyRequest);

}
