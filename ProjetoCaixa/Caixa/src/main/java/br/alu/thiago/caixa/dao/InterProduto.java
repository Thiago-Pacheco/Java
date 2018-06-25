package br.alu.thiago.caixa.dao;

import java.util.List;

import br.alu.thiago.caixa.domain.Produto;

public interface InterProduto {

	void salvar(Produto produto);

	List<Produto> listar();

	Produto buscarPorCodigo(Long codigo);

	void excluir(Produto produto);

	void editar(Produto produto);
}
