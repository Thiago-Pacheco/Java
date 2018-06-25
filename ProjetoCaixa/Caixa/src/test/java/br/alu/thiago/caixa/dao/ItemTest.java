package br.alu.thiago.caixa.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.alu.thiago.caixa.domain.Fachada;
import br.alu.thiago.caixa.domain.Item;
import br.alu.thiago.caixa.domain.Produto;
import br.alu.thiago.caixa.domain.Venda;

public class ItemTest {
	
	private Fachada fachada;
	
	private Item item;
	
	public ItemTest() {
	
		this.fachada = Fachada.getInstancia();
		
		this.item = new Item();
	}
	
	@Test
	@Ignore
	public void salvar() {
		
		Produto produto = this.fachada.buscarPorCodigoProduto(1L);
		
		Venda venda = this.fachada.buscarPorCodigoVenda(1L);
		
		this.item.setProduto(produto);
		
		this.item.setQuantidade(1);
		
		this.item.setValor(new BigDecimal(23.54D));
		
		this.item.setVenda(venda);
		
		this.fachada.salvarItem(item);
		
	}
	
	@Test
	@Ignore
	public void listar() {
		
		List<Item> itens = this.fachada.listarItem();
		
		System.out.println(itens);
	}
	
	@Test
	public void buscar() {
		
		this.item = this.fachada.buscarPorCodigoItem(1L);
		
		System.out.println(item);
	}

}
