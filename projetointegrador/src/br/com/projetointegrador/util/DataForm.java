package br.com.projetointegrador.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataForm {

	public static Date parseData (String data,String pattern) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.parse(data);
	}
	
	public static String dateToString (Date data,String pattern) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(data);
	}
	
	public static String timeToString (Date data) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		return format.format(data);
	}

	
	public static String diferencaEmHora(long start,long stop) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			

			long time = stop - start;

			Calendar cal = Calendar.getInstance();

			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);

			cal.add(Calendar.SECOND, Integer.parseInt("" + (time / 1000)));

			return sdf.format(cal.getTime());
		} catch (Exception e) {

		}
		return null;
		
	}
}
