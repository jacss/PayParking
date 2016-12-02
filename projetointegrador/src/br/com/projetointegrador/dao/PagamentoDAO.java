package br.com.projetointegrador.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import br.com.projetointegrador.conexao.Conexao;
import br.com.projetointegrador.modelo.Ticket;
import br.com.projetointegrador.util.DataForm;

public class PagamentoDAO {
	private PreparedStatement pst;
	private String sql;
	private ResultSet rs;
	private Conexao con = Conexao.getInstancia();
	private Ticket obj;

	public Ticket consultaTicket(Ticket obj) {
		sql = "select * from ticket where cod_ticket=?";
		try {
			if(obj==null){
				 throw new NullPointerException("o ticket nao pode ser vasio");
			}
			
			pst = con.getCon().prepareStatement(sql);
			pst.setString(1, obj.getCod_ticket());
			rs = pst.executeQuery();
			
			
			
			if (rs.next()) {
				obj = new Ticket(rs.getInt("id_ticket"), rs.getString("cod_ticket"), rs.getDate("data"), 
						rs.getTime("hora_entrada"), rs.getDate("hora_saida"), rs.getString("usuario_cnpj_cpf"));
			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;

		

	}
	
}
