package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.*;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 10:10
 */

@XmlRootElement(name = "Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class Response<T> {
	@XmlAttribute
	private boolean success;
	@XmlElement(name = "Body")
	private T body;
	@XmlElement(name = "Error")
	private ResponseError error;

	public static <T> Response<T> ok(T body) {
		Response<T> result = new Response<T>();
		result.success = true;
		result.body = body;
		return result;
	}

	public static <T> Response<T> error(String code, String message) {
		Response<T> result = new Response<T>();
		result.success = false;
		result.error = new ResponseError();
		result.error.code = code;
		result.error.message = message;
		return result;
	}


	public boolean isSuccess() {
		return success;
	}

	public T getBody() {
		return body;
	}

	public ResponseError getError() {
		return error;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setBody(T body) {
		this.body = body;
	}

	public void setError(ResponseError error) {
		this.error = error;
	}

	@XmlType(name = "ResponseError")
	public static class ResponseError {
		private String code;
		private String message;

		public String getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}
}
