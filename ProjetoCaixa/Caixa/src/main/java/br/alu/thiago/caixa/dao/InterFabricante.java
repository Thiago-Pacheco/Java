package br.alu.thiago.caixa.dao;

import java.util.List;

import br.alu.thiago.caixa.domain.Fabricante;

public interface InterFabricante {

	void salvar(Fabricante fabricante);
	
	List<Fabricante>listar();
	
	Fabricante buscarPorCodigo(Long codigo);
	
	void excluir(Fabricante fabricante);
	
	void editar(Fabricante fabricante);
	
}
