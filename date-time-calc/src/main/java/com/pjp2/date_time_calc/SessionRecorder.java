package com.pjp2.date_time_calc;

import java.io.Serializable;

public class SessionRecorder implements Serializable {
	private String operation;
	private String result;

	public SessionRecorder(String operation, String result) {
		super();
		this.operation = operation;
		this.result = result;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
