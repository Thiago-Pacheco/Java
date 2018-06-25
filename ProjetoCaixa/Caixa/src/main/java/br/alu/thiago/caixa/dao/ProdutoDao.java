package br.alu.thiago.caixa.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.alu.thiago.caixa.domain.Produto;
import br.alu.thiago.caixa.util.HibernateUtil;

public class ProdutoDao implements InterProduto{

	@Override
	public void salvar(Produto produto) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;
		
		try {

			transacao = sessao.beginTransaction();

			sessao.save(produto);

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
	public List<Produto> listar() {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		List<Produto> produtos = null;

		Query consulta = null;

		try {

			consulta = sessao.getNamedQuery("Produto.listar");

			produtos = consulta.list();

		} catch (RuntimeException re) {

			throw re;

		} finally {

			sessao.close();
		}

		return produtos;
	}

	@Override
	public Produto buscarPorCodigo(Long codigo) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Produto produto = null;

		try {

			Query consulta = sessao.getNamedQuery("Produto.buscarPorCodigo");

			consulta.setLong("codigo", codigo);

			produto = (Produto) consulta.uniqueResult();

		} catch (RuntimeException re) {

			throw re;

		} finally {

			sessao.close();
		}

		return produto;
	}

	@Override
	public void excluir(Produto produto) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;
		
		try {

			transacao = sessao.beginTransaction();

			sessao.delete(produto);

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
	public void editar(Produto produto) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;
		
		try {

			transacao = sessao.beginTransaction();

			sessao.update(produto);

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

}
