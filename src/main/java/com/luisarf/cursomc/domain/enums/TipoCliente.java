package com.luisarf.cursomc.domain.enums;

public enum TipoCliente {
	PESSOA_FISICA(1,"Pessoa Fisica"),
	PESSOA_JURIDICA(2,"Pessoa Juridica");

	private Integer cod;
	private String descricao;
	
	private TipoCliente(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getId() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

}
