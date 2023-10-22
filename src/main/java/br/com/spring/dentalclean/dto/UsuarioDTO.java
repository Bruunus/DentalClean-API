package br.com.spring.dentalclean.dto;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.spring.dentalclean.model.Dentista;
import br.com.spring.dentalclean.model.Usuario;

public class UsuarioDTO {
	
	@JsonIgnore
	private Long id;
	
	private String usuario;
	
	private String senha;
	
	private String email;
	
	@NotNull
	@JsonIgnore
	private Boolean naoDeletado;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getNaoDeletado() {
		return naoDeletado;
	}

	public void setNaoDeletado(Boolean naoDeletado) {
		this.naoDeletado = naoDeletado;
	}

	
	

	 
	
	

	
}
