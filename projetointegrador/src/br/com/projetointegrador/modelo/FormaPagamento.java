package br.com.projetointegrador.modelo;

public class FormaPagamento {
	private String descricao;
	
	
	public FormaPagamento(){
		
	}


	public FormaPagamento(String descricao) {
		super();
		this.descricao = descricao;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
