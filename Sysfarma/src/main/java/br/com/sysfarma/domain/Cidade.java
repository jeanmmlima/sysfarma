package br.com.sysfarma.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Cidade extends GenericDomain{
	
	@Column(length=50,nullable=false)
	private String nome;
	
	//Como dizer que o estado é chave estrangeira?
	//Utilizando anotações: one-to-many, one-to-one e many-to-one.
	//No caso de estado, MUITAS cidades pertencem a UM estado. (Many to One)

	
	//Mudando propriedades de colunas de chaves estrangeiras: JOIN COLUMN
	//Cidade é COMPOSTA por estado (losango escuro no diagram UML).
	//Logo estado NÃO PODE SER NULL
	@ManyToOne
	@JoinColumn(nullable=false)
	private Estado estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}
