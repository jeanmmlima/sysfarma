package br.com.sysfarma.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.sysfarma.dao.CidadeDAO;
import br.com.sysfarma.dao.EstadoDAO;
import br.com.sysfarma.dao.FabricanteDAO;
import br.com.sysfarma.dao.ProdutoDAO;
import br.com.sysfarma.domain.Cidade;
import br.com.sysfarma.domain.Fabricante;
import br.com.sysfarma.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable{
	
	private Produto produto;
	private List<Produto> produtos;
	private List<Fabricante> fabricantes;
	
	public void novo() {
		try{ 
			produto = new Produto();
			
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu erro ao tentar listar Produtos!");
			erro.printStackTrace();
		}
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	@PostConstruct
	public void listar() {
		try {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtos = produtoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu erro ao tentar listar Produto!");
			erro.printStackTrace();
		}
	}
	
	public void salvar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.merge(produto);
			
			produto = new Produto();
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listar();
			
			
			produtos = produtoDAO.listar();
			
			Messages.addFlashGlobalInfo("Produto criada com sucesso!");

		} catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu erro ao tentar salvar Produto!");
			//Imprime pilha de erro no LOG do servidor
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) {
		//.get("name") name do componente f:attibute
		try {
			produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.excluir(produto);
			produtos = produtoDAO.listar();
			Messages.addGlobalInfo("Produto exclu??da com sucesso!");
			
		} catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu erro ao tentar excluir Produto!");
			erro.printStackTrace();
		}
		
	}
	
	public void editar(ActionEvent evento) {
		
		try{ 
			produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");	
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu erro ao tentar selecionar uma produto!");
			erro.printStackTrace();
		}
		
	}
}
