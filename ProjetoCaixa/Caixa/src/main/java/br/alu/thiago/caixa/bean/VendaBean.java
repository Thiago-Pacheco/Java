package br.alu.thiago.caixa.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.alu.thiago.caixa.domain.Fachada;
import br.alu.thiago.caixa.domain.Funcionario;
import br.alu.thiago.caixa.domain.Item;
import br.alu.thiago.caixa.domain.Produto;
import br.alu.thiago.caixa.domain.Venda;
import br.alu.thiago.caixa.util.FacesUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VendaBean implements Serializable {

	private List<Produto> listaProdutos;

	private List<Item> listaItens;

	private Fachada fachada;
	
	private Venda venda;
	
	@ManagedProperty(value = "#{autenticacaoBean}")
	private AutenticacaoBean autenticacaoBean;
	
	

	public VendaBean() {

		this.fachada = Fachada.getInstancia();
	}

	public void listarProdutos() {

		try {

			this.listaProdutos = this.fachada.listarProduto();

		} catch (RuntimeException re) {

			FacesUtil.adicionarMsgError("Erro ao listar o produto" + re.getMessage());

		}
	}

	public void adicionar(Produto produto) {

		int posicaoEncontrada = -1;

		for (int pos = 0; pos < listaItens.size() && posicaoEncontrada < 0; pos++) {

			Item temp = this.listaItens.get(pos);

			if (temp.getProduto().equals(produto)) {

				posicaoEncontrada = pos;

			}
		}

		Item item = new Item();

		item.setProduto(produto);

		if (posicaoEncontrada < 0) {

			item.setQuantidade(1);

			item.setValor(produto.getPreco());

			this.listaItens.add(item);

		} else {

			Item itemTemp = this.listaItens.get(posicaoEncontrada);

			item.setQuantidade(itemTemp.getQuantidade() + 1);

			item.setValor(produto.getPreco().multiply(new BigDecimal(item.getQuantidade())));

			this.listaItens.set(posicaoEncontrada, item);

		}
		
		this.venda.setValor(venda.getValor().add(produto.getPreco()));

	}

	public void remover(Item item) {

		int posicaoEncontrada = -1;

		for (int pos = 0; pos < listaItens.size() && posicaoEncontrada < 0; pos++) {

			Item temp = this.listaItens.get(pos);

			if (temp.getProduto().equals(item.getProduto())) {

				posicaoEncontrada = pos;

			}
		}
		
		if(posicaoEncontrada > -1) {
			
			this.listaItens.remove(posicaoEncontrada);
			
			this.venda.setValor(this.venda.getValor().subtract(item.getValor()));
		}

	}
	
	public void carregarDadosVenda() {
		
		this.venda.setHorario(new Date());
		
		Funcionario f = this.fachada.buscarPorCodigoFuncionario(autenticacaoBean.getFuncionario().getCodigo());
		
		this.venda.setFuncionario(f);
	}
	
	public void salvar() {
		
		try {
			
			Long codigoVenda = this.fachada.salvarVenda(venda);
			
			Venda vendaFK = this.fachada.buscarPorCodigoVenda(codigoVenda);
			
			for(Item item: this.listaItens) {
				
				item.setVenda(vendaFK);
				
				this.fachada.salvarItem(item);
			}
			
			this.venda = new Venda();
			
			this.venda.setValor(new BigDecimal("0.00"));
			
			this.listaItens = new ArrayList<Item>();

			FacesUtil.adicionarMsgInfo("Venda salva" + codigoVenda);

		} catch (RuntimeException re) {

			FacesUtil.adicionarMsgError("Erro ao salvar a venda" + re.getMessage());

		}
	}
	

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public List<Item> getListaItens() {

		if (this.listaItens == null) {

			this.listaItens = new ArrayList<>();
		}

		return listaItens;
	}

	public void setListaItens(List<Item> listaItens) {
		this.listaItens = listaItens;
	}

	public Venda getVenda() {
		
		if(venda == null) {
			
			this.venda = new Venda();
			
			this.venda.setValor(new BigDecimal("0.00"));
		}
		
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public AutenticacaoBean getAutenticacaoBean() {
		return autenticacaoBean;
	}

	public void setAutenticacaoBean(AutenticacaoBean autenticacaoBean) {
		this.autenticacaoBean = autenticacaoBean;
	}

	
}
