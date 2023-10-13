package br.com.spring.dentalclean.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.spring.dentalclean.dto.ItemCadastroDTOTeste;

@Component
public class CadastroDTO {
	
	private ItemCadastroDTOTeste itemCadastroDTOTeste;

	private List<ItemCadastroDTOTeste> cadastro;
	

	public List<ItemCadastroDTOTeste> getCadastro() {
		return cadastro;
	}

	public void setCadastro(List<ItemCadastroDTOTeste> cadastro) {
		this.cadastro = cadastro;
	}

	public ItemCadastroDTOTeste getItemCadastroDTO() {
		return itemCadastroDTOTeste;
	}

	public void setItemCadastroDTO(ItemCadastroDTOTeste itemCadastroDTOTeste) {
		this.itemCadastroDTOTeste = itemCadastroDTOTeste;
	}

	

	

}
