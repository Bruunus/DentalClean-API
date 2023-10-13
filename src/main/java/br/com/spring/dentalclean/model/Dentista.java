package br.com.spring.dentalclean.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "dentista")
public class Dentista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@NotNull
	private Boolean naoDeletado;  
	
	@Column(name = "nome_completo")
	private String nomeCompleto;

	private String rua;

	private Integer numero;

	private String bairro;

	private String cidade;

	private String estado;	
	
	private String email;

	
	private LocalDate dataNascimento;

	@Column(name = "telefone_residencial")
	private String telefoneResidencial;

	@Column(name = "telefone_celular")
	private String telefoneCelular;

	private String especialidade;

	private String CRO;

	private String cpf;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long codigo_id) {
		this.id = codigo_id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getCRO() {
		return CRO;
	}

	public void setCRO(String cRO) {
		CRO = cRO;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public Dentista orElseThrow(RuntimeException object) {
		// TODO Auto-generated method stub
		return null;
	}

}
