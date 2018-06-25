package br.alu.thiago.caixa.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.alu.thiago.caixa.domain.Item;
import br.alu.thiago.caixa.util.HibernateUtil;

public class ItemDao implements InterItem{

	@Override
	public void salvar(Item item) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();

			sessao.save(item);

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
	public List<Item> listar() {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		List<Item> itens = null;

		Query consulta = null;

		try {

			consulta = sessao.getNamedQuery("Item.listar");

			itens = consulta.list();

		} catch (RuntimeException re) {

			throw re;

		} finally {

			sessao.close();
		}

		return itens;

	}

	@Override
	public Item buscarPorCodigo(Long codigo) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Item item = null;

		try {

			Query consulta = sessao.getNamedQuery("Item.buscarPorCodigo");

			consulta.setLong("codigo", codigo);

			item = (Item) consulta.uniqueResult();

		} catch (RuntimeException re) {

			throw re;

		} finally {

			sessao.close();
		}

		return item;

	}

}
