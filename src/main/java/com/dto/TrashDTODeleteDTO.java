package com.dto;

public class TrashDTODeleteDTO {
	private Integer trashId;
	private String tot;
	private String subject;
	private String message;

	public Integer getTrashId() {
		return trashId;
	}

	public void setTrashId(Integer trashId) {
		this.trashId = trashId;
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

}
