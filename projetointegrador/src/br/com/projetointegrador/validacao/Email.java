package br.com.projetointegrador.validacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Email {
	private String email;
	private String expression;
	
	public Email(String email){
		this.email = email;
		
		
	}
	
	public boolean isEmail(){
		 //boolean isMailIdValid = false;
		 if(email != null && email.length() > 0){
			expression = "([\\S]*)@([\\S]*)(\\.)([a-z]{3})([\\.]{0,1}([a-z]{2}))$";
			              //[a-zA-Z0-9][a-zA-Z0-9\._-]+@([a-zA-Z0-9\._-]+\.)[a-zA-Z-0-9]{2,3}
			
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			if(matcher.matches()){
				//isMailIdValid = true;
				JOptionPane.showMessageDialog(null, "email ok");
				return true;
			}else{
				
			}
		 }
		 return false;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
