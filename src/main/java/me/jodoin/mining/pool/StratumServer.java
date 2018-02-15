package me.jodoin.mining.pool;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.LineEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import me.jodoin.mining.pool.request.StratumRequest;
import me.jodoin.mining.pool.response.StratumResponse;

/**
 * Discards any incoming data.
 */
public class StratumServer implements Runnable {

	private int port;
	private ChannelFuture channel;
	private ObjectMapper objectMapper = new ObjectMapper();
	private StratumRequestVisitor visitor;

	public StratumServer(int port, StratumRequestVisitor visitor) {
		this.port = port;
		this.visitor = visitor;
	}

	public void run() {
		try {
			EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
			EventLoopGroup workerGroup = new NioEventLoopGroup();
			try {
				ServerBootstrap b = new ServerBootstrap(); // (2)
				b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class) // (3)
						.handler(new LoggingHandler(LogLevel.INFO))
						.childHandler(new ChannelInitializer<SocketChannel>() { // (4)
							@Override
							public void initChannel(SocketChannel ch) throws Exception {
								ChannelPipeline pipeline = ch.pipeline();
								pipeline.addLast("line", new LineBasedFrameDecoder(200));
								pipeline.addLast("jackson_decoder",
										new JacksonDecoder<>(objectMapper, StratumRequest.class));
								pipeline.addLast("jackson_encoder",
										new JacksonEncoder<>(objectMapper, StratumResponse.class));
								pipeline.addLast("stratum_handler", new StratumServerHandler(visitor));
							}
						}).option(ChannelOption.SO_BACKLOG, 128) // (5)
						.childOption(ChannelOption.SO_KEEPALIVE, true); // (6)

				channel = b.bind(port).sync();

				// Wait until the server socket is closed.
				// In this example, this does not happen, but you can do that to gracefully
				// shut down your server.
				channel.channel().closeFuture().sync();
			} finally {
				workerGroup.shutdownGracefully();
				bossGroup.shutdownGracefully();
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public ChannelFuture close() {
		return channel.channel().close();
	}

	public static void main(String[] args) throws Exception {
		int port;
		if (args.length > 0) {
			port = Integer.parseInt(args[0]);
		} else {
			port = 8080;
		}
		// FIXME
		new StratumServer(port, null).run();
	}
}