package br.com.projetointegrador.modelo;

import java.sql.Time;
import java.util.Date;

public class Ticket {
	private int id_ticket;
	private String cod_ticket;
	private Date data;
	private Time hora_entrada;
	private Date hora_saida;
	private String usuario_cnpj_cpf;
	
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ticket(int id_ticket, String cod_ticket, Date data, Time hora_entrada, Date hora_saida,
			String usuario_cnpj_cpf) {
		super();
		this.id_ticket = id_ticket;
		this.cod_ticket = cod_ticket;
		this.data = data;
		this.hora_entrada = hora_entrada;
		this.hora_saida = hora_saida;
		this.usuario_cnpj_cpf = usuario_cnpj_cpf;
	}

	public int getId_ticket() {
		return id_ticket;
	}

	public void setId_ticket(int id_ticket) {
		this.id_ticket = id_ticket;
	}

	public String getCod_ticket() {
		return cod_ticket;
	}

	public void setCod_ticket(String cod_ticket) {
		this.cod_ticket = cod_ticket;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora_entrada() {
		return hora_entrada;
	}

	public void setHora_entrada(Time hora_entrada) {
		this.hora_entrada = hora_entrada;
	}

	public Date getHora_saida() {
		return hora_saida;
	}

	public void setHora_saida(Date hora_saida) {
		this.hora_saida = hora_saida;
	}

	public String getUsuario_cnpj_cpf() {
		return usuario_cnpj_cpf;
	}

	public void setUsuario_cnpj_cpf(String usuario_cnpj_cpf) {
		this.usuario_cnpj_cpf = usuario_cnpj_cpf;
	}
	
	

}
