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
import br.com.sysfarma.domain.Cidade;
import br.com.sysfarma.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable{
	
	private Cidade cidade;
	
	private List<Cidade> cidades;
	private List<Estado> estados;
	
	public void novaCidade() {
		try{ 
			cidade = new Cidade();
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar("nome");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu erro ao tentar listar Estados!");
			erro.printStackTrace();
		}
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	@PostConstruct
	public void listar() {
		try {
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidades = cidadeDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu erro ao tentar listar Cidades!");
			erro.printStackTrace();
		}
	}
	
	public void salvar() {
		try {
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.merge(cidade);
			
			cidade = new Cidade();
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
			
			
			cidades = cidadeDAO.listar();
			
			Messages.addFlashGlobalInfo("Cidade criada com sucesso!");

		} catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu erro ao tentar salvar Estado!");
			//Imprime pilha de erro no LOG do servidor
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) {
		//.get("name") name do componente f:attibute
		try {
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionada");
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.excluir(cidade);
			cidades = cidadeDAO.listar();
			Messages.addGlobalInfo("Cidade excluída com sucesso!");
			
		} catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu erro ao tentar excluir Cidade!");
			erro.printStackTrace();
		}
		
	}
	
	public void editar(ActionEvent evento) {
		
		try{ 
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionada");	
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu erro ao tentar selecionar uma cidade!");
			erro.printStackTrace();
		}
		
	}
	
}
