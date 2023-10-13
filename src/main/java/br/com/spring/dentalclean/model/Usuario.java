package br.com.spring.dentalclean.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String usuario;
	
	private String senha;
	
	private String email;
	
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
	
	
	@Override
	public String toString() {
		 
		return "ID do banco (" + this.id+")";
	}
	
	
	
}
