package me.jodoin.mining.pool;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import me.jodoin.mining.pool.request.StratumRequest;

public class StratumServerHandler extends SimpleChannelInboundHandler<StratumRequest> {

	private static final Logger LOGGER = LoggerFactory.getLogger(StratumRequestHandler.class);
	
	private ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

	private StratumRequestVisitorFactory<?> visitorfactory;
	private Map<Channel, StratumSession> sessions = new ConcurrentHashMap<>();
	
	public StratumServerHandler(StratumRequestVisitorFactory<?> visitorfactory) {
		this.visitorfactory = visitorfactory;
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		Channel channel = ctx.channel();
		sessions.put(channel, new StratumSession(channel));
		channels.add(channel);
	}
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, StratumRequest msg) throws Exception {
		StratumSession stratumSession = sessions.get(ctx.channel());
		ctx.write(msg.accept(visitorfactory.create(stratumSession)));
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}

}
