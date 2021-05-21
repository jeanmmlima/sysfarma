package br.com.sysfarma.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sysfarma.domain.Cidade;
import br.com.sysfarma.domain.Estado;

public class CidadeDAOTest {
	@Ignore
	@Test
	public void salvar() {

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(2L);
		
		Cidade cidade = new Cidade();
		cidade.setNome("São Paulo");
		cidade.setEstado(estado);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);
		
		
	}
	@Ignore
	@Test
	public void listar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> cidades = cidadeDAO.listar();
		
		System.out.println("Total de Registros: "+cidades.size());
		
		for(Cidade cidade : cidades){
			System.out.println("Código: "+cidade.getCodigo()+ " - "+cidade.getNome()+"/"+cidade.getEstado().getSigla());
		}
	}
	@Ignore
	@Test
	public void buscar() {
		Long codigo = 2L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);

		System.out.println("Código: "+cidade.getCodigo()+ " - "+cidade.getNome()+"/"+cidade.getEstado().getSigla());
		
	}
	@Ignore
	@Test
	public void editar(){
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(2L);
		
		if(cidade == null) {
			System.out.println("Registro Não Encontrado");
		} else {
			cidade.setNome("Rio de Janeiro");
			EstadoDAO estadoDAO = new EstadoDAO();
			Estado estado = estadoDAO.buscar(3L);
			cidade.setEstado(estado);
			cidadeDAO.editar(cidade);
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(4L);
		
		if(cidade == null) {
			System.out.println("Registro Não Encontrado");
		} else {
			cidadeDAO.excluir(cidade);
			System.out.println("Registro Excluído com Sucesso!");
		}
	}
	
	@Test
	public void buscarPorEstado() {
		Long estadoCodigo = 7L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> cidades = cidadeDAO.buscaPorEstado(estadoCodigo);
		
		System.out.println("Total de Registros: "+cidades.size());
		
		for(Cidade cidade : cidades){
			System.out.println("Código: "+cidade.getCodigo()+ " - "+cidade.getNome()+"/"+cidade.getEstado().getSigla());
		}
	}
}
