package br.com.projetointegrador.telas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import br.com.projetointegrador.dao.FormaPagamentoDao;
import br.com.projetointegrador.modelo.FormaPagamento;
import br.com.projetointegrador.util.GUIUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class TelaFormaPagamento extends JInternalFrame {
	private JTextField textForma;
	private FormaPagamento obj = new FormaPagamento();
	private FormaPagamentoDao dao = new FormaPagamentoDao();
	private JTable table;
	private List<FormaPagamento> list = new ArrayList<>();

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
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		setTitle("Forma de Pagamento");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(-10, 0, 567, 500);
		//GUIUtil.setLookAndFeel(this);
		GUIUtil.center(this);
		getContentPane().setLayout(null);

		JLabel lblFormaDePagamento = new JLabel("Forma de Pagamento");
		lblFormaDePagamento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFormaDePagamento.setBounds(51, 69, 136, 14);
		getContentPane().add(lblFormaDePagamento);

		textForma = new JTextField();
		textForma.setBounds(51, 91, 184, 20);
		getContentPane().add(textForma);
		textForma.setColumns(10);

		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (validarCampos()) {
						if (preencherObjeto()) {
							if (dao.salvar(obj)) {
								JOptionPane.showMessageDialog(null, "Registro inserido com sucesso");
								limpaCampos();
								atualizaJTable();

							}
						}

					}

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

			}
		});
		btnGravar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGravar.setBounds(116, 140, 89, 23);
		getContentPane().add(btnGravar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 174, 446, 207);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				obj = list.get(table.getSelectedRow());
				preencherCampos();
			}
		});
		try {
			atualizaJTable();

		} catch (Exception e) {
			// TODO: handle exception
		}

		scrollPane.setViewportView(table);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validarCampos();
				try {

					preencherCampos();
					if (dao.deletar(obj.getId_forma())) {
						JOptionPane.showMessageDialog(null, "Registro removido com sucesso!!");
						atualizaJTable();
						limpaCampos();
					}

				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		});
		btnDeletar.setBounds(231, 141, 89, 23);
		getContentPane().add(btnDeletar);

		JButton btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpaCampos();
			}
		});
		btnNovo.setBounds(341, 141, 89, 23);
		getContentPane().add(btnNovo);

	}

	public void atualizaJTable() throws Exception {
		list = dao.todasFormas();

		Object[][] dados = new Object[list.size()][1];
		for (int i = 0; i < dados.length; i++) {
			dados[i][0] = list.get(i).getDescricao();

		}
		table.setModel(new DefaultTableModel(
				dados,
			new String[] {
				"Descri\u00E7\u00E3o"
			}
		));

	}

	public boolean preencherObjeto() throws Exception {
		obj.setDescricao(textForma.getText());

		return true;

	}

	public boolean validarCampos() {
		if (textForma.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo obrigatorio!!");
			textForma.requestFocus();
			return false;
		}

		return true;
	}

	public void limpaCampos() {
		textForma.setText("");
		obj = null;
		obj = new FormaPagamento();
	}

	public void preencherCampos() {
		textForma.setText(obj.getDescricao());

	}

}
