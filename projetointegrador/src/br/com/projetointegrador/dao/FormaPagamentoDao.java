package br.com.projetointegrador.dao;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import br.com.projetointegrador.modelo.FormaPagamento;
import br.com.projetointegrdor.conexao.Conexao;

public class FormaPagamentoDao {
	
	private String sql;
	private PreparedStatement pst;
	private Conexao conexao = Conexao.getInstancia();
	private FormaPagamento obj;
	
	
	public boolean inserir(FormaPagamento obj){
		sql = "insert into forma_pagamento (descricao) values(?)";
		try {
			pst = conexao.getCon().prepareStatement(sql);
			
			pst.setString(1, obj.getDescricao());
			int registro = pst.executeUpdate();
			if(registro> 0){
				//JOptionPane.showMessageDialog(null, "Registro inserido com sucesso!!");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		return true;
	}
	

}
