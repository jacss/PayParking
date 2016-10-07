package br.com.projetointegrador.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projetointegrador.modelo.FormaPagamento;
import br.com.projetointegrdor.conexao.Conexao;

public class FormaPagamentoDao {

	private String sql;
	private PreparedStatement pst;
	private Conexao conexao = Conexao.getInstancia();
	private FormaPagamento obj;
	private ResultSet rs = null;


	public List<FormaPagamento> todasFormas() throws Exception {
		List<FormaPagamento> list = new ArrayList<>();
		sql = "select * from forma_pagamento";
		pst = conexao.getCon().prepareStatement(sql);

		rs = pst.executeQuery();
		while (rs.next()) {
			list.add(new FormaPagamento(rs.getInt("id_forma"), rs.getString("descricao")));
		}

		return list;

	}

	public boolean deletar(int id_forma) throws Exception {
		sql = "delete from forma_pagamento where id_forma=?";
		try {
			pst = conexao.getCon().prepareStatement(sql);
			pst.setInt(1, id_forma);

			int registro = pst.executeUpdate();

			if (registro > 0) {
				return true;

			} else {
				return false;

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return true;
	}

	private void inserir(FormaPagamento obj) {
		sql = "insert into forma_pagamento (descricao) values(?)";
		try {
			pst = conexao.getCon().prepareStatement(sql);

			pst.setString(1, obj.getDescricao());
			pst.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private void update(FormaPagamento obj) {
		sql = "update forma_pagamento set descricao=? where id_forma=?";
		try {
			pst = conexao.getCon().prepareStatement(sql);
			pst.setString(1, obj.getDescricao());
			pst.setInt(2, obj.getId_forma());

			pst.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public boolean salvar(FormaPagamento obj) {
		if (obj.getId_forma() == 0) {
			inserir(obj);

		} else {
			update(obj);

		}
		return true;
	}

}
