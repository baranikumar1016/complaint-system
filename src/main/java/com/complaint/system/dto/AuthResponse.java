package com.complaint.system.dto;

public class AuthResponse {
	
	private String message;
	private Long id;
	private String role;
	
	public AuthResponse(String message, Long userId,String role){
		this.id=userId;
		this.message=message;
		this.role=role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
