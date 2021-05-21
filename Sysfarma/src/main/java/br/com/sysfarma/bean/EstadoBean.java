package br.com.sysfarma.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.sysfarma.dao.EstadoDAO;
import br.com.sysfarma.domain.Estado;

//Mantem objetos vivos enquanto estão na tela!

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable{
	/*public void salvar() {
		String msg = "Programação Web com Java";
		//Tipo do erro, msg resumida, msg detalhada
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,msg,msg);
		
		FacesContext context = FacesContext.getCurrentInstance();
		//1parametro NULo 2p a messagem FM
		context.addMessage(null, message);
		
	}*/
	
	//Messages com OMNIFACES
	
	private Estado estado;
	
	//modelo da tabela estados
	private List<Estado> estados;
	
	public void novoEstado() {
		estado = new Estado();
	}
	
	public Estado getEstado() {
		return estado;
	}
	

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public List<Estado> getEstados() {
		return estados;
	}
	
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
		
	}
	

	public void salvar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.merge(estado);
			Messages.addGlobalInfo("Estado salvo com sucesso!");
			
			novoEstado();
			estados = estadoDAO.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu erro ao tentar salvar Estado!");
			//Imprime pilha de erro no LOG do servidor
			erro.printStackTrace();
		}
		
	}
	
	@PostConstruct
	public void listar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		} catch (RuntimeException erro){
			Messages.addGlobalError("Ocorreu erro ao tentar listar Estado!");
			erro.printStackTrace();
		}
		
	}
	
	//ActionEvent para capturar coisas da visao (xhtml)
	public void excluir(ActionEvent evento) {
		//.get("name") name do componente f:attibute
		try {
			estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.excluir(estado);
			estados = estadoDAO.listar();
			Messages.addGlobalInfo("Estado excluído com sucesso!");
			
		} catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu erro ao tentar excluir Estado!");
			erro.printStackTrace();
		}
		
	}
	
	//ActionEvent para capturar coisas da visao (xhtml)
	public void editar(ActionEvent evento) {
			//.get("name") name do componente f:attibute
		try {
			estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
			//EstadoDAO estadoDAO = new EstadoDAO();
			//estadoDAO.editar(estado);
			//estados = estadoDAO.listar();
				
		} catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu erro ao tentar excluir Estado!");
			erro.printStackTrace();
		}
			
	}
}
