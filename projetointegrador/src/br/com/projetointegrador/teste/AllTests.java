package br.com.projetointegrador.teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TicketControllerTest.class, TicketDaoTest.class })
public class AllTests {

}
