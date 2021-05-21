package br.com.sysfarma.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sysfarma.domain.Estado;

public class EstadoDAOTest {
	@Ignore
	@Test
	public void listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();
		
		System.out.println("Total de registros Encontrados: "+ resultado.size());
		
		for(Estado estado : resultado){
			System.out.println(estado.getSigla() + " - "+estado.getNome());
		}
	}
	
	//Nao roda funcao com annotation Ignore
	@Ignore
	@Test
	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("Rio de Janeiro");
		estado.setSigla("RJ");
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}
	@Ignore
	@Test
	public void buscar() {
		long codigo = 2L; //L pra dizer que é long
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		System.out.println(estado.getSigla() + " - "+estado.getNome());
	}
	@Ignore
	@Test
	public void excluir() {
		long codigo = 5L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			estadoDAO.excluir(estado);
			System.out.println("Registro removido!");
			System.out.println(estado.getCodigo()+" - "+estado.getSigla());
		}
	}
	@Ignore
	@Test
	public void editar() {
		long codigo = 7L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			estado.setNome("Rio Grande do Sul");
			estadoDAO.editar(estado);
			System.out.println("Registro atualizado!");
		}
	}
}
