package br.com.projetointegrador.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.projetointegrador.conexao.Conexao;
import br.com.projetointegrador.modelo.FormaPagamento;
import br.com.projetointegrador.modelo.Pagamento;
import br.com.projetointegrador.modelo.Preco;
import br.com.projetointegrador.modelo.Ticket;

public class EfetuarPagamentoDAO {
	private PreparedStatement pst;
	private ResultSet rs;
	private String sql;
	private Pagamento obj = new Pagamento();
	private Conexao con = Conexao.getInstancia();
	private Ticket objt = new Ticket();
	
	
	
	public boolean salvar(Pagamento obj){
		sql = "insert into pagamento(id_ticket,id_forma,id_preco,total,valorRecebido)values(?,?,?,?,?)";
		try {
			pst = con.getCon().prepareStatement(sql);
			
		    pst.setInt(1, obj.getTicket().getId_ticket());
		    pst.setInt(2, obj.getFormaPagamento().getId_forma());
		    pst.setInt(3, obj.getPreco().getId_preco());
			pst.setDouble(4, obj.getTotalAPagar());
			pst.setDouble(5, obj.getValorRecebido());
			
			System.out.println("Preço: "+ obj.getPreco().getId_preco());
			
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
		
	}

}
