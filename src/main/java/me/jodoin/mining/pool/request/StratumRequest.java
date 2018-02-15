package me.jodoin.mining.pool.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import me.jodoin.mining.pool.StratumRequestVisitor;
import me.jodoin.mining.pool.response.StratumResponse;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "method", visible = false)
@JsonSubTypes({ @JsonSubTypes.Type(value = GetworkRequest.class, name = "getwork")})
public abstract class StratumRequest {
	
	public abstract StratumResponse accept(StratumRequestVisitor visitor);

}
