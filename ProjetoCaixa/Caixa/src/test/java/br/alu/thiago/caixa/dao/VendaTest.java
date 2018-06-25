package br.alu.thiago.caixa.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.alu.thiago.caixa.domain.Fachada;
import br.alu.thiago.caixa.domain.Funcionario;
import br.alu.thiago.caixa.domain.Venda;

public class VendaTest {

	private Fachada fachada;
	
	private Venda venda;
	
	public VendaTest() {
	
		this.fachada =  Fachada.getInstancia();
		
		this.venda = new Venda();
	}
	
	@Test
	@Ignore
	public void salvar() {
		
		Funcionario funcionario = this.fachada.buscarPorCodigoFuncionario(1L);
		
		this.venda.setFuncionario(funcionario);
		
		this.venda.setHorario(new Date());
		
		this.venda.setValor(new BigDecimal(12.34D));
		
		this.fachada.salvarVenda(venda);
		
	}
	
	@Test
	@Ignore
	public void listar() {
		
		List<Venda> vendas = this.fachada.listarVenda();
		
		System.out.println(vendas);
		
		
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		
		Venda venda = this.fachada.buscarPorCodigoVenda(1L);
		
		System.out.println(venda);
	}
	
}
