package br.com.sysfarma.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.sysfarma.dao.CidadeDAO;
import br.com.sysfarma.dao.EstadoDAO;
import br.com.sysfarma.dao.FabricanteDAO;
import br.com.sysfarma.dao.PessoaDAO;
import br.com.sysfarma.dao.ProdutoDAO;
import br.com.sysfarma.domain.Cidade;
import br.com.sysfarma.domain.Estado;
import br.com.sysfarma.domain.Pessoa;
import br.com.sysfarma.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {

	private Pessoa pessoa;
	private List<Pessoa> pessoas;

	private Estado estado;
	private List<Estado> estados;

	private List<Cidade> cidades;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void novo() {
		try {
			pessoa = new Pessoa();
			
			estado = new Estado();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar("nome");

			// CidadeDAO cidadeDAO = new CidadeDAO();
			// cidades = cidadeDAO.listar();
			cidades = new ArrayList<Cidade>();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao listar fabricantes");
			erro.printStackTrace();
		}

	}

	@PostConstruct
	public void listar() {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar("nome");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao listar pessoas!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.merge(pessoa);

			pessoas = pessoaDAO.listar("nome");

			novo();

			Messages.addFlashGlobalInfo("Pessoa salva com sucesso!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu erro ao tentar salvar Pessoa!");
			// Imprime pilha de erro no LOG do servidor
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.excluir(pessoa);
			pessoas = pessoaDAO.listar("nome");
			Messages.addGlobalInfo("Pessoa excluída com sucesso!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao excluir pessoa!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {

		try {
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu erro ao tentar selecionar uma pessoa!");
			erro.printStackTrace();
		}

	}

	public void popular() {
		try {
			if (estado != null) {
				CidadeDAO cidadeDAO = new CidadeDAO();
				cidades = cidadeDAO.buscaPorEstado(estado.getCodigo());
			} else {
				cidades = new ArrayList<Cidade>();
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu erro ao listar cidades!");
			erro.printStackTrace();
		}
	}

}
