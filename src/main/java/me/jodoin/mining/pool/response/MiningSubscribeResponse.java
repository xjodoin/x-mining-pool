package me.jodoin.mining.pool.response;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MiningSubscribeResponse extends StratumResponse<List<Object>> {

	@JsonIgnore
	private List<Object> subscriptionDetails;
	@JsonIgnore
	private String extranonce1;
	@JsonIgnore
	private Integer extranonce2Size;

	public List<Object> getSubscriptionDetails() {
		return subscriptionDetails;
	}

	public void setSubscriptionDetails(List<Object> subscriptionDetails) {
		this.subscriptionDetails = subscriptionDetails;
	}

	public String getExtranonce1() {
		return extranonce1;
	}

	public void setExtranonce1(String extranonce1) {
		this.extranonce1 = extranonce1;
	}

	public Integer getExtranonce2Size() {
		return extranonce2Size;
	}

	public void setExtranonce2Size(Integer extranonce2Size) {
		this.extranonce2Size = extranonce2Size;
	}

	@Override
	public List<Object> getResult() {
		return Arrays.asList(subscriptionDetails, extranonce1, extranonce2Size);
	}

}
