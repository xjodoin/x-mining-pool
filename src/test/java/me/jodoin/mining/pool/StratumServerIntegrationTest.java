package me.jodoin.mining.pool;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.fasterxml.jackson.databind.ObjectMapper;

import me.jodoin.mining.pool.request.GetworkRequest;
import me.jodoin.mining.pool.response.StratumResponse;

public class StratumServerIntegrationTest {

	@Test
	public void test() throws UnknownHostException, IOException, InterruptedException {
		StratumRequestVisitor requestVisitor = mock(StratumRequestVisitor.class);
		when(requestVisitor.visit(any())).thenReturn(new StratumResponse());
		
		StratumServer stratumServer = new StratumServer(8080, requestVisitor);

		new Thread(stratumServer).start();

		Thread.sleep(1000);
		
		StratumClient greetClient = new StratumClient(new ObjectMapper());
		greetClient.startConnection("localhost", 8080);

		String sendMessage = greetClient.sendMessage(new GetworkRequest());
		
		assertThat(sendMessage, equalTo("test"));
		greetClient.stopConnection();
		

//		ObjectMapper objectMapper = new ObjectMapper();
//		String writeValueAsBytes = objectMapper.writeValueAsString(new GetworkRequest());
//		outputStream.writeBytes(writeValueAsBytes + '\n');

//		ArgumentCaptor<GetworkRequest> captor = ArgumentCaptor.forClass(GetworkRequest.class);
//		verify(requestVisitor).visit(captor.capture());
//
//		GetworkRequest value = captor.getValue();
//
//		assertNotNull(value);

	}

}
