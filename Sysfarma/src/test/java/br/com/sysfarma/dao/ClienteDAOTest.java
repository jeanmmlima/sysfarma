package br.com.sysfarma.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sysfarma.domain.Cidade;
import br.com.sysfarma.domain.Cliente;
import br.com.sysfarma.domain.Pessoa;

public class ClienteDAOTest {
	
	@Test
	public void salvar() throws ParseException {
		Cliente cliente = new Cliente(); 
		ClienteDAO clienteDAO = new ClienteDAO();
		
		//Criando Pessoa
		Pessoa pessoa = new Pessoa();
		PessoaDAO pessoaDAO = new PessoaDAO();
		Long codigoCidade = 6L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		pessoa.setNome("José Maria");
		pessoa.setBairro("Vila");
		pessoa.setCelular("(84)9788-8888");
		pessoa.setCep("59280000");
		pessoa.setCidade(cidade);
		pessoa.setCpf("011.123.94-00");
		pessoa.setEmail("jmaria@gmal.com");
		pessoa.setNumero((short) 14);
		pessoa.setRg("032.154.156");
		pessoa.setRua("Planalto");
		pessoa.setTelefone("(84)3271-1000");
		pessoaDAO.salvar(pessoa);
		
		System.out.println("Cadastrdo de Pessoa: ");
		System.out.println(pessoa.getNome()+" - "+pessoa.getCidade().getNome()+"/"+pessoa.getCidade().getEstado().getSigla());
		
		//Cadastrando Cliente
		
		cliente.setPessoa(pessoa);
		cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("08/10/2018")); //Date do java.util
		cliente.setLiberado(true);
		
		clienteDAO.salvar(cliente);
		
		System.out.println("Cliente cadastrado!");
		System.out.println(cliente.getPessoa().getNome()+" - "+cliente.getDataCadastro()+" - Status: "+cliente.getLiberado());
		
	}
	@Ignore
	@Test
	public void excluir() {
		Long codigo = 1L;
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);
		
		if (cliente == null) {
			System.out.println("Registro não encontrado");
		} else {
			clienteDAO.excluir(cliente);
			System.out.println("Registro Removido!");
		}
		
	}
	
	@Test
	public void buscar() {
		Long codigo = 1L;
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);
		
		if (cliente == null) {
			System.out.println("Registro não encontrado");
		} else {
			System.out.println("Registro Encontrado!");
		}
		
	}
	
	

}
