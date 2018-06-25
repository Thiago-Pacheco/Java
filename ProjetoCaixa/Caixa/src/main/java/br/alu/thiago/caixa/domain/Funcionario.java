package br.alu.thiago.caixa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@NamedQueries({
	@NamedQuery(name = "Funcionario.listar", query = "SELECT funcionario FROM Funcionario funcionario"),
	@NamedQuery(name = "Funcionario.buscarPorCodigo", query = "SELECT funcionario FROM Funcionario funcionario WHERE funcionario.codigo =:codigo"),
	@NamedQuery(name = "Funcionario.autenticar", query = "SELECT funcionario FROM Funcionario funcionario WHERE funcionario.cpf = :cpf AND funcionario.senha = :senha")
	})
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	
	@NotEmpty(message = "Campo nome obrigatorio")
	@Size(min = 5, max = 50, message = "Tamanho invalido")
	@Column(nullable = false, length = 50)
	private String nome;
	
	@CPF(message = "CPF invalido")
	@Column(nullable = false, length = 14)
	private String cpf;
	
	@NotEmpty(message = "Campo senha obrigatorio")
	@Size(min = 5, max = 50, message = "Tamanho invalido")
	@Column(nullable = false, length = 32)
	private String senha;
	
	@NotEmpty(message = "Campo funcao obrigatorio")
	@Column(nullable = false, length = 50)
	private String funcao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	
	@Override
	public String toString() {
		
		return "Funcionario [codigo=" + codigo + ", nome=" + nome + ", cpf="
		+ cpf + ", senha=" + senha + ", funcao=" + funcao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	
}
