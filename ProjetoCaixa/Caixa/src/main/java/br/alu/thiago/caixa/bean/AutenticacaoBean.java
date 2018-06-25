package br.alu.thiago.caixa.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.alu.thiago.caixa.domain.Fachada;
import br.alu.thiago.caixa.domain.Funcionario;
import br.alu.thiago.caixa.util.FacesUtil;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class AutenticacaoBean implements Serializable {

	private Funcionario funcionario;

	private Fachada fachada;

	public AutenticacaoBean() {

		this.fachada = Fachada.getInstancia();

	}

	public void logar() {

		try {

			this.funcionario = this.fachada.autenticar(this.funcionario.getCpf(), this.funcionario.getSenha());

			if (this.funcionario == null) {

				FacesUtil.adicionarMsgInfo("CPF ou senha invalido");

			} else {

				FacesUtil.adicionarMsgInfo("Logado com sucesso");
			}

		} catch (Exception e) {

			FacesUtil.adicionarMsgError("Erro ao logar");
		}
	}

	public String sair() {

		this.funcionario = null;

		return "/pages/autenticacao.xhtml?faces-redirect=true";
	}

	public Funcionario getFuncionario() {

		if (this.funcionario == null) {

			this.funcionario = new Funcionario();
		}

		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
