package me.jodoin.mining.pool;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import me.jodoin.mining.pool.request.StratumRequest;
import me.jodoin.mining.pool.request.StratumRequestVisitor;

public class StratumServerHandler extends SimpleChannelInboundHandler<StratumRequest> {

	private ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	private StratumRequestVisitor visitor;
	
	public StratumServerHandler(StratumRequestVisitor visitor) {
		this.visitor = visitor;
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		channels.add(ctx.channel());
	}
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, StratumRequest msg) throws Exception {
		ctx.write(msg.accept(visitor));
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
