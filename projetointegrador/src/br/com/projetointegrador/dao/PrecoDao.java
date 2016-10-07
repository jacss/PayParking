package br.com.projetointegrador.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projetointegrador.modelo.FormaPagamento;
import br.com.projetointegrador.modelo.Preco;
import br.com.projetointegrdor.conexao.Conexao;

public class PrecoDao {
	private Conexao conexao = Conexao.getInstancia();
	private String sql;
	private PreparedStatement pst;
	private ResultSet rs;
	private Preco obj = null;

	private void incluir(Preco obj) throws Exception {
		sql = "insert into preco(valor,perca,tempo,fracionado) values(?,?,?,?)";
		try {
			pst = conexao.getCon().prepareStatement(sql);
			pst.setDouble(1, obj.getValor());
			pst.setBoolean(2, obj.isPerca());
			pst.setString(3, obj.getTempo());
			pst.setBoolean(4, obj.isFracionado());
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void update(Preco obj) {
		sql = "update preco set valor=?, perca=?, tempo=?, fracionado=? where id_preco=?";
		try {
			pst = conexao.getCon().prepareStatement(sql);
			pst.setDouble(1, obj.getValor());
			pst.setBoolean(2, obj.isPerca());
			pst.setString(3, obj.getTempo());
			pst.setBoolean(4, obj.isFracionado());
			pst.setInt(5, obj.getId_preco());
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public List<Preco> todososPrecos() throws Exception {
		List<Preco> list = new ArrayList<Preco>();

		sql = "select * from preco";
		pst = conexao.getCon().prepareStatement(sql);

		rs = pst.executeQuery();

		while (rs.next()) {

			list.add(new Preco(rs.getInt("id_preco"), rs.getDouble("valor"), rs.getBoolean("perca"),
					rs.getString("tempo"), rs.getBoolean("fracionado")));
		}

		return list;
	}

	public boolean deletar(int id_preco) throws Exception {
		sql = "delete from preco where id_preco=?";
		pst = conexao.getCon().prepareStatement(sql);

		pst.setInt(1, id_preco);

		int registro = pst.executeUpdate();
		if (registro > 0)
			return true;
		else
			return false;

	}
	
	public boolean salvar(Preco obj) throws Exception{
		if (obj.getId_preco()==0) {
			incluir(obj);
			
		} else {
		update(obj);

		}
		
		return true;
	}

}
