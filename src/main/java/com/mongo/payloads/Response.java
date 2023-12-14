package com.mongo.payloads;

public class Response {
	private int success;

	private String message;

	private Object data;

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Response [success=" + success + ", message=" + message + ", data=" + data + "]";
	}

	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Response(int success, String message, Object data) {
		super();
		this.success = success;
		this.message = message;
		this.data = data;
	}
	
}


