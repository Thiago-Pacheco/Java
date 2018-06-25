package br.alu.thiago.caixa.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.alu.thiago.caixa.domain.Venda;
import br.alu.thiago.caixa.util.HibernateUtil;

public class VendaDao implements InterVenda{

	@Override
	public Long salvar(Venda venda) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;
		
		Long codigo = null;

		try {

			transacao = sessao.beginTransaction();

			codigo = (Long) sessao.save(venda);

			transacao.commit();

		} catch (RuntimeException re) {

			if (transacao != null) {

				transacao.rollback();
			}

			throw re;

		} finally {

			sessao.close();
		}
		
		return codigo;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Venda> listar() {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		List<Venda> vendas = null;

		Query consulta = null;

		try {

			consulta = sessao.getNamedQuery("Venda.listar");

			vendas = consulta.list();

		} catch (RuntimeException re) {

			throw re;

		} finally {

			sessao.close();
		}

		return vendas;

	}

	@Override
	public Venda buscarPorCodigo(Long codigo) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Venda venda = null;

		try {

			Query consulta = sessao.getNamedQuery("Venda.buscarPorCodigo");

			consulta.setLong("codigo", codigo);

			venda = (Venda) consulta.uniqueResult();

		} catch (RuntimeException re) {

			throw re;

		} finally {

			sessao.close();
		}

		return venda;

	}

	@Override
	public void excluir(Venda venda) {
	
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();

			sessao.delete(venda);

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
	public void editar(Venda venda) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();
			
			sessao.update(venda);

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
