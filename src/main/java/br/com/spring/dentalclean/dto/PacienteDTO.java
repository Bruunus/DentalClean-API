package br.com.spring.dentalclean.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PacienteDTO {	
	
	@JsonIgnore
	private Long id;

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
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id_paciente) {
		this.id = id_paciente;
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

	
	
	
	@Override
	public String toString() {
		
		return super.toString();
	}
	
	 
	
	
}
