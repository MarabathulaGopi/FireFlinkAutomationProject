package ninzaCRM.genericMethodsPractise;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * This class consists of generic methods related to
 * Java Related Operations like random number and system date
 * 
 * @author Gopi M
 * 
 */
public class JavaUtility {
	
	/**
	 * This method will return an random number
	 * @return
	 */
	public int getRandomNumber()
	{
		Random random=new Random();
		int value=random.nextInt(1000);
		return value;
	}
	
	/**
	 * This method will capture the current system date and format it and return it
	 * @return
	 */
	
	public String getSystemData()
	{
		Date date=new Date();
		
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
        String formattedDate = formatter.format(date);
        return formattedDate;
	}
}
