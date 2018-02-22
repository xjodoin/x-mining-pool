package me.jodoin.mining.pool.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import me.jodoin.mining.pool.StratumRequestVisitor;
import me.jodoin.mining.pool.response.StratumResponse;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "method", visible = false)
@JsonSubTypes({ @JsonSubTypes.Type(value = GetworkRequest.class, name = "getwork"),
		@JsonSubTypes.Type(value = ClientGetVersionRequest.class, name = "client.get_version"),
		@JsonSubTypes.Type(value = MiningAuthorizeRequest.class, name = "mining.authorize"),
		@JsonSubTypes.Type(value = MiningExtranonceSubscribeRequest.class, name = "mining.extranonce.subscribe"),
		@JsonSubTypes.Type(value = MiningGetTransactionsRequest.class, name = "mining.get_transactions"),
		@JsonSubTypes.Type(value = MiningSubmitRequest.class, name = "mining.submit"),
		@JsonSubTypes.Type(value = MiningSubscribeRequest.class, name = "mining.subscribe"),
		@JsonSubTypes.Type(value = MiningSuggestDifficultyRequest.class, name = "mining.suggest_difficulty") })
public abstract class StratumRequest {

	private Long id;
	private List<Object> params;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Object> getParams() {
		return params;
	}

	public void setParams(List<Object> params) {
		this.params = params;
	}

	protected <T> T getParam(int index) {
		return (T) params.get(index);
	}

	public abstract <T> T accept(StratumRequestVisitor<T> visitor);

}
