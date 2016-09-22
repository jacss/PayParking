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
	Preco obj;
	PrecoDao DAO = new PrecoDao();
	String acao = "";
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
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(0, 0, 567, 514);
		getContentPane().setLayout(null);
		GUIUtil.setLookAndFeel(this);// Colocando a aparencia do Windows
		GUIUtil.center(this);//centralizando a janela
		JLabel lblTabelaDePreos = new JLabel("Tabela de Pre\u00E7os");
		lblTabelaDePreos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTabelaDePreos.setBounds(185, 29, 171, 39);
		getContentPane().add(lblTabelaDePreos);

		JLabel lblValor = new JLabel("Valor R$");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValor.setBounds(36, 75, 57, 24);
		getContentPane().add(lblValor);

		textValor = new JTextField();
		textValor.setBounds(36, 98, 129, 20);
		getContentPane().add(textValor);
		textValor.setColumns(10);

		JLabel lblTempoPermanncia = new JLabel("Tempo Perman\u00EAncia");
		lblTempoPermanncia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTempoPermanncia.setBounds(185, 75, 132, 24);
		getContentPane().add(lblTempoPermanncia);

		textTempoPerm = new JTextField();
		textTempoPerm.setBounds(185, 98, 132, 20);
		getContentPane().add(textTempoPerm);
		textTempoPerm.setColumns(10);

		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (validarCampos()) {// validar campos
						if (preencherObjeto()) {// preencher o objeto
							// salvar no banco
							
								if (DAO.incluir(obj)) {
									JOptionPane.showMessageDialog(null, "Registro Salvo com Sucesso!!");
									
									try {
										atualizaJTable();
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								} else {
									JOptionPane.showMessageDialog(null, "Não foi possivel salvar!!");
								}
							
						}

					}
				} catch (Exception erro) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, erro.getMessage());
				}

			}
		});
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGravar.setBounds(36, 142, 79, 23);
		getContentPane().add(btnGravar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (validarCampos()) {// validar campos
						if (preencherObjeto()) {// preencher o objeto
							// salvar no banco
							
								if (DAO.editar(obj)) {
									JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!!");
									limparCampos();
									try {
										atualizaJTable();
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
								} else {
									JOptionPane.showMessageDialog(null, "Não foi possivel alterar os dados!!");
								}
							
						}

					}
				} catch (Exception erro) {
					erro.printStackTrace();
					// TODO: handle exception
					//JOptionPane.showMessageDialog(null, erro.getMessage());
				}

				
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(125, 142, 79, 23);
		getContentPane().add(btnEditar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeletar.setBounds(224, 142, 79, 23);
		getContentPane().add(btnDeletar);

		JButton btnNewButton = new JButton("Novo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();

				acao = "Incluir";
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(333, 142, 71, 23);
		getContentPane().add(btnNewButton);

		JButton btnPesquisar = new JButton("Pesquisar");
//		btnPesquisar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					if (textId.getText().equals("")) {
//						textId.requestFocus();
//
//					} else {
//						obj = DAO.pesquisar(textId.getText());
//						if (obj == null) {
//							JOptionPane.showMessageDialog(null, "Usuario não encontrado");
//
//						} else {
//							textValor.setText(Double.toString(obj.getValor()));
//							comboTicketBox.setSelectedIndex(obj.getPerca());
//							textTempoPerm.setText(obj.getTempo());
//
//						}
//
//					}
//					;
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//
//			}
//		});
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisar.setBounds(414, 142, 104, 23);
		getContentPane().add(btnPesquisar);
		
		chckbxEstraviado = new JCheckBox("Ticket Extraviado");
		chckbxEstraviado.setBounds(333, 97, 120, 23);
		getContentPane().add(chckbxEstraviado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 206, 478, 267);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				obj=list.get(table.getSelectedRow());
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

	}

	private void atualizaJTable() throws Exception {
		
		list=DAO.todososPrecos();
		
		Object[][] dados = new Object[list.size()][4];
		
		for(int i =0; i<dados.length;i++){
			dados[i][0]=list.get(i).getTempo();
			dados[i][1]=list.get(i).getValor();
			dados[i][2]=list.get(i).isPerca()?"Sim":"Não";
			dados[i][3]=list.get(i).isFracionado()?"Sim":"Não";
		}
		
		
		table.setModel(new DefaultTableModel(
				dados,
				new String[] {
					"Tempo Permanencia", "Valor", "Perca", "Fracionado"
				}
			));
		
		
	}

	public boolean validarCampos() {
		if (textValor == null) {
			JOptionPane.showMessageDialog(null, "Preencha o campo valor!!");
			textValor.requestFocus();
			return false;
		}
		if (textTempoPerm == null) {
			JOptionPane.showMessageDialog(null, "Preencha o campo Permanência!!");
			textTempoPerm.requestFocus();
			return false;

		}
		return true;
	}

	public boolean preencherObjeto() throws Exception {
		obj.setValor(Double.parseDouble(textValor.getText()));
		obj.setTempo(textTempoPerm.getText());
		obj.setPerca(chckbxEstraviado.isSelected());		
		return true;

	}

	public void preencherCampos() {
		textValor.setText(""+obj.getValor());
		textTempoPerm.setText(obj.getTempo());
		chckbxEstraviado.setSelected(obj.isPerca());
		
	}
	
	
	public void limparCampos() {
		textValor.setText("");
		textTempoPerm.setText("");
		chckbxEstraviado.setSelected(false);
	}
}
