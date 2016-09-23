package br.com.projetointegrador.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.spi.TransactionalWriter;

import br.com.projetointegrador.modelo.Preco;
import br.com.projetointegrador.modelo.Usuario;
import br.com.projetointegrdor.conexao.Conexao;

public class UsuarioDao {
	private Conexao conexao = Conexao.getInstancia();
	private PreparedStatement pst;
	private ResultSet rs;
	private String sql;

	public boolean incluir(Usuario obj) throws Exception {
		sql = "insert into usuario(cnpj_cpf,nome,email,login,senha,telefone) values (?,?,?,?,?,?)";

		pst = conexao.getCon().prepareStatement(sql);

		pst.setString(1, obj.getCnpj_cpf());
		pst.setString(2, obj.getNome());
		pst.setString(3, obj.getEmail());
		pst.setString(4, obj.getLogin());
		pst.setString(5, obj.getSenha());
		pst.setString(6, obj.getTelefone());

		int registro = pst.executeUpdate();
		if (registro > 0)
			return true;
		else
			return false;

	}

	public List<Usuario>listaTodosUsuarios()throws Exception{
		List<Usuario> list = new ArrayList<Usuario>();
		sql ="select * from usuario";
		pst = conexao.getCon().prepareStatement(sql);
		
		rs = pst.executeQuery();
		
		while(rs.next()){
			list.add(new Usuario(rs.getString("cnpj_cpf"), rs.getString("nome"),rs.getString("email"),rs.getString("login"),
					rs.getString("senha"),rs.getString("telefone")));
		}
		return list;
	}
	public boolean editar(Usuario usuario)throws Exception{
		sql = "update usuario set  nome=?, email=?, login=?, senha=?, telefone=? where cnpj_cpf=?";
		pst = conexao.getCon().prepareStatement(sql);
		
		
		pst.setString(1, usuario.getNome());
		pst.setString(2, usuario.getEmail());
		pst.setString(3, usuario.getLogin());
		pst.setString(4, usuario.getSenha());
		pst.setString(5, usuario.getTelefone());
		pst.setString(6, usuario.getCnpj_cpf());
		
		int registro = pst.executeUpdate();
		if(registro >0)
			return true;
		else
			return false;
		
		
		
	}
	public boolean deletar(String cnpj_cpf)throws Exception{
		sql = "delete from usuario  where cnpj_cpf=?";
		pst = conexao.getCon().prepareStatement(sql);
		
		pst.setString(1, cnpj_cpf);
		
		int registro = pst.executeUpdate();
		if(registro >0)
			return true;
		else
			return false;
		
		
		
	}

}
