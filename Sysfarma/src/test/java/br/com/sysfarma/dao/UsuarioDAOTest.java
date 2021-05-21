package br.com.sysfarma.dao;

import org.junit.Test;

import br.com.sysfarma.domain.Pessoa;
import br.com.sysfarma.domain.Usuario;

public class UsuarioDAOTest {
	@Test
	public void salvar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);
		
		System.out.println("Pessoa Encontrada! Nome: "+pessoa.getNome());
		
		usuario.setAtivo(false);
		usuario.setPessoa(pessoa);
		usuario.setSenha("q1w2e3r4"); //sem criptografia ainda
		usuario.setTipo('A'); //A - Adm, G - Genrente, B - Balconista, C - Caixa
		
		usuarioDAO.salvar(usuario);
		
		System.out.println("Usuário salvo com sucesso!");
	}
}
