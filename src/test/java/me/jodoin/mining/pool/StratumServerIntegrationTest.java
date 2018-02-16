package me.jodoin.mining.pool;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.UnknownHostException;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import me.jodoin.mining.pool.request.GetworkRequest;
import me.jodoin.mining.pool.request.StratumRequestVisitor;
import me.jodoin.mining.pool.response.StratumResponse;

public class StratumServerIntegrationTest {

	@Test
	public void test() throws UnknownHostException, IOException, InterruptedException {
		StratumRequestVisitor requestVisitor = mock(StratumRequestVisitor.class);
		when(requestVisitor.visit(any(GetworkRequest.class))).thenReturn(new StratumResponse());
		
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
