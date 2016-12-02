package br.com.projetointegrador.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import br.com.projetointegrador.dao.UsuarioDao;
import br.com.projetointegrador.modelo.Usuario;
import br.com.projetointegrador.util.GUIUtil;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private Usuario user;
	private UsuarioDao dao = new UsuarioDao();
	private JPasswordField passwordSenha;

	/**
	 * Launch the application.
	 * 
	 * 
	 */
	public void logar() {
		user = dao.logar(textUsuario.getText(), passwordSenha.getText());
		if (user == null) {
			JOptionPane.showMessageDialog(null, "Usuário ou Senha Invalido!!");

		} else {
			TelaPrincipal tp = new TelaPrincipal();
			tp.setVisible(true);
			this.setVisible(false);
		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 232);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		GUIUtil.center(this);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(114, 24, 255, 146);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setBounds(10, 22, 46, 14);
		panel.add(lblUsurio);

		textUsuario = new JTextField();
		textUsuario.setBounds(66, 19, 179, 20);
		panel.add(textUsuario);
		textUsuario.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 62, 46, 14);
		panel.add(lblSenha);

		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (validaCampos()) {
					logar();
				}

			}
		});
		btnLogar.setBounds(10, 101, 89, 23);
		panel.add(btnLogar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		btnCancelar.setBounds(156, 101, 89, 23);
		panel.add(btnCancelar);

		passwordSenha = new JPasswordField();
		passwordSenha.setBounds(66, 59, 180, 20);
		panel.add(passwordSenha);

		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(TelaLogin.class.getResource("/br/com/projetointegrador/imagens/Login.png")));
		lblImagem.setBounds(10, 42, 107, 121);
		contentPane.add(lblImagem);
	}

	public boolean validaCampos() {
		if (textUsuario.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Favor preencher o campo login!!");
			textUsuario.requestFocus();
			return false;
		}
		if (passwordSenha.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Favor preencher o campo senha!!");
			passwordSenha.requestFocus();
			return false;
		}
		return true;
	}
}
