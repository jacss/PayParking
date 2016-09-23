package br.com.projetointegrador.modelo;

public class Usuario {
	private int cnpj_cpf;
	private String nome;
	private String email;
	private String telefone;
	private String login;
	private String senha;
	
	public Usuario (){
		
	}

	public Usuario(int cnpj_cpf, String nome, String email, String telefone, String login, String senha) {
		super();
		this.cnpj_cpf = cnpj_cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.login = login;
		this.senha = senha;
	}

	public int getCnpj_cpf() {
		return cnpj_cpf;
	}

	public void setCnpj_cpf(int cnpj_cpf) {
		this.cnpj_cpf = cnpj_cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
