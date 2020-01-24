package com.udemy.app.ws.ui.model.response.error;

public enum ErrorMessages {

	MISSING_REQUIRED_FIELD("Missing required fields. Please check the documentation for input."),
	RECORD_ALREADY_EXISTS("Record already exists !"),
	INTERNAL_SERVER_ERROR("Internal server error !"),
	NO_RECORD_FOUND("Record with provided id not found !"),
	AUTHENTICATION_FAILED("Authentication Failed"),
	COULD_NOT_UPDATE_RECORD("Could not update record."),
	COULD_NOT_DELETE_RECORD("Could not delete record."),
	EMAIL_ADDRESS_NOT_VERFIIED("Email address could not be verified.");

	private String errorMessage;
	
	ErrorMessages(String errorMessage){
		this.errorMessage=errorMessage;
	}
	
	public String getErrorMessage() {
		return this.errorMessage;
	}
	
	public void setErrorMessage(String errMsg) {
		this.errorMessage=errMsg;
	}
}


