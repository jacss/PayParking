package br.com.projetointegrador.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.projetointegrador.modelo.Usuario;
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
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Font;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	public JDesktopPane desktopPane;

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
		
		//setMaximizedBounds(new Rectangle(0, 0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 1361, 725);
		//GUIUtil.setLookAndFeel(this);
		GUIUtil.center(this);
	
		setExtendedState(Frame.MAXIMIZED_BOTH);// a janela sempre sera maximizada
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		mnCadastro.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(mnCadastro);
		
		JMenuItem itmMenuCadUsuario = new JMenuItem("Usu\u00E1rio");
		itmMenuCadUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaUsuario tu = new TelaUsuario();
				tu.setVisible(true);
				desktopPane.add(tu);
			}
		});
		mnCadastro.add(itmMenuCadUsuario);
		
		JMenuItem itemMenuCadastrarPreos = new JMenuItem("Pre\u00E7os");
		itemMenuCadastrarPreos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TeleCadPreco tcp = new TeleCadPreco();
				desktopPane.add(tcp);
				tcp.setVisible(true);
				
			}
		});
		mnCadastro.add(itemMenuCadastrarPreos);
		
		JMenuItem form_pagamento = new JMenuItem("Forma Pagamento");
		form_pagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaFormaPagamento fp = new TelaFormaPagamento();
				desktopPane.add(fp);
				fp.setVisible(true);
			}
		});
		mnCadastro.add(form_pagamento);
		
		JMenu mnOperaes = new JMenu("Opera\u00E7\u00F5es");
		mnOperaes.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(mnOperaes);
		
		JMenuItem mntmPagamento = new JMenuItem("Pagamento");
		mntmPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPagamento tp = new TelaPagamento();
				tp.setVisible(true);
				desktopPane.add(tp);
			}
		});
		mnOperaes.add(mntmPagamento);
		
		JMenu mnOpes = new JMenu("Op\u00E7\u00F5es");
		mnOpes.setFont(new Font("Tahoma", Font.BOLD, 12));
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
		contentPane.setBorder(new EmptyBorder(5, 5, 50, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(238, 232, 170));
		contentPane.add(desktopPane, "name_20261864522096");
		
		
		
	}
}
