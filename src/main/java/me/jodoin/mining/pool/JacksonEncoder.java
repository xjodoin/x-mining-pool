package me.jodoin.mining.pool;

import static io.netty.buffer.Unpooled.wrappedBuffer;

import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

public class JacksonEncoder<I> extends MessageToMessageEncoder<I> {

	private ObjectMapper objectMapper;

	public JacksonEncoder(ObjectMapper objectMapper, Class<I> clazz) {
		super(clazz);
		this.objectMapper = objectMapper;
	}
	
	@Override
	protected void encode(ChannelHandlerContext ctx, I msg, List<Object> out) throws Exception {
		out.add(ByteBufUtil.encodeString(ctx.alloc(), CharBuffer.wrap(objectMapper.writeValueAsString(msg)+"\n"), Charset.defaultCharset()));
	}

}
