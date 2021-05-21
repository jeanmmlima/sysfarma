package br.com.sysfarma.main;

import org.hibernate.Session;

import br.com.sysfarma.util.HibernateUtil;

//Classe para teste do Hibernate
public class HibernateUtilTeste {
	public static void main(String[] args) {
		//Capturar Sessao Aberta a partir da fábrica de Sessões
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}
}
