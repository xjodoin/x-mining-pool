package me.jodoin.mining.pool.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class GetworkResponse extends StratumResponse<GetworkResponse.Result> {

	private Result result  = new Result();

	@JsonIgnore
	public String getMidstate() {
		return result.midstate;
	}

	public void setMidstate(String midstate) {
		result.midstate = midstate;
	}

	@JsonIgnore
	public String getData() {
		return result.data;
	}

	public void setData(String data) {
		result.data = data;
	}

	@JsonIgnore
	public String getHash1() {
		return result.hash1;
	}

	public void setHash1(String hash1) {
		result.hash1 = hash1;
	}

	@JsonIgnore
	public String getTarget() {
		return result.target;
	}

	public void setTarget(String target) {
		result.target = target;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	@JsonInclude(Include.NON_NULL)
	public class Result {
		private String midstate;
		private String data;
		private String hash1;
		private String target;

		public String getMidstate() {
			return midstate;
		}

		public void setMidstate(String midstate) {
			this.midstate = midstate;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public String getHash1() {
			return hash1;
		}

		public void setHash1(String hash1) {
			this.hash1 = hash1;
		}

		public String getTarget() {
			return target;
		}

		public void setTarget(String target) {
			this.target = target;
		}
	}

}
