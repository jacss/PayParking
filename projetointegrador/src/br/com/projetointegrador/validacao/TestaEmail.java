package br.com.projetointegrador.validacao;

public class TestaEmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String s ="helber@supermaia.ass";

System.out.println(s.matches("([\\S]*)@([\\S]*)(\\.)([a-z]{3})([\\.]{0,1}([a-z]{2}))$"));
	}

}
