package me.jodoin.mining.pool.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ClientGetVersionResponse extends StratumResponse<String> {

	@JsonIgnore
	private String version;

	public ClientGetVersionResponse() {
		super();
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String getResult() {
		return version;
	}


}
