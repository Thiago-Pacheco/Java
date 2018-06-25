package br.alu.thiago.caixa.dao;

import java.util.List;

import br.alu.thiago.caixa.domain.Item;

public interface InterItem {

	void salvar(Item item);
	
	List<Item>listar();
	
	Item buscarPorCodigo(Long codigo);
	
	
	
}
