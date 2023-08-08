package br.com.gestao.contas.login.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.gestao.contas.login.enums.LoginRoleEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_users")
public class UserLogin implements UserDetails, Serializable {
	
	private static final long serialVersionUID = -5970505108621499732L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 40, unique = true)
	private String login;
	
	@Column(nullable = false)
	private String senha;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private LoginRoleEnum role;
	
	public UserLogin(String login, LoginRoleEnum role, String senha) {
		this.login = login;
		this.role = role;
		this.senha = senha;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(LoginRoleEnum.ADMIN.equals(this.role) || LoginRoleEnum.ROOT.equals(this.role)) return List.of(getRoleAdmin(), getRoleUser());
		return List.of(getRoleUser());
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	private SimpleGrantedAuthority getRoleAdmin() {
		return new SimpleGrantedAuthority("ROLE_ADMIN");
	}
	
	private SimpleGrantedAuthority getRoleUser() {
		return new SimpleGrantedAuthority("ROLE_ADMIN");
	}
}
