package br.com.gestao.contas.login.enums;

public enum UserLoginRoleEnum {
	
	ADMIN("ADMIN"),
	USER("USER");
	
	private String role;
	
	UserLoginRoleEnum(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return this.role;
	}
}
