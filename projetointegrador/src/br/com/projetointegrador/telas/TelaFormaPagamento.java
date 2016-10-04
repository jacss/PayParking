package br.com.projetointegrador.telas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import br.com.projetointegrador.dao.FormaPagamentoDao;
import br.com.projetointegrador.modelo.FormaPagamento;
import br.com.projetointegrador.util.GUIUtil;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaFormaPagamento extends JInternalFrame {
	/**
	 * @wbp.nonvisual location=59,-11
	 */
	private final JCheckBox checkBox = new JCheckBox("New check box");
	private JTextField textForma;
    private FormaPagamento obj = new FormaPagamento();
    private FormaPagamentoDao dao = new FormaPagamentoDao();
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFormaPagamento frame = new TelaFormaPagamento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaFormaPagamento() {
		setTitle("Forma de Pagamento");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 100, 567, 284);
		GUIUtil.setLookAndFeel(this);
		GUIUtil.center(this);
		getContentPane().setLayout(null);
		
		JLabel lblFormaDePagamento = new JLabel("Forma de Pagamento");
		lblFormaDePagamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFormaDePagamento.setBounds(51, 69, 136, 14);
		getContentPane().add(lblFormaDePagamento);
		
		textForma = new JTextField();
		textForma.setBounds(51, 91, 184, 20);
		getContentPane().add(textForma);
		textForma.setColumns(10);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validarCampos();
				try {
					preencherObjeto();
					if(dao.inserir(obj)){
						JOptionPane.showMessageDialog(null, "Registro inserido com sucesso");
						limpaCampos();
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGravar.setBounds(51, 141, 89, 23);
		getContentPane().add(btnGravar);

	}
	
	public boolean preencherObjeto(){
		obj.setDescricao(textForma.getText());
		
		return true;
		
	}
	public boolean validarCampos(){
		if(textForma.equals("")){
			JOptionPane.showMessageDialog(null, "Preencha o campo obrigatorio!!");
			textForma.requestFocus();
			return false;
		}
			
			return true;
	}
	public void limpaCampos(){
		textForma.setText("");
	}
}
