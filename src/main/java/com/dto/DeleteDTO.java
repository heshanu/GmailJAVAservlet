package com.dto;

public class DeleteDTO {
	private Integer deleteId;
	public Integer getDeleteId() {
		return deleteId;
	}
	public void setDeleteId(Integer deleteId) {
		this.deleteId = deleteId;
	}
	public String getTot() {
		return tot;
	}
	public void setTot(String tot) {
		this.tot = tot;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String tot;
	private String subject;
	private String message;

}
