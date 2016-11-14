package br.com.projetointegrador.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.projetointegrador.controller.TicketController;
import br.com.projetointegrador.modelo.Ticket;

public class TicketControllerTest {

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
	public void testaTicketGerado() {
		TicketController controller = new TicketController();
		Ticket ticket = controller.gerarTicket();
		
		assertNotNull(ticket.getCod_ticket());
	}

}
