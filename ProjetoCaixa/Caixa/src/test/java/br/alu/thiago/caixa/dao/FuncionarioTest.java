package br.alu.thiago.caixa.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.alu.thiago.caixa.domain.Fachada;
import br.alu.thiago.caixa.domain.Funcionario;

public class FuncionarioTest {

	private Funcionario funcionario;

	private Fachada fachada;

	public FuncionarioTest() {

		this.funcionario = new Funcionario();

		this.fachada = Fachada.getInstancia();
	}

	@Test
	@Ignore
	public void salvar() {

		this.funcionario.setCpf("111.111.111-11");

		this.funcionario.setFuncao("Gerente");

		this.funcionario.setNome("Thiago");

		this.funcionario.setSenha("1234");

		this.fachada.salvarFuncionario(funcionario);
	}

	@Test
	@Ignore
	public void listar() {

		List<Funcionario> funcionarios = this.fachada.listarFuncionario();

		System.out.println(funcionarios);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {

		this.funcionario = this.fachada.buscarPorCodigoFuncionario(1L);

		System.out.println(funcionario);
	}

	@Test
	@Ignore
	public void excluir() {

	}

	@Test
	@Ignore
	public void editar() {

		this.funcionario = this.fachada.buscarPorCodigoFuncionario(1L);

		this.funcionario.setCpf("222.222.222-22");

		this.funcionario.setFuncao("Balconista");

		this.funcionario.setNome("Thiago Pacheco");

		this.funcionario.setSenha("12342");
		
		this.fachada.editarFuncionario(funcionario);
	}
	
	@Test
	@Ignore
	public void autenticar() {
		
		this.funcionario = this.fachada.autenticar("222.222.222-22", "12342");
		
		System.out.println(funcionario);
		
	}

}
