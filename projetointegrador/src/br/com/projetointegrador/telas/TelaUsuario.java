package br.com.projetointegrador.telas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.projetointegrador.dao.UsuarioDao;
import br.com.projetointegrador.modelo.Usuario;
import br.com.projetointegrador.util.GUIUtil;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaUsuario extends JInternalFrame {
	private JTextField textNome;
	private JTextField textMail;
	private JTextField textCnpjCpf;
	private JTextField textTelefone;
	private JTextField textLogin;
	private JTextField textSenha;
	private Usuario usuario = new Usuario();
	private UsuarioDao dao = new UsuarioDao();
	private JTable table;
	private List<Usuario> list = new ArrayList<Usuario>();



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaUsuario frame = new TelaUsuario();
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
	public TelaUsuario() {
		setTitle("Cadastro de Usu\u00E1rios");
		setBounds(0, 100, 567, 500);
		GUIUtil.setLookAndFeel(this);
		GUIUtil.center(this);
		getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(39, 42, 46, 14);
		getContentPane().add(lblNome);

		textNome = new JTextField();
		textNome.setBounds(39, 67, 225, 20);
		getContentPane().add(textNome);
		textNome.setColumns(10);

		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setBounds(278, 42, 46, 14);
		getContentPane().add(lblEmail);

		textMail = new JTextField();
		textMail.setBounds(278, 67, 234, 20);
		getContentPane().add(textMail);
		textMail.setColumns(10);

		JLabel lblCnpjcpf = new JLabel("Cnpj/Cpf");
		lblCnpjcpf.setBounds(39, 98, 46, 14);
		getContentPane().add(lblCnpjcpf);

		textCnpjCpf = new JTextField();
		textCnpjCpf.setBounds(39, 123, 225, 20);
		getContentPane().add(textCnpjCpf);
		textCnpjCpf.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(278, 98, 46, 14);
		getContentPane().add(lblTelefone);

		textTelefone = new JTextField();
		textTelefone.setBounds(278, 123, 234, 20);
		getContentPane().add(textTelefone);
		textTelefone.setColumns(10);

		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					validarCampos();
					preencheObjeto();
					if (dao.incluir(usuario)) {
						JOptionPane.showMessageDialog(null, "Usu�rio cadastrado com sucesso!!");
						atualizaJTable();
					} else {
						JOptionPane.showMessageDialog(null, "N�o foi possivel cadastra o usu�rio!!");

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnGravar.setBounds(39, 219, 89, 23);
		getContentPane().add(btnGravar);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpaCampos();
			}
		});
		btnNovo.setBounds(423, 219, 89, 23);
		getContentPane().add(btnNovo);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					validarCampos();
					preencheObjeto();
					//atualizaCampos();
					if (dao.editar(usuario)) {
						JOptionPane.showMessageDialog(null, "Usu�rio atualizado com Sucesso!!");
						atualizaJTable();
					} else {
						JOptionPane.showMessageDialog(null, "N�o foi possivel atualizar o usu�rio!!");
					}
					
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnEditar.setBounds(167, 219, 89, 23);
		getContentPane().add(btnEditar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if (dao.deletar(textCnpjCpf.getText())) {
						JOptionPane.showMessageDialog(null, "Usu�rio deletado com Sucesso!!");
						atualizaJTable();
					} else {
						JOptionPane.showMessageDialog(null, "N�o foi possivel deletar o usu�rio!!");
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnDeletar.setBounds(295, 219, 89, 23);
		getContentPane().add(btnDeletar);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(39, 158, 46, 14);
		getContentPane().add(lblLogin);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(278, 158, 46, 14);
		getContentPane().add(lblSenha);

		textLogin = new JTextField();
		textLogin.setBounds(39, 183, 225, 20);
		getContentPane().add(textLogin);
		textLogin.setColumns(10);

		textSenha = new JTextField();
		textSenha.setBounds(278, 183, 234, 20);
		getContentPane().add(textSenha);
		textSenha.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(39, 261, 472, 171);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				usuario=list.get(table.getSelectedRow());
				atualizaCampos();
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
	public void atualizaJTable()throws Exception{
		list = dao.listaTodosUsuarios();
		Object[][] dados = new Object[list.size()][6];
		
		for(int i = 0; i<dados.length; i++){
			dados[i][0]= list.get(i).getCnpj_cpf();
			dados[i][1]= list.get(i).getNome();
			dados[i][2]= list.get(i).getEmail();
			dados[i][3]= list.get(i).getLogin();
			dados[i][4]= list.get(i).getSenha();
			dados[i][5]= list.get(i).getTelefone();
			
			
		}
		
		table.setModel(new DefaultTableModel(
			dados,
				new String[] {
					"Cnpj/Cpf", "Nome", "E-Mail", "Login", "Senha", "Telefone"
				}
			));
	}

	public boolean validarCampos() {
		if (textNome.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O campo NOME n�o pode ser nulo!!");
			textNome.requestFocus();
			return false;

		}
		if (textMail.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O campo E-MAIL n�o pode ser nulo!!");
			textMail.requestFocus();
			return false;

		}
		if (textTelefone.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O campo TELEFONE n�o pode ser nulo!!");
			textTelefone.requestFocus();
			return false;

		}
		if (textCnpjCpf.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O campo CNPJ/CPF n�o pode ser nulo!!");
			textCnpjCpf.requestFocus();
			return false;

		}
		if (textLogin.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O campo LOGIN n�o pode ser nulo!!");
			textLogin.requestFocus();
			return false;

		}
		if (textSenha.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O campo SENHA n�o pode ser nulo!!");
			textSenha.requestFocus();
			return false;

		}
		return true;
	}

	public void atualizaCampos() {
		textNome.setText(usuario.getNome());
		textMail.setText(usuario.getEmail());
		textCnpjCpf.setText(String.valueOf(usuario.getCnpj_cpf()));
		textTelefone.setText(usuario.getTelefone());
		textLogin.setText(usuario.getLogin());
		textSenha.setText(usuario.getSenha());

		
	}
	public void preencheObjeto(){
		usuario.setCnpj_cpf(textCnpjCpf.getText());
		usuario.setNome(textNome.getText());
		usuario.setEmail(textMail.getText());
		usuario.setLogin(textLogin.getText());
		usuario.setSenha(textSenha.getText());
		usuario.setTelefone(textTelefone.getText());
	}
	public void limpaCampos(){
		textCnpjCpf.setText("");
		textNome.setText("");
		textMail.setText("");
		textLogin.setText("");
		textSenha.setText("");
		textTelefone.setText("");
		
	}
}