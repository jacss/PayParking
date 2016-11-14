package br.com.projetointegrador.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

import br.com.projetointegrador.modelo.Ticket;
import br.com.projetointegrdor.conexao.Conexao;

public class TicketDao {
	private Conexao con = Conexao.getInstancia();
	private String sql;
	private PreparedStatement pst;
	private ResultSet rs;

	public boolean salvar(Ticket obj) {

		sql = "insert into ticket (cod_ticket,data,hora_entrada,hora_saida,usuario_cnpj_cpf) values(?,?,?,?,?)";

		try {
			pst = con.getCon().prepareStatement(sql);
			pst.setString(1, obj.getCod_ticket());
			pst.setDate(2, new Date(obj.getData().getTime()));
			pst.setTime(3, new Time(obj.getHora_entrada().getTime()));
			if (obj.getHora_saida() != null) {
				pst.setTime(4, new Time(obj.getHora_saida().getTime()));
			} else {
				pst.setNull(4, 0);
			}
			if (obj.getUsuario_cnpj_cpf() != null) {

				pst.setString(5, obj.getUsuario_cnpj_cpf());
			} else {
				pst.setNull(5, 0);
			}
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
