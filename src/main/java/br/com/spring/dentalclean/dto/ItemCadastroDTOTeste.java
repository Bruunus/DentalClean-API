package br.com.spring.dentalclean.dto;

public class ItemCadastroDTOTeste {

	private String nome;
	
	private String profissao;
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Valores retornados:\n\nNome: "+this.nome +"\nProfissão: "+this.profissao ;
	}
	
}
