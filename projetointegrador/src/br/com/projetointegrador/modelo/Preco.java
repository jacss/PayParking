package br.com.projetointegrador.modelo;

public class Preco {
	private int id_preco;
	private double valor;
	private boolean perca;
	private String tempo;
	private boolean fracionado;
	private boolean tolerancia;
	
	public Preco(){
		
	}

	

	public Preco(int id_preco, double valor, boolean perca, String tempo, boolean fracionado,boolean tolerancia) {
		super();
		this.id_preco = id_preco;
		this.valor = valor;
		this.perca = perca;
		this.tempo = tempo;
		this.fracionado = fracionado;
		this.tolerancia=tolerancia;
	}



	public int getId_preco() {
		return id_preco;
	}

	public void setId_preco(int id_preco) {
		this.id_preco = id_preco;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public boolean isPerca() {
		return perca;
	}

	public void setPerca(boolean perca) {
		this.perca = perca;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public boolean isFracionado() {
		return fracionado;
	}

	public void setFracionado(boolean fracionado) {
		this.fracionado = fracionado;
	}
	

	public boolean isTolerancia() {
		return tolerancia;
	}



	public void setTolerancia(boolean tolerancia) {
		this.tolerancia = tolerancia;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_preco;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Preco other = (Preco) obj;
		if (id_preco != other.id_preco)
			return false;
		return true;
	}
	
	
	
	

}
