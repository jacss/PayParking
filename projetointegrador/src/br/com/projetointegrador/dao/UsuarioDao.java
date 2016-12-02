package br.com.projetointegrador.dao;

import java.awt.Component;
import java.awt.Desktop;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.spi.TransactionalWriter;

import br.com.projetointegrador.conexao.Conexao;
import br.com.projetointegrador.modelo.Preco;
import br.com.projetointegrador.modelo.Usuario;
import br.com.projetointegrador.telas.TelaPrincipal;

public class UsuarioDao {
	private Conexao conexao = Conexao.getInstancia();
	private PreparedStatement pst;
	private ResultSet rs;
	private String sql;
	private Usuario obj = null;

	private void incluir(Usuario obj) {
		sql = "insert into usuario(cnpj_cpf,nome,email,login,senha,telefone) values (?,?,?,?,?,?)";
		try {
			pst = conexao.getCon().prepareStatement(sql);

			pst.setString(1, obj.getCnpj_cpf());
			pst.setString(2, obj.getNome());
			pst.setString(3, obj.getEmail());
			pst.setString(4, obj.getLogin());
			pst.setString(5, obj.getSenha());
			pst.setString(6, obj.getTelefone());
			pst.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public List<Usuario> listaTodosUsuarios() throws Exception {
		List<Usuario> list = new ArrayList<Usuario>();
		sql = "select * from usuario";
		pst = conexao.getCon().prepareStatement(sql);

		rs = pst.executeQuery();

		while (rs.next()) {
			list.add(new Usuario(rs.getString("cnpj_cpf"), rs.getString("nome"), rs.getString("email"),
					rs.getString("login"), rs.getString("senha"), rs.getString("telefone")));
		}
		return list;
	}

	private void update(Usuario obj) {
		sql = "update usuario set  nome=?, email=?, login=?, senha=?, telefone=? where cnpj_cpf=?";

		try {
			pst = conexao.getCon().prepareStatement(sql);

			pst.setString(1, obj.getNome());
			pst.setString(2, obj.getEmail());
			pst.setString(3, obj.getLogin());
			pst.setString(4, obj.getSenha());
			pst.setString(5, obj.getTelefone());
			pst.setString(6, obj.getCnpj_cpf());

			pst.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public boolean salvar(Usuario obj) {

		try {
			System.out.println(obj.getCnpj_cpf());// precisamos ver o que
													// aparece aqui
			/**
			 * ok. Para sabermos que oum objeto existe no banco sempre
			 * verificamos achave, caso a chave venha nula ou 0 significa que
			 * não existe entao damos o insert. Porém neste caso, o cpf deve ser
			 * preenchido pelo usuario, pois é campo obrigadtório. Nos outros
			 * casos o ID é gerado pelo banco e não pelo usuario, assim podiamos
			 * verifica simplesmente se ele está ou não preenchido, uma vez que
			 * o banco e quem preenchia ele automaticamente, pois ele era auto
			 * increment. Agora a chave e o usuario e nao o banco quem preenche,
			 * logo temos de mudar a abordagem.
			 * 
			 * Oquevamos fazer e o seguinte:
			 * 
			 * 1 - verificar pelo obj.getCnpj_cpf() se este usuario ja esta
			 * cadastrado, se sim damos o insert se nao o update
			 * 
			 * entendeu ? s=1 n=
			 * 
			 * show agora cria uma consulta pelo cpf e retorna o objeto usuario.
			 * 
			 */
			if (getUsuarioPeloCPFCNPJ(obj.getCnpj_cpf()) == null) {
				incluir(obj);

			} else {
				update(obj);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return true;
	}

	/**
	 * Esta funcao recebe um Usuario como parametro consulta pelo cpf e cnpj
	 * 
	 * @return um objeto de usuario se encontrado, senao retorna null espera
	 *         carai estou pensando. senti o cheiro mesmo
	 * @throws Exception
	 */
	public Usuario getUsuarioPeloCPFCNPJ(String cnjp_cpf) throws Exception {// agora
																			// e
																			// com
																			// vc
		Usuario list = null;
		sql = "select * from usuario where cnpj_cpf=?";
		pst = conexao.getCon().prepareStatement(sql);
		pst.setString(1, cnjp_cpf);

		rs = pst.executeQuery();

		while (rs.next()) {
			list = new Usuario(rs.getString("cnpj_cpf"), rs.getString("nome"), rs.getString("email"),
					rs.getString("login"), rs.getString("senha"), rs.getString("telefone"));

		}
		return list;
	}

	public boolean deletar(String cnpj_cpf) throws Exception {
		sql = "delete from usuario  where cnpj_cpf=?";
		pst = conexao.getCon().prepareStatement(sql);

		pst.setString(1, cnpj_cpf);

		int registro = pst.executeUpdate();
		if (registro > 0)
			return true;
		else
			return false;

	}

	public Usuario logar(String nome, String senha) {
		sql = "select * from usuario where login=? and senha=?";
		try {
			pst = conexao.getCon().prepareStatement(sql);
			pst.setString(1, nome);
			pst.setString(2, senha);

			rs = pst.executeQuery();
			if (rs.next()) {
				obj = new Usuario(rs.getString("cnpj_cpf"), rs.getString("nome"), rs.getString("email"),
						rs.getString("login"), rs.getString("senha"), rs.getString("telefone"));

				

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return obj;
	}

}
