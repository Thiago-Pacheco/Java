package br.alu.thiago.caixa.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();
	
	public static SessionFactory getFabricaDeSessoes() {
				
		return fabricaDeSessoes;
				
	}
	
	private static SessionFactory criarFabricaDeSessoes() {
		
		try {
			
			Configuration configuracao = new Configuration().configure();
			
			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
			
			SessionFactory fabrica = configuracao.buildSessionFactory(registro);
			
			return fabrica;
			
		} catch (Throwable th) {
			
			System.out.println("Sessao nao criada" + th);
			
			throw new ExceptionInInitializerError(th);
			
			
		}
	}
}
