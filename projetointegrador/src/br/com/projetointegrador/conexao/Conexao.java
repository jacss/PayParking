package br.com.projetointegrador.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	static final String DRIVER = "com.mysql.jdbc.Driver";
	static final String URL = "jdbc:mysql://localhost:3306/bd_integrador";
	static final String USUARIO = "root";
	static final String SENHA = "210778";

	private static Conexao instancia;
	private Connection con;

	public Conexao() {

	}

	public static Conexao getInstancia() {
		if (instancia == null) {
			instancia = new Conexao();
			}
		return instancia;
	}

	public Connection getCon() {
		try {
			if(con == null || con.isClosed()==true){
				conecta();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return con;
	}
	
	private void conecta(){
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,USUARIO,SENHA);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

	
	

}
