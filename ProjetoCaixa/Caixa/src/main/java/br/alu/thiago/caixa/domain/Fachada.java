package br.alu.thiago.caixa.domain;

import java.util.List;

import br.alu.thiago.caixa.dao.FabricanteDao;
import br.alu.thiago.caixa.dao.FuncionarioDao;
import br.alu.thiago.caixa.dao.ItemDao;
import br.alu.thiago.caixa.dao.ProdutoDao;
import br.alu.thiago.caixa.dao.VendaDao;

public class Fachada {

	private static Fachada instancia = null;

	private FabricanteDao fabricanteDao;

	private FuncionarioDao funcionarioDao;

	private ProdutoDao produtoDao;
	
	private VendaDao vendaDao;
	
	private ItemDao itemDao;

	public Fachada() {

		this.fabricanteDao = new FabricanteDao();

		this.funcionarioDao = new FuncionarioDao();

		this.produtoDao = new ProdutoDao();
		
		this.vendaDao = new VendaDao();
		
		this.itemDao = new ItemDao();
	}

	public static Fachada getInstancia() {

		if (instancia == null) {

			instancia = new Fachada();
		}

		return instancia;
	}

	public void salvarFabricante(Fabricante fabricante) {

		this.fabricanteDao.salvar(fabricante);

	}

	public List<Fabricante> listarFabricante() {

		return this.fabricanteDao.listar();
	}

	public Fabricante buscarPorCodigoFabricante(Long codigo) {

		return this.fabricanteDao.buscarPorCodigo(codigo);
	}

	public void excluirFabricante(Fabricante fabricante) {

		this.fabricanteDao.excluir(fabricante);

	}

	public void editarFabricante(Fabricante fabricante) {

		this.fabricanteDao.editar(fabricante);

	}

	public void salvarFuncionario(Funcionario funcionario) {

		this.funcionarioDao.salvar(funcionario);
	}

	public List<Funcionario> listarFuncionario() {

		return this.funcionarioDao.listar();
	}

	public Funcionario buscarPorCodigoFuncionario(Long codigo) {

		return this.funcionarioDao.buscarPorCodigo(codigo);

	}

	public void excluirFuncionario(Funcionario funcionario) {

		this.funcionarioDao.excluir(funcionario);
	}

	public void editarFuncionario(Funcionario funcionario) {

		this.funcionarioDao.editar(funcionario);
	}
	
	public Funcionario autenticar(String cpf, String senha) {
		
		return this.funcionarioDao.autenticar(cpf, senha);
	}

	public void salvarProduto(Produto produto) {

		this.produtoDao.salvar(produto);

	}

	public List<Produto> listarProduto() {

		return this.produtoDao.listar();
	}

	public Produto buscarPorCodigoProduto(Long codigo) {

		return this.produtoDao.buscarPorCodigo(codigo);
	}

	public void excluirProduto(Produto produto) {

		this.produtoDao.excluir(produto);
	}

	public void editarProduto(Produto produto) {

		this.produtoDao.editar(produto);
	}
	
	public Long salvarVenda(Venda venda) {
		
		 return this.vendaDao.salvar(venda);
	}
	
	public List<Venda> listarVenda() {
		
		return this.vendaDao.listar();
	}
	
	public Venda buscarPorCodigoVenda(Long codigo) {
		
		return this.vendaDao.buscarPorCodigo(codigo);
	}
	
	public void excluirVenda(Venda venda) {
		
		this.vendaDao.excluir(venda);
	}
	
	public void editarVenda(Venda venda) {
		
		this.vendaDao.editar(venda);
	}
	
	public void salvarItem(Item item) {
		
		this.itemDao.salvar(item);
		
	}
	
	public List<Item> listarItem() {
		
		return this.itemDao.listar();
	}
	
	public Item buscarPorCodigoItem(Long codigo) {
		
		return this.itemDao.buscarPorCodigo(codigo);
	}
}
