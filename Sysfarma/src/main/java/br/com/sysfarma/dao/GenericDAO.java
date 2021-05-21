package br.com.sysfarma.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.sysfarma.util.HibernateUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;

//Data Access genérico <QUALQUER_NOME> no diamante --> representa uma entidade
//Na pratica, <nome> será substituido pelo NOME de VERDADE da Entidade
public class GenericDAO<Entidade> {

	// Toda vez que o DAO for instanciado, classe deve descrobrir com a Entidade
	//Necessario para LISTAR/BUSCAR genericos
	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void salvar(Entidade entidade) {
		// Capturar sessão abertas
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		// Usar TRANSACTIONS para garantir que as opeçãos sejam feitas!
		// Ex: Tirar dinheiro de uma conta e colcoar em outra. Só é bem sucessidade se
		// as DUAS operações são feitas
		Transaction transacao = null;

		try {
			// Abre a transacao
			transacao = sessao.beginTransaction();
			// Salva
			sessao.save(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			// Se transacao DIFERENTE de NULA, houve tentativa de transação mas deu erro,
			// logo: chamar o ROLLBACK!
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> listar(){
		//Abre a sessao
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		//Nao preciso de TRANSACTIONS em pesquisas
		
		try {
			//Trabalhando com Criteria
			Criteria consulta = sessao.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> listar(String campoOrdenacao){
		//Abre a sessao
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		//Nao preciso de TRANSACTIONS em pesquisas
		
		try {
			//Trabalhando com Criteria
			Criteria consulta = sessao.createCriteria(classe);
			consulta.addOrder(Order.asc(campoOrdenacao));
			List<Entidade> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Entidade buscar(Long codigo){
		//Abre a sessao
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		//Nao preciso de TRANSACTIONS em pesquisas
		
		try {
			//Trabalhando com Criteria
			Criteria consulta = sessao.createCriteria(classe);
			//Restricao na consulta - via codigo (id Equal)
			consulta.add(Restrictions.idEq(codigo));
			Entidade resultado = (Entidade) consulta.uniqueResult();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	//Identico ao salvar
	public void excluir(Entidade entidade) {
		// Capturar sessão abertas
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		// Usar TRANSACTIONS para garantir que as opeçãos sejam feitas!
		// Ex: Tirar dinheiro de uma conta e colcoar em outra. Só é bem sucessidade se
		// as DUAS operações são feitas
		Transaction transacao = null;

		try {
			// Abre a transacao
			transacao = sessao.beginTransaction();
			// Salva
			sessao.delete(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			// Se transacao DIFERENTE de NULA, houve tentativa de transação mas deu erro,
			// logo: chamar o ROLLBACK!
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}

	}
	
	public void editar(Entidade entidade) {
		// Capturar sessão abertas
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		// Usar TRANSACTIONS para garantir que as opeçãos sejam feitas!
		// Ex: Tirar dinheiro de uma conta e colcoar em outra. Só é bem sucessidade se
		// as DUAS operações são feitas
		Transaction transacao = null;

		try {
			// Abre a transacao
			transacao = sessao.beginTransaction();
			// Salva
			sessao.update(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			// Se transacao DIFERENTE de NULA, houve tentativa de transação mas deu erro,
			// logo: chamar o ROLLBACK!
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}

	}
	
	public void merge(Entidade entidade) {
		// Capturar sessão abertas
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		// Usar TRANSACTIONS para garantir que as opeçãos sejam feitas!
		// Ex: Tirar dinheiro de uma conta e colcoar em outra. Só é bem sucessidade se
		// as DUAS operações são feitas
		Transaction transacao = null;

		try {
			// Abre a transacao
			transacao = sessao.beginTransaction();
			// Salva
			sessao.merge(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			// Se transacao DIFERENTE de NULA, houve tentativa de transação mas deu erro,
			// logo: chamar o ROLLBACK!
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}

	}
	

}
