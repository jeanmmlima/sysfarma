package br.com.sysfarma.util;

import org.hibernate.Session;
import org.junit.Test;

//Testes: Se retornar verde - OK!
public class HibernateUtilTest {
	@Test
	public void conectar() {
		//Teste se é possível conectar e desconectar do banco
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}
}
