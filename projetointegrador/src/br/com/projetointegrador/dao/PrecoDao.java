package br.com.projetointegrador.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projetointegrador.modelo.Preco;
import br.com.projetointegrdor.conexao.Conexao;

public class PrecoDao {
	private Conexao conexao = Conexao.getInstancia();
	private String sql;
	private PreparedStatement pst;
	private ResultSet rs;
	private Preco obj = null;

	public boolean incluir(Preco obj) throws Exception {
		sql = "insert into preco(valor,perca,tempo,fracionado) values(?,?,?,?)";
		pst = conexao.getCon().prepareStatement(sql);

		pst.setDouble(1, obj.getValor());
		pst.setBoolean(2, obj.isPerca());
		pst.setString(3, obj.getTempo());
		pst.setBoolean(4, obj.isFracionado());

		int registros = pst.executeUpdate();
		if (registros > 0) {
			return true;

		} else {
			return false;

		}

	}

//	public Preco pesquisar(String id_preco) throws Exception {
//		Preco obj = null;
//		sql = "select * from preco where id_preco=?";
//		pst = conexao.getCon().prepareStatement(sql);
//		pst.setInt(1, Integer.parseInt(id_preco));
//
//		rs = pst.executeQuery();
//
//		if (rs.next()) {
//			obj = new Preco();
//
//
//			obj.setValor(rs.getDouble("valor"));
//			obj.setPerca(rs.getBoolean("perca"));
//			obj.setTempo(rs.getString("tempo"));
//
//		}
//
//		return obj;
//	}

	public boolean editar(Preco obj) throws Exception {
		sql = "update preco set valor=?, perca=?, tempo=?, fracionado=? where id_preco=?";
		pst = conexao.getCon().prepareStatement(sql);
		
		
		pst.setDouble(1, obj.getValor());
		pst.setBoolean(2, obj.isPerca());
		pst.setString(3, obj.getTempo());
		pst.setBoolean(4, obj.isFracionado());
		pst.setInt(5, obj.getId_preco());
		
		

		int registro = pst.executeUpdate();
		if (registro > 0) 
			
			return true;
		else 
			
			return false;
		

	}
	
	
	public List<Preco> todososPrecos() throws Exception {
		List<Preco> list = new ArrayList<Preco>();
		
		sql = "select * from preco";
		pst = conexao.getCon().prepareStatement(sql);
		

		rs = pst.executeQuery();

		while (rs.next()) {
			
			list.add( new Preco(rs.getInt("id_preco"),rs.getDouble("valor"), rs.getBoolean("perca"),rs.getString("tempo"), rs.getBoolean("fracionado")));
		}			

		return list;
	}
	public boolean deletar(int id_preco)throws Exception{
		sql = "delete from preco where id_preco=?";
		pst = conexao.getCon().prepareStatement(sql);
		
		pst.setInt(1, id_preco);
		
		int registro=pst.executeUpdate();
		if(registro >0)
			return true;
		else
			return false;
		
		}

}
