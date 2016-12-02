package br.com.projetointegrador.controller;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.projetointegrador.codigobarra.CodigoBarraVerificador;
import br.com.projetointegrador.dao.TicketDao;
import br.com.projetointegrador.modelo.Ticket;

public class TicketController {
	
	
	/**
	 * momento inicial não existe usuario, ela é utilizada no botão da catraca ou no guiche no botão de gerar ticket caso
	 * o usuario tenha perdito o ticket
	 * @return
	 */
	public Ticket gerarTicket(){
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyhhmmss");
		Date data = new Date();
		
		Ticket ticket = new Ticket();
		ticket.setCod_ticket(CodigoBarraVerificador.codigoVerificador(format.format(data)));
		ticket.setData(data);
		ticket.setHora_entrada(new Time(data.getTime()));
		ticket.setHora_saida(null);
		ticket.setUsuario_cnpj_cpf(null);
		
		TicketDao dao = new TicketDao();
		dao.salvar(ticket);
		
		return ticket;
	}

	
	
	/**
	 * Futuramente será implementado para o momento que o usuario escnear o tecket no celular para pagamento
	 * @param cnpjCpf
	 * @return
	 */
	public Ticket gerarTicket(String cnpjCpf){
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyhhmmss");
		Date data = new Date();
		
		Ticket ticket = new Ticket();
		
		ticket.setHora_saida(null);
		ticket.setUsuario_cnpj_cpf(cnpjCpf);
		
		TicketDao dao = new TicketDao();
		dao.salvar(ticket);
		
		return ticket;
	}
}
