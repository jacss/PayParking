package br.com.projetointegrador.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.projetointegrador.util.GUIUtil;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Dimension;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setResizable(true);
		
		setMaximizedBounds(new Rectangle(0, 0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1361, 725);
		GUIUtil.setLookAndFeel(this);
		GUIUtil.center(this);
	
		//setExtendedState(Frame.MAXIMIZED_BOTH);// a janela sempre sera maximizada
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem itmMenuCadUsuario = new JMenuItem("Cadastrar Usu\u00E1rio");
		itmMenuCadUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaUsuario tu = new TelaUsuario();
				tu.setVisible(true);
				desktopPane.add(tu);
			}
		});
		mnCadastro.add(itmMenuCadUsuario);
		
		JMenuItem itemMenuCadastrarPreos = new JMenuItem("Cadastrar Pre\u00E7os");
		itemMenuCadastrarPreos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TeleCadPreco tcp = new TeleCadPreco();
				desktopPane.add(tcp);
				tcp.setVisible(true);
				
			}
		});
		mnCadastro.add(itemMenuCadastrarPreos);
		
		JMenu mnOpes = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(mnOpes);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sair = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do sistema? " +JOptionPane.YES_NO_OPTION);
				if (sair == JOptionPane.YES_OPTION) {
					System.exit(0);
				} 
			}
		});
		mnOpes.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane);
	}
}
