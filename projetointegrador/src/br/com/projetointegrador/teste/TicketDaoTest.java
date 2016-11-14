package br.com.projetointegrador.teste;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.projetointegrador.codigobarra.CodigoBarraVerificador;
import br.com.projetointegrador.dao.TicketDao;
import br.com.projetointegrador.modelo.Ticket;

public class TicketDaoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyhhmmss");

		Date data = new Date();

		Ticket ticket = new Ticket();
		ticket.setCod_ticket(CodigoBarraVerificador.codigoVerificador(format.format(data)));
		ticket.setData(data);
		ticket.setHora_entrada(data);
		ticket.setHora_saida(null);
		ticket.setUsuario_cnpj_cpf(null);

		TicketDao dao = new TicketDao();

		assertTrue(dao.salvar(ticket));
	}

}
