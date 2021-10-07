package com.molina.bookstore.resources.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fiedName;
	private String message;

	public FieldMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FieldMessage(String fiedName, String message) {
		super();
		this.fiedName = fiedName;
		this.message = message;
	}

	public String getFiedName() {
		return fiedName;
	}

	public void setFiedName(String fiedName) {
		this.fiedName = fiedName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
