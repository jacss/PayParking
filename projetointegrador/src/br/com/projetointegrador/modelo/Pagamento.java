package br.com.projetointegrador.modelo;

public class Pagamento {
	private Ticket ticket;
	private FormaPagamento formaPagamento;
	private Preco preco;
	private double totalAPagar;
	private double valorRecebido;
	public Pagamento() {
		
		// TODO Auto-generated constructor stub
	}
	public Pagamento(Ticket ticket, FormaPagamento formaPagamento, Preco preco, double totalAPagar,
			double valorRecebido) {
		super();
		this.ticket = ticket;
		this.formaPagamento = formaPagamento;
		this.preco = preco;
		this.totalAPagar = totalAPagar;
		this.valorRecebido = valorRecebido;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public Preco getPreco() {
		return preco;
	}
	public void setPreco(Preco preco) {
		this.preco = preco;
	}
	public double getTotalAPagar() {
		return totalAPagar;
	}
	public void setTotalAPagar(double totalAPagar) {
		this.totalAPagar = totalAPagar;
	}
	public double getValorRecebido() {
		return valorRecebido;
	}
	public void setValorRecebido(double valorRecebido) {
		this.valorRecebido = valorRecebido;
	}
	
	

}
