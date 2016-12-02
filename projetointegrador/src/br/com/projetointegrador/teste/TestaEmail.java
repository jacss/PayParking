package br.com.projetointegrador.teste;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class TestaEmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression = "^[\\w\\.-]+@([\\w\\-]+\\.).[A-Z]{3}$";
        //[a-zA-Z0-9][a-zA-Z0-9\._-]+@([a-zA-Z0-9\._-]+\.)[a-zA-Z-0-9]{2,3}

Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
Matcher matcher = pattern.matcher("j.laugustocss@gmail.com");
if(matcher.matches()){
//isMailIdValid = true;
	
JOptionPane.showMessageDialog(null, "email ok");
}

	}

}
