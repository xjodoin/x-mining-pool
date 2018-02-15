package me.jodoin.mining.pool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.fasterxml.jackson.databind.ObjectMapper;

import me.jodoin.mining.pool.request.StratumRequest;

public class StratumClient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
	private ObjectMapper mapper;
    
    public StratumClient(ObjectMapper mapper) {
		this.mapper = mapper;
	}
 
    public void startConnection(String ip, int port) throws UnknownHostException, IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }
 
    public String sendMessage(StratumRequest msg) throws IOException {
        out.println(mapper.writeValueAsString(msg));
        String resp = in.readLine();
        return resp;
    }
 
    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
}