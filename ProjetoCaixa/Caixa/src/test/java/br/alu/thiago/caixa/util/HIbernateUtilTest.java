package br.alu.thiago.caixa.util;

import org.hibernate.Session;
import org.junit.Test;

public class HIbernateUtilTest {

	@Test
	public void conectar() {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		sessao.close();
		
		HibernateUtil.getFabricaDeSessoes().close();
	}
}
