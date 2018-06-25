package br.alu.thiago.caixa.dao;

import java.util.List;

import br.alu.thiago.caixa.domain.Funcionario;

public interface InterFuncionario {

	void salvar(Funcionario funcionario);
	
	List<Funcionario>listar();
	
	Funcionario buscarPorCodigo(Long codigo);
	
	void excluir(Funcionario funcionario);
	
	void editar(Funcionario funcionario);
	
	Funcionario autenticar(String cpf, String senha);
	
	
}
