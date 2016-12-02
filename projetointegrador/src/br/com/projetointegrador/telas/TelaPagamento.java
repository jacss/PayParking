package br.com.projetointegrador.telas;

import static org.junit.Assert.assertNotNull;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import br.com.projetointegrador.controller.TicketController;
import br.com.projetointegrador.dao.EfetuarPagamentoDAO;
import br.com.projetointegrador.dao.FormaPagamentoDao;
import br.com.projetointegrador.dao.PagamentoDAO;
import br.com.projetointegrador.dao.PrecoDao;
import br.com.projetointegrador.modelo.FormaPagamento;
import br.com.projetointegrador.modelo.Pagamento;
import br.com.projetointegrador.modelo.Preco;
import br.com.projetointegrador.modelo.Ticket;
import br.com.projetointegrador.util.DataDifer;
import br.com.projetointegrador.util.DataForm;
import br.com.projetointegrador.util.GUIUtil;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.fabric.xmlrpc.base.Data;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaPagamento extends JInternalFrame {
	private JTextField textTicket;
	private JTextField textHoraChegada;
	private JTextField textHoraSaida;
	private JTextField textPermanencia;
	private JTextField textTotalPagar;
	private JTextField textValorRecebido;
	private JTextField textTroco;
	private PagamentoDAO dao = new PagamentoDAO();
	private Ticket ticket = new Ticket();
	private JComboBox comboFormaPag = new JComboBox();
	private DataDifer dif = new DataDifer();
	private DataForm df = new DataForm();
	private JButton btnGerarTicket = new JButton("Gerar Ticket");
	private JCheckBox chckbxPerdeuTicket = new JCheckBox("Perdeu Ticket?");
     private PrecoDao daop = new PrecoDao();
     private Preco preco = new Preco();
     private String p;
     private List<FormaPagamento>listFormaPagamento = new ArrayList<>();
     private Pagamento pagamento = new Pagamento();
	/**
	 * Create the frame.
	 */
	public TelaPagamento() {
		setTitle("Pagamento");
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(0, 100, 567, 500);
		// GUIUtil.setLookAndFeel(this);
		GUIUtil.center(this);
		getContentPane().setLayout(null);

		JLabel lblTicket = new JLabel("Ticket");
		lblTicket.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTicket.setBounds(318, 292, 46, 14);
		getContentPane().add(lblTicket);

		textTicket = new JTextField();
		textTicket.setBounds(318, 317, 185, 20);
		getContentPane().add(textTicket);
		textTicket.setColumns(10);

		JLabel lblHoraChegada = new JLabel("Hora Chegada");
		lblHoraChegada.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHoraChegada.setBounds(34, 52, 94, 14);
		getContentPane().add(lblHoraChegada);

		textHoraChegada = new JTextField();
		textHoraChegada.setEditable(false);
		textHoraChegada.setBounds(34, 77, 175, 20);
		getContentPane().add(textHoraChegada);
		textHoraChegada.setColumns(10);

		JLabel lblHoraSaida = new JLabel("Hora Saida");
		lblHoraSaida.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHoraSaida.setBounds(318, 52, 74, 14);
		getContentPane().add(lblHoraSaida);

		textHoraSaida = new JTextField();
		textHoraSaida.setEditable(false);
		textHoraSaida.setBounds(318, 77, 185, 20);
		getContentPane().add(textHoraSaida);
		textHoraSaida.setColumns(10);

		JLabel lblPermanencia = new JLabel("Perman\u00EAncia");
		lblPermanencia.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPermanencia.setBounds(34, 119, 81, 14);
		getContentPane().add(lblPermanencia);

		textPermanencia = new JTextField();
		textPermanencia.setForeground(Color.RED);
		textPermanencia.setFont(new Font("Tahoma", Font.BOLD, 20));
		textPermanencia.setEditable(false);
		textPermanencia.setBounds(34, 142, 112, 48);
		getContentPane().add(textPermanencia);
		textPermanencia.setColumns(10);

		JLabel lblTotalAPagar = new JLabel("Total a Pagar R$");
		lblTotalAPagar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalAPagar.setBounds(34, 208, 112, 14);
		getContentPane().add(lblTotalAPagar);

		textTotalPagar = new JTextField();
		textTotalPagar.setForeground(Color.RED);
		textTotalPagar.setFont(new Font("Tahoma", Font.BOLD, 20));
		textTotalPagar.setEditable(false);
		textTotalPagar.setBounds(34, 233, 112, 48);
		getContentPane().add(textTotalPagar);
		textTotalPagar.setColumns(10);

		JLabel lblValorRecebido = new JLabel("Valor Recebido R$");
		lblValorRecebido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblValorRecebido.setBounds(318, 236, 126, 14);
		getContentPane().add(lblValorRecebido);

		textValorRecebido = new JTextField();
		textValorRecebido.addKeyListener(new KeyAdapter() {
			@Override
			
			public void keyPressed(KeyEvent arg0) {
				calculaTroco();
			}
		});
		textValorRecebido.setBounds(318, 261, 185, 20);
		getContentPane().add(textValorRecebido);
		textValorRecebido.setColumns(10);

		JLabel lblTroco = new JLabel("Troco R$");
		lblTroco.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTroco.setBounds(34, 292, 65, 14);
		getContentPane().add(lblTroco);

		textTroco = new JTextField();
		textTroco.setEditable(false);
		textTroco.setBounds(34, 317, 175, 20);
		getContentPane().add(textTroco);
		textTroco.setColumns(10);

		JButton btnEfetuarPagamento = new JButton("Pagar");
		btnEfetuarPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pagamento.setTicket(ticket);
				pagamento.setFormaPagamento((FormaPagamento) comboFormaPag.getSelectedItem());
			    pagamento.setPreco(preco);
			    pagamento.setTotalAPagar(Double.parseDouble(textTotalPagar.getText()));
			    pagamento.setValorRecebido(Double.parseDouble(textValorRecebido.getText()));
			    
			  EfetuarPagamentoDAO dao =new EfetuarPagamentoDAO();
			  
			  if(dao.salvar(pagamento)){
				  JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!!");
				  limpaCampos();
			  }else{
				  JOptionPane.showMessageDialog(null, "Não foi possivel salvar o registro!!");
			  }
			   
			   
			  }
		});
		btnEfetuarPagamento.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEfetuarPagamento.setBounds(35, 384, 93, 23);
		getContentPane().add(btnEfetuarPagamento);
		btnGerarTicket.setEnabled(false);
		btnGerarTicket.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGerarTicket.setBounds(384, 384, 119, 23);
		btnGerarTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				TicketController controller = new TicketController();
				Ticket ticket = controller.gerarTicket();				
				textTicket.setText(ticket.getCod_ticket());
				
				buscaTicket();
				

			}

		
		});
		getContentPane().add(btnGerarTicket);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpaCampos();

			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLimpar.setBounds(138, 384, 94, 23);
		getContentPane().add(btnLimpar);

		JButton btnPesquisarTicket = new JButton("Pesquisar Ticket");
		btnPesquisarTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				buscaTicket();

			}

		
		});
		btnPesquisarTicket.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPesquisarTicket.setBounds(242, 385, 132, 23);
		getContentPane().add(btnPesquisarTicket);

		JLabel lblFormaDePagamento = new JLabel("Forma de Pagamento");
		lblFormaDePagamento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFormaDePagamento.setBounds(318, 120, 152, 14);
		getContentPane().add(lblFormaDePagamento);

		
		FormaPagamentoDao dao = new FormaPagamentoDao();
	try {
		listFormaPagamento = dao.listaTodosFormas();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		for(FormaPagamento f:listFormaPagamento){
			comboFormaPag.addItem(f);
		}
		
		comboFormaPag.setBounds(318, 142, 185, 20);
		getContentPane().add(comboFormaPag);
		chckbxPerdeuTicket.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		chckbxPerdeuTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxPerdeuTicket.isSelected()){
					btnGerarTicket.setEnabled(true);
					
				}else{
					btnGerarTicket.setEnabled(false);
					
				}
			}
		});
		chckbxPerdeuTicket.setBounds(318, 177, 126, 23);
		getContentPane().add(chckbxPerdeuTicket);

	}

	public void preencherCampos() {

		textHoraChegada.setText("" + ticket.getHora_entrada());
		ticket.setHora_saida(new Date());
		Date d = new Date();

		try {
			String hs = DataForm.timeToString(ticket.getHora_saida());

			textHoraSaida.setText("" + hs);

			d = df.parseData(ticket.getData() + " " + ticket.getHora_entrada(), "yyyy-MM-dd HH:mm:ss");

			String diferencaHoras = df.diferencaEmHora(d.getTime(), ticket.getHora_saida().getTime());

			p = DataForm.timeToString(DataForm.parseData(diferencaHoras, "HH:mm:ss"));

			textPermanencia.setText("" + p);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		calculaTotal();
		

	}

	private void calculaTotal() {
		
		if (chckbxPerdeuTicket.isSelected()) {
			try {
				preco =daop.getPrecoTicketPerdido();
				textTotalPagar.setText(""+preco.getValor());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} else {
			try {
				String horacompleta= df.dateToString(df.parseData(p, "H:mm"), "H:mm");
				System.out.println("Hora completa: "+ horacompleta);
				
				String hora= df.dateToString(df.parseData(p, "H"), "H");
				System.out.println("Hora completa: "+ horacompleta);
				
				String minuto= df.dateToString(df.parseData(p, "mm"), "mm");
				System.out.println("Hora completa: "+ horacompleta);
				
				
				Integer horac = Integer.parseInt(hora);
				Integer minutoc = Integer.parseInt(minuto);
				
				PrecoDao dao = new PrecoDao();
				Preco preco = dao.getPrecoTicketFracionado();
				Float valorPorHora= (float) preco.getValor();
				
				Preco precot = dao.getPrecoTicketTolerancia();
				
				Integer tolerancia = Integer.parseInt(df.dateToString(df.parseData(precot.getTempo(), "mm"), "mm"));
				Integer somaMinutos= (horac*60)+minutoc;
				
				
				
				float totalHora= horac*valorPorHora;
				float totalMinuto= (valorPorHora/60)*minutoc;
				
				float totalGeral = totalHora+totalMinuto;
				textTotalPagar.setText(""+totalGeral);
				System.out.println("totalHora: "+ totalHora);
				System.out.println("totalMinuto : "+ totalMinuto);
				
			} catch (Exception   e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

	public boolean validaCampos() {
		if (textTicket.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o Campo Ticket!!");
			textTicket.requestFocus();
			return false;
		}

		return true;
	}

	public void limpaCampos() {
		textHoraChegada.setText("");
		textHoraSaida.setText("");
		textPermanencia.setText("");
		textTicket.setText("");
		textTotalPagar.setText("");
		textTroco.setText("");
		textValorRecebido.setText("");
		comboFormaPag.setSelectedItem(null);

	}
	private void buscaTicket() {
		validaCampos();

		ticket.setCod_ticket(textTicket.getText());
		ticket = dao.consultaTicket(ticket);

		preencherCampos();
		
	}
	public double calculaTroco( ){
		
		double valorRec = Double.parseDouble(textValorRecebido.getText());
		double totalApa = Double.parseDouble(textTotalPagar.getText());
		double troco = valorRec - totalApa;
		textTroco.setText(""+ Math.ceil(troco));
		
		return troco;
		
		}
	public void bucaValorFracionado(){
		try {
			double valor = daop.getPrecoFracionado().getValor();
			double total =(valor* Double.parseDouble(p));
			
			JOptionPane.showMessageDialog(null, total);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
