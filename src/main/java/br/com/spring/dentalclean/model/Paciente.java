package br.com.spring.dentalclean.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "paciente")
public class Paciente {


	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Boolean naoDeletado;
	
	private String nomeCompleto;
	
	private LocalDate dataNascimento;
	
	private String genero;
	
	private String email;
	
	private String convenio;
	
	private Integer numeroCarteirinha;
	
	private String rua;
	
	private Integer numero;
	
	private String bairro;
	
	private String cidade;
	
	private String estado;
	
	

	public Long getId_cadastro_paciente() {
		return id;
	}

	public void setId_cadastro_paciente(Long id_cadastro_paciente) {
		this.id = id_cadastro_paciente;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public Integer getNumeroCarteirinha() {
		return numeroCarteirinha;
	}

	public void setNumeroCarteirinha(Integer numeroCarteirinha) {
		this.numeroCarteirinha = numeroCarteirinha;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Boolean getNaoDeletado() {
		return naoDeletado;
	}

	public void setNaoDeletado(Boolean deletado) {
		this.naoDeletado = deletado;
	}
	
	
	
	@Override
	public String toString() {
		 
		return "ID do banco (" + this.id+")";
	}
	
	
	
}
