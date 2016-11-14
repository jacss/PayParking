package br.com.projetointegrador.codigobarra;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CodigoBarraVerificador {

	public static void main(String[] args) {

		SimpleDateFormat format = new SimpleDateFormat("ddMMyyhhmmss");

		Date data = new Date();

		System.out.println(codigoVerificador(format.format(data)));

	}

	public static String codigoVerificador(String ean) {

		int somPar = 0, somaImpar = 0;
		for (int i = 0; i < ean.length(); i++) {
			if (i % 2 == 0) {
				somPar += Integer.parseInt("" + ean.charAt(i));
			} else {
				somaImpar += Integer.parseInt("" + ean.charAt(i));

			}

		}

		somPar *= 3;
		int total = somPar + somaImpar;

		int count = 0;
		while (total % 10 != 0) {
			total += 1;
			count++;
		}

		ean += count;

		return ean;

	}

}
