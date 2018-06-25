package br.alu.thiago.caixa.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.alu.thiago.caixa.domain.Fabricante;
import br.alu.thiago.caixa.domain.Fachada;
import br.alu.thiago.caixa.domain.Produto;

public class ProdutoTest {

	private Produto produto;

	private Fachada fachada;

	private Fabricante fabricante;

	public ProdutoTest() {

		this.produto = new Produto();

		this.fachada = Fachada.getInstancia();
	}

	@Test
	@Ignore
	public void inserir() {

		this.fabricante = fachada.buscarPorCodigoFabricante(2L);

		this.produto.setDescricao("Galaxy S9");

		this.produto.setPreco(new BigDecimal(1.200D));

		this.produto.setQuantidade(10);

		this.produto.setFabricante(fabricante);

		this.fachada.salvarProduto(produto);

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {

		this.produto = this.fachada.buscarPorCodigoProduto(1L);

		System.out.println(produto);
	}

	@Test
	@Ignore
	public void listar() {

		List<Produto> listar = this.fachada.listarProduto();

		System.out.println(listar);
	}

	@Test
	@Ignore
	public void excluir() {

		this.produto = this.fachada.buscarPorCodigoProduto(2L);

		this.fachada.excluirProduto(produto);
	}

	@Test
	public void editar() {

		this.produto = this.fachada.buscarPorCodigoProduto(1L);

		this.produto.setDescricao("Iphone");

		this.produto.setPreco(new BigDecimal(1.20D));

		this.produto.setQuantidade(10);

		//this.produto.setFabricante(fabricante);

		this.fachada.editarProduto(produto);

	}

}
