package br.com.sysfarma.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sysfarma.domain.Fabricante;
import br.com.sysfarma.domain.Produto;

public class ProdutoDAOTest {
	@Test
	public void salvar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Long codigoFabricante = 1L;
		
		Fabricante fabricante = fabricanteDAO.buscar(codigoFabricante);
		
		Produto produto = new Produto();
		produto.setDescricao("Cataflan 50mg com 20 comprimidos");
		//Preciso criar BIGDECIMAL
		produto.setPreco(new BigDecimal("13.70"));
		produto.setQuantidade((short) 50);
		produto.setFabricante(fabricante);
		
		produtoDAO.salvar(produto);
	}
	
	@Ignore
	@Test
	public void listar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> produtos = produtoDAO.listar();
		
		if(produtos != null) {
			System.out.println("Descrição: ");
			for(Produto produto : produtos) {
				System.out.println(produto.getDescricao());
			}
		} else {
			System.out.println("nenhum registro encontrado!");
		}
	}
	
	@Ignore
	@Test
	public void editar(){
		ProdutoDAO ProdutoDAO = new ProdutoDAO();
		Produto Produto = ProdutoDAO.buscar(1L);
		
		if(Produto == null) {
			System.out.println("Registro Não Encontrado");
		} else {
			Produto.setDescricao("Cataflan 100mg 20 comprimidos");
			Produto.setPreco(new BigDecimal("15.70"));
			ProdutoDAO.editar(Produto);
		}
	}
	@Ignore
	@Test
	public void excluir(){
		ProdutoDAO ProdutoDAO = new ProdutoDAO();
		Produto Produto = ProdutoDAO.buscar(1L);
		
		if(Produto == null) {
			System.out.println("Registro Não Encontrado");
		} else {
			ProdutoDAO.excluir(Produto);
		}
	}
	

}
