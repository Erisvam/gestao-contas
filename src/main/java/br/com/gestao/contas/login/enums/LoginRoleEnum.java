package br.com.gestao.contas.login.enums;

public enum LoginRoleEnum {
	
	ROOT("ROOT"),
	ADMIN("ADMIN"),
	USER("USER");
	
	private String role;
	
	LoginRoleEnum(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return this.role;
	}
}
