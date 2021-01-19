package com.app.dto;

import java.time.LocalDateTime;

public class ResponseDTO {
	private String status;
	private String message;
	private LocalDateTime timeStamp;
	private Object data;
	public ResponseDTO() {
		// TODO Auto-generated constructor stub
	}
	public ResponseDTO(String status,String message,Object data) {
		super();
		this.status=status;
		this.message = message;
		this.data=data;
		this.timeStamp=LocalDateTime.now();
	}

	public ResponseDTO(Object data) {
		super();
		this.data = data;
		this.status="success";
		this.timeStamp= LocalDateTime.now();
	}
	public ResponseDTO(String status, String message) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp=LocalDateTime.now();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTs() {
		return timeStamp;
	}
	public void setTs(LocalDateTime ts) {
		this.timeStamp = ts;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	

}