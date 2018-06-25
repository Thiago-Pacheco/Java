package br.alu.thiago.caixa.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.alu.thiago.caixa.domain.Fabricante;
import br.alu.thiago.caixa.domain.Fachada;
import br.alu.thiago.caixa.util.FacesUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteBean implements Serializable{

	private Fabricante fabricante;

	private List<Fabricante> listaFabricantes;

	private Fachada fachada;

	private String acao;

	private Long codigo;

	public FabricanteBean() {

		this.fabricante = new Fabricante();

		this.fachada = Fachada.getInstancia();

	}

	public void salvar() {

		try {

			this.fachada.salvarFabricante(fabricante);

			this.fabricante = new Fabricante();

			FacesUtil.adicionarMsgInfo("Fabricante salvo com sucesso");

		} catch (RuntimeException re) {

			re.printStackTrace();

			FacesUtil.adicionarMsgError("Erro ao salvar um fabricante" + re.getMessage());
		}
	}

	public void novo() {

		this.fabricante = new Fabricante();
	}

	public void listaFabricante() {

		try {

			this.listaFabricantes = this.fachada.listarFabricante();

		} catch (RuntimeException re) {

			re.printStackTrace();

			FacesUtil.adicionarMsgError("Erro ao listar os fabricantes" + re.getMessage());
		}
	}

	public void carregar() {

		try {

			if (this.codigo != null) {

				this.fabricante = this.fachada.buscarPorCodigoFabricante(codigo);

			}else {
				
				this.fabricante = new Fabricante();
			}

		} catch (RuntimeException re) {

			FacesUtil.adicionarMsgError("Erro ao listar os fabricantes" + re.getMessage());
		}
	}

	public void excluir() {

		try {

			this.fachada.excluirFabricante(fabricante);

			FacesUtil.adicionarMsgInfo("Fabricante excluido com sucesso");

		} catch (RuntimeException re) {

			re.printStackTrace();

			FacesUtil.adicionarMsgError("Erro ao excluir um fabricante" + re.getMessage());
		}

	}

	public void editar() {

		try {

			this.fachada.editarFabricante(fabricante);

			FacesUtil.adicionarMsgInfo("Fabricante editado com sucesso");

		} catch (RuntimeException re) {

			re.printStackTrace();

			FacesUtil.adicionarMsgError("Erro ao editar um fabricante" + re.getMessage());
		}

	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public List<Fabricante> getListaFabricantes() {
		return listaFabricantes;
	}

	public void setListaFabricantes(List<Fabricante> listaFabricantes) {
		this.listaFabricantes = listaFabricantes;
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

}
