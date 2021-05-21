package br.com.sysfarma.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sysfarma.domain.Fabricante;

public class FabricanteDAOTest {

	@Ignore
	@Test
	public void listar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = fabricanteDAO.listar();
		
		System.out.println("Total de registros Encontrados: "+ resultado.size());
		
		for(Fabricante fabricante : resultado){
			System.out.println(fabricante.getDescricao());
		}
	}
	
	//Nao roda funcao com annotation Ignore
	@Ignore
	@Test
	public void salvar() {
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Neoquimica");
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);
	}
	
	@Ignore
	@Test
	public void buscar() {
		long codigo = 2L; //L pra dizer que é long
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		System.out.println(fabricante.getDescricao());
	}
	
	@Ignore
	@Test
	public void merge() {
		/*Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Fabricante A");
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.merge(fabricante);*/
		
		
		
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(1L);
		fabricante.setDescricao("Fabricante B");
		fabricanteDAO.merge(fabricante);
	}
	
}
