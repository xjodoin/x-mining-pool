package me.jodoin.mining.pool.notification;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonRpcNotification {

	@JsonInclude(Include.NON_NULL)
	private String jsonrpc;
	// The id of a notification is always null.
	private Integer id = null;
	private String method;
	private List<Object> params;

	public JsonRpcNotification(String method) {
		this.method = method;
	}

	public JsonRpcNotification(JsonRpcNotification request) {
		this.method = request.method;
		this.setParams(request.getParams());
	}


	public Integer getId() {
		return id;
	}

	public String getMethod() {
		return method;
	}

	public List<Object> getParams() {
		return params;
	}

	public void setParams(List<Object> params) {
		this.params = params;
	}

	public String getJsonrpc() {
		return jsonrpc;
	}

	@SuppressWarnings("unchecked")
	protected <T> T getParamsObjectAtIndex(int index) {
		T resultObject = null;
		if (params instanceof List) {
			List<Object> resultList = (List<Object>) params;
			resultObject = resultList.size() > index && resultList.get(index) != null ? (T) resultList.get(index) : null;
		}
		return resultObject;
	}

}
