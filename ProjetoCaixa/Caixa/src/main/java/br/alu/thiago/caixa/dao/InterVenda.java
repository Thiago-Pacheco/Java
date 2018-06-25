package br.alu.thiago.caixa.dao;

import java.util.List;

import br.alu.thiago.caixa.domain.Venda;

public interface InterVenda {

	Long salvar(Venda venda);
	
	List<Venda>listar();
	
	Venda buscarPorCodigo(Long codigo);
	
	void excluir(Venda venda);
	
	void editar(Venda venda);
}
