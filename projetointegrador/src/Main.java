import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		long start = Calendar.getInstance().getTimeInMillis();

		Thread.sleep(1000 * 10);

		long stop = Calendar.getInstance().getTimeInMillis();
		System.out.println(diferencaEmHora(start,stop));;

	}

	private static String diferencaEmHora(long start,long stop) {
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
