package br.com.sysfarma.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

//Estado HERDA de GenericDOmain -> herdando chave primária para utilizá-la no estado
//É preciso dizer que Estado é um ENTIDADE do Hibernate através da anotação: @Entity do JAVAX.PERSISTENCE
//Assim o Hibernate vai criar uma TABELA com nome igual da classe, e COLUNAS com nomes iguais os ATRIBUTOS da classe
//Atributos: Codigo (herdado), sigla, nome
//Entidade precisa ser mapeada no hibernate.cfg

@SuppressWarnings("serial")
@Entity
public class Estado extends GenericDomain {
	//tamanho 2 para dados e nullable false --> NOT NUL 
	@Column(length=2, nullable=false)
	private String sigla;
	
	@Column(length=50, nullable=false)
	private String nome;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
