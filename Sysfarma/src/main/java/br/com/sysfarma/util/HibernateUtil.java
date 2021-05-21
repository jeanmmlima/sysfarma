package br.com.sysfarma.util;

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
    		//Configuration.configure -> serve para ler o arquivo hibernate.cfg.xml 
    		Configuration configuracao = new Configuration().configure();
    		//Registro de Serviço Passando as Configurações
    		ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
    		
    		//Agora é possível construir a fábrica de sessões
    		SessionFactory fabrica = configuracao.buildSessionFactory();
    		
    		//Por fim, retorna a fábrica
    		return fabrica;
    	}
    	catch(Throwable ex){
    		System.err.println("Criacao da fabrica de Sessão falhou!" + ex);
    		throw new ExceptionInInitializerError(ex);
    	}
    }
}
