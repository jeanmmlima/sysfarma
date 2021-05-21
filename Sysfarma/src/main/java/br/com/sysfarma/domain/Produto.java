package br.com.sysfarma.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Produto extends GenericDomain{
	
	@Column(length=80,nullable=false)
	private String descricao;
	
	//inteiro que vai de -32000 a +32000 -> SHORT
	//short, int e long --> Primitivos com padrão ZERO
	//SHORT, INT, LONG --> Padrão NULO
	// NULO - Usuario nao digitou, ZERO - digitou
	
	@Column(nullable=false)
	private Short quantidade;
	
	//BigDecimal melhor pra arredondamento com casas decimais.
	//Precision: Total de digitos antes e depois da virgula
	//Scale: Numeros DEPOIS da virgula
	//9.999,99 a 0
	
	@Column(nullable=false,precision=6,scale=2)
	private BigDecimal preco;
	
	//MUITOS produtos UM fabricante
	@ManyToOne
	@JoinColumn(nullable=false)
	private Fabricante fabricante;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	
}
