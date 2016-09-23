package br.com.projetointegrador.modelo;

public class Usuario {
	private String cnpj_cpf;
	private String nome;
	private String email;
	private String login;
	private String senha;
	private String telefone;
	
	public Usuario (){
		
	}

	public Usuario(String cnpj_cpf, String nome, String email, String login, String senha, String telefone) {
		super();
		this.cnpj_cpf = cnpj_cpf;
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.telefone = telefone;
	}

	public String getCnpj_cpf() {
		return cnpj_cpf;
	}

	public void setCnpj_cpf(String cnpj_cpf) {
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
