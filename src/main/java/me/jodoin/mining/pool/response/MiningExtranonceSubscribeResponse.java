package me.jodoin.mining.pool.response;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MiningExtranonceSubscribeResponse extends StratumResponse<List<Boolean>> {

	@JsonIgnore
	private boolean subscribed;

	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}

	public boolean isSubscribed() {
		return subscribed;
	}

	@Override
	public List<Boolean> getResult() {
		return Arrays.asList(subscribed);
	}

}
