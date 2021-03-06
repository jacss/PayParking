package br.com.projetointegrador.telas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import br.com.projetointegrador.dao.PrecoDao;
import br.com.projetointegrador.modelo.Preco;
import br.com.projetointegrador.util.GUIUtil;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class TeleCadPreco extends JInternalFrame {
	private JTextField textValor;
	private JTextField textTempoPerm;
	private JCheckBox chckbxEstraviado;
	private JCheckBox chckbxFracionado;
	private JCheckBox chckbxTolerancia ;
	private Preco obj = new Preco();
	private PrecoDao dao = new PrecoDao();

	private JTable table;
	private List<Preco> list = new ArrayList<Preco>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeleCadPreco frame = new TeleCadPreco();
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
	public TeleCadPreco() {
		setTitle("Tabela de Pre\u00E7os");
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(-10, 0, 567, 500);
		getContentPane().setLayout(null);

		// GUIUtil.setLookAndFeel(this);// Colocando a aparencia do Windows
		GUIUtil.center(this);

		JLabel lblValor = new JLabel("Valor R$");
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblValor.setBounds(36, 40, 57, 24);
		getContentPane().add(lblValor);

		textValor = new JTextField();
		textValor.setBounds(36, 65, 86, 20);
		getContentPane().add(textValor);
		textValor.setColumns(10);

		JLabel lblTempoPermanncia = new JLabel("Tempo Perman\u00EAncia");
		lblTempoPermanncia.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTempoPermanncia.setBounds(143, 40, 132, 24);
		getContentPane().add(lblTempoPermanncia);

		textTempoPerm = new JTextField();
		textTempoPerm.setBounds(143, 65, 132, 20);
		getContentPane().add(textTempoPerm);
		textTempoPerm.setColumns(10);

		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (validarCampos()) {
						if (preencherObjeto()) {
							if (chckbxEstraviado.isSelected()) {
								Preco preco = dao.getPrecoTicketPerdido();

								if (preco == null) {
									if (dao.salvar(obj)) {
										JOptionPane.showMessageDialog(null, "Orepa��o realizada com sucesso!!");
										atualizaJTable();
										limparCampos();

									}
								} else {
									obj.setId_preco(preco.getId_preco());
									//System.out.println("iD1 " + obj.getId_preco());
									if (dao.update(obj)) {

										JOptionPane.showMessageDialog(null, "Orepa��o realizada com sucesso!!");
										atualizaJTable();
									limparCampos();

									}
								}

							} else {

								if (chckbxFracionado.isSelected()) {
									Preco preco = dao.getPrecoTicketFracionado();

									if (preco == null) {
										if (dao.salvar(obj)) {
											
											JOptionPane.showMessageDialog(null, "Orepa��o realizada com sucesso!!");
											atualizaJTable();
											limparCampos();

										}
									} else {
										obj.setId_preco(preco.getId_preco());
										

										if (dao.update(obj)) {

											JOptionPane.showMessageDialog(null, "Orepa��o realizada com sucesso!!");
											atualizaJTable();
											limparCampos();

										}
									}

								}else{
									if(chckbxTolerancia.isSelected()){
										Preco preco = dao.getPrecoTicketTolerancia();

										if (preco == null) {
											if (dao.salvar(obj)) {
												
												JOptionPane.showMessageDialog(null, "Orepa��o realizada com sucesso!!");
												atualizaJTable();
												limparCampos();

											}
										
									}else{
										obj.setId_preco(preco.getId_preco());
										System.out.println("iD1 " + obj.getId_preco());
										if (dao.update(obj)) {

											JOptionPane.showMessageDialog(null, "Orepa��o realizada com sucesso!!");
											atualizaJTable();
											limparCampos();

										}
									}
										
									}
								}
							}

						}

					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}

			}
		});
		btnGravar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGravar.setBounds(117, 142, 79, 23);
		getContentPane().add(btnGravar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					preencherCampos();
					if (dao.deletar(obj.getId_preco())) {
						JOptionPane.showMessageDialog(null, "Registro Removido com sucesso");
						atualizaJTable();
						limparCampos();
					}

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

			}
		});
		btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeletar.setBounds(234, 142, 79, 23);
		getContentPane().add(btnDeletar);

		JButton btnNewButton = new JButton("Novo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(345, 142, 71, 23);
		getContentPane().add(btnNewButton);

		chckbxEstraviado = new JCheckBox("Ticket Extraviado");
		chckbxEstraviado.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxEstraviado.setBounds(392, 63, 135, 23);
		getContentPane().add(chckbxEstraviado);

		chckbxFracionado = new JCheckBox("Fracionado");
		chckbxFracionado.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxFracionado.setBounds(392, 41, 97, 23);
		getContentPane().add(chckbxFracionado);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setBounds(36, 176, 484, 81);
		getContentPane().add(scrollPane);

		table = new JTable();
		//table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				obj = list.get(table.getSelectedRow());
				preencherCampos();
			}
		});

		try {
			atualizaJTable();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		scrollPane.setViewportView(table);
		
		chckbxTolerancia = new JCheckBox("Tolerancia");
		chckbxTolerancia.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxTolerancia.setBounds(392, 83, 108, 23);
		getContentPane().add(chckbxTolerancia);

	}

	private void atualizaJTable() throws Exception {

		list = dao.todososPrecos();

		Object[][] dados = new Object[list.size()][5];

		for (int i = 0; i < dados.length; i++) {
			dados[i][0] = list.get(i).getTempo();
			dados[i][1] = list.get(i).getValor();
			dados[i][2] = list.get(i).isPerca() ? "Sim" : "N�o";
			dados[i][3] = list.get(i).isFracionado() ? "Sim" : "N�o";
			dados[i][4] = list.get(i).isTolerancia()? "Sim" : "N�o";

		}

		table.setModel(new DefaultTableModel(
				dados,
			new String[] {
				"Tempo Permanencia", "Valor", "Perca", "Fracionado","Tolerancia"
			}
		));

	}

	public boolean validarCampos() {
		if (textValor.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo valor!!");
			textValor.requestFocus();
			return false;
		}
		if (textTempoPerm.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo Perman�ncia!!");
			textTempoPerm.requestFocus();
			return false;

		}
		return true;
	}

	public boolean preencherObjeto() throws Exception {
		obj.setValor(Double.parseDouble(textValor.getText()));
		obj.setTempo(textTempoPerm.getText());
		obj.setPerca(chckbxEstraviado.isSelected());
		obj.setFracionado(chckbxFracionado.isSelected());
		obj.setTolerancia(chckbxTolerancia.isSelected());
		return true;

	}

	public void preencherCampos() {
		textValor.setText("" + obj.getValor());
		textTempoPerm.setText(obj.getTempo());
		chckbxEstraviado.setSelected(obj.isPerca());
		chckbxFracionado.setSelected(obj.isFracionado());
		chckbxTolerancia.setSelected(obj.isTolerancia());

	}

	public void limparCampos() {
		textValor.setText("");
		textTempoPerm.setText("");
		chckbxEstraviado.setSelected(false);
		obj = null;
		obj = new Preco();
	}
}
