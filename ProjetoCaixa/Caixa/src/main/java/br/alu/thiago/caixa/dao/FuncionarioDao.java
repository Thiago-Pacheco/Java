package br.alu.thiago.caixa.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.alu.thiago.caixa.domain.Funcionario;
import br.alu.thiago.caixa.util.HibernateUtil;

public class FuncionarioDao implements InterFuncionario{

	@Override
	public void salvar(Funcionario funcionario) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();

			sessao.save(funcionario);

			transacao.commit();

		} catch (RuntimeException re) {

			if (transacao != null) {

				transacao.rollback();
			}

			throw re;

		} finally {

			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> listar() {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		List<Funcionario> funcionarios = null;

		Query consulta = null;

		try {

			consulta = sessao.getNamedQuery("Funcionario.listar");

			funcionarios = consulta.list();

		} catch (RuntimeException re) {

			throw re;

		} finally {

			sessao.close();
		}

		return funcionarios;
	}

	@Override
	public Funcionario buscarPorCodigo(Long codigo) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Funcionario funcionario = null;

		try {

			Query consulta = sessao.getNamedQuery("Funcionario.buscarPorCodigo");

			consulta.setLong("codigo", codigo);

			funcionario = (Funcionario) consulta.uniqueResult();

		} catch (RuntimeException re) {

			throw re;

		} finally {

			sessao.close();
		}

		return funcionario;
	}

	@Override
	public void excluir(Funcionario funcionario) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();

			sessao.delete(funcionario);

			transacao.commit();

		} catch (RuntimeException re) {

			if (transacao != null) {

				transacao.rollback();
			}

			throw re;

		} finally {

			sessao.close();
		}
	}

	@Override
	public void editar(Funcionario funcionario) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();

			sessao.update(funcionario);

			transacao.commit();

		} catch (RuntimeException re) {

			if (transacao != null) {

				transacao.rollback();
			}

			throw re;

		} finally {

			sessao.close();
		}
		
	}

	@Override
	public Funcionario autenticar(String cpf, String senha) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		Funcionario funcionario = null;
		
		try {
			
			Query consulta = sessao.getNamedQuery("Funcionario.autenticar");

			consulta.setString("cpf", cpf);
			
			consulta.setString("senha", senha);
			
			funcionario = (Funcionario) consulta.uniqueResult();
			
		} catch (RuntimeException re) {
			
			throw re;
			
		}finally {

			sessao.close();
		}
		
		return funcionario;
	}

}
