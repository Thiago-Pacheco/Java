package br.alu.thiago.caixa.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.alu.thiago.caixa.domain.Fabricante;
import br.alu.thiago.caixa.domain.Fachada;
import br.alu.thiago.caixa.domain.Produto;
import br.alu.thiago.caixa.util.FacesUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable{

	private Produto produto;

	private List<Produto> listaProduto;
	
	private List<Fabricante> listaFabricante;

	private Fachada fachada;

	private String acao;

	private Long codigo;

	public ProdutoBean() {

		this.fachada = Fachada.getInstancia();
	}

	public void novo() {

		this.produto = new Produto();
	}

	public void salvar() {

		try {

			this.fachada.salvarProduto(produto);

			this.produto = new Produto();

			FacesUtil.adicionarMsgInfo("Produto salvo");

		} catch (RuntimeException re) {

			FacesUtil.adicionarMsgError("Erro ao salvar o produto" + re.getMessage());

		}
	}

	public void listar() {

		try {

			this.listaProduto = this.fachada.listarProduto();

		} catch (RuntimeException re) {

			FacesUtil.adicionarMsgError("Erro ao listar o produto" + re.getMessage());

		}
	}

	public void carregar() {

		try {

			if (codigo != null) {

				this.produto = this.fachada.buscarPorCodigoProduto(codigo);

			} else {

				this.produto = new Produto();

			}
			
			this.listaFabricante = this.fachada.listarFabricante();

		} catch (RuntimeException re) {

			FacesUtil.adicionarMsgError("Erro ao tentar obter o produto" + re.getMessage());

		}
	}

	public void excluir() {

		try {

			this.fachada.excluirProduto(produto);

			FacesUtil.adicionarMsgInfo("Produto excluido");

		} catch (RuntimeException re) {

			FacesUtil.adicionarMsgError("Erro ao excluir o produto" + re.getMessage());

		}

	}
	
	public void editar() {

		try {

			this.fachada.editarProduto(produto);

			FacesUtil.adicionarMsgInfo("Produto editado");

		} catch (RuntimeException re) {

			FacesUtil.adicionarMsgError("Erro ao editar o produto" + re.getMessage());

		}

	}



	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public List<Fabricante> getListaFabricante() {
		return listaFabricante;
	}

	public void setListaFabricante(List<Fabricante> listaFabricante) {
		this.listaFabricante = listaFabricante;
	}
	
	

}
