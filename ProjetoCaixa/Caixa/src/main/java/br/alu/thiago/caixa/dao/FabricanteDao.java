package br.alu.thiago.caixa.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.alu.thiago.caixa.domain.Fabricante;
import br.alu.thiago.caixa.util.HibernateUtil;

public class FabricanteDao implements InterFabricante {

	@Override
	public void salvar(Fabricante fabricante) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();

			sessao.save(fabricante);

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
	public List<Fabricante> listar() {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		List<Fabricante> fabricantes = null;

		Query consulta = null;

		try {

			consulta = sessao.getNamedQuery("Fabricante.listar");

			fabricantes = consulta.list();

		} catch (RuntimeException re) {

			throw re;

		} finally {

			sessao.close();
		}

		return fabricantes;
	}

	@Override
	public Fabricante buscarPorCodigo(Long codigo) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Fabricante fabricante = null;

		try {

			Query consulta = sessao.getNamedQuery("Fabricante.buscarPorCodigo");

			consulta.setLong("codigo", codigo);

			fabricante = (Fabricante) consulta.uniqueResult();

		} catch (RuntimeException re) {

			throw re;

		} finally {

			sessao.close();
		}

		return fabricante;

	}

	@Override
	public void excluir(Fabricante fabricante) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();

			sessao.delete(fabricante);

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
	public void editar(Fabricante fabricante) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();
			
			sessao.update(fabricante);

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
