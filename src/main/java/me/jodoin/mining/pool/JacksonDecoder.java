package me.jodoin.mining.pool;

import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class JacksonDecoder<T> extends ByteToMessageDecoder {
	private final Class<T> clazz;
	private final ObjectMapper objectMapper;

	public JacksonDecoder(ObjectMapper objectMapper, Class<T> clazz) {
		this.objectMapper = objectMapper;
		this.clazz = clazz;
	}

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		ByteBufInputStream byteBufInputStream = new ByteBufInputStream(in);
		out.add(objectMapper.readValue((InputStream) byteBufInputStream, clazz));
	}

}