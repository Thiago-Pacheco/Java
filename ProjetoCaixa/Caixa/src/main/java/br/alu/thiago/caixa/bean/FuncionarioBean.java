package br.alu.thiago.caixa.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.alu.thiago.caixa.domain.Fachada;
import br.alu.thiago.caixa.domain.Funcionario;
import br.alu.thiago.caixa.util.FacesUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FuncionarioBean implements Serializable {

	private List<Funcionario> listaFuncionario;

	private String acao;

	private Long codigo;

	private Funcionario funcionario;

	private Fachada fachada;

	public FuncionarioBean() {

		this.fachada = Fachada.getInstancia();
		
		
	}
	
	public void novo() {
		
		this.funcionario = new Funcionario();
	}

	public void salvar() {

		try {

			this.fachada.salvarFuncionario(funcionario);

			this.funcionario = new Funcionario();

			FacesUtil.adicionarMsgInfo("Funcionario salvo com sucesso");

		} catch (RuntimeException re) {

			re.printStackTrace();

			FacesUtil.adicionarMsgError("Erro ao salvar um Funcionario" + re.getMessage());
		}
	}

	public void listarFuncionario() {

		try {

			this.listaFuncionario = this.fachada.listarFuncionario();

		} catch (RuntimeException re) {

			re.printStackTrace();

			FacesUtil.adicionarMsgError("Erro ao listar os funcionario" + re.getMessage());
		}
	}

	public void carregar() {

		try {

			if (this.codigo != null) {

				this.funcionario = this.fachada.buscarPorCodigoFuncionario(codigo);

			} else {

				this.funcionario = new Funcionario();
			}

		} catch (RuntimeException re) {

			FacesUtil.adicionarMsgError("Erro ao listar os funcionario" + re.getMessage());
		}
	}

	public void excluir() {

		try {

			this.fachada.excluirFuncionario(funcionario);

			FacesUtil.adicionarMsgInfo("Funcionario excluido com sucesso");

		} catch (RuntimeException re) {

			re.printStackTrace();

			FacesUtil.adicionarMsgError("Erro ao excluir um funcionario" + re.getMessage());
		}

	}

	public void editar() {

		try {

			this.fachada.editarFuncionario(funcionario);

			FacesUtil.adicionarMsgInfo("Funcionario editado com sucesso");

		} catch (RuntimeException re) {

			re.printStackTrace();

			FacesUtil.adicionarMsgError("Erro ao editar um funcionario" + re.getMessage());
		}

	}

	public List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}

	public void setListaFuncionario(List<Funcionario> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
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

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	
}
