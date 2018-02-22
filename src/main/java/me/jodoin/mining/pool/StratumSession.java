package me.jodoin.mining.pool;

import io.netty.channel.Channel;

public class StratumSession {

	private Channel channel;

	public StratumSession(Channel channel) {
		this.channel = channel;
	}

}
