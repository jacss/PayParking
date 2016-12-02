package br.com.projetointegrador.modelo;

public class FormaPagamento {
	private String descricao;
	private int id_forma;
	
	
	public FormaPagamento(){
		
	}


	public FormaPagamento( int id_forma, String descricao) {
		super();
		this.id_forma = id_forma;
		this.descricao = descricao;
		
	}


	public int getId_forma() {
		return id_forma;
	}


	public void setId_forma(int id_forma) {
		this.id_forma = id_forma;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	@Override
	public String toString() {
		return  descricao ;
	}
	

}
