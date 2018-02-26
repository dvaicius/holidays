import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

// @version 4 Commit and push
public class Holidays {
	
	public static void main(String[] args) {
		Holidays holidays = new Holidays();
		holidays.randomStringUUID();
		//dariusHolidays.setPublicHolidays(new Date());
		//dariusHolidays.setPublicHolidays(new Date());
		//dariusHolidays.printAllPublicHolidays();
		
		HolidaysDbConnection holidaysDbConn = new HolidaysDbConnection();
		holidaysDbConn.getUsers();
		holidaysDbConn.getUsers(1);
		holidaysDbConn.getPublicHolidays();
	}
	
	private List<Date> publicHolidays = new ArrayList<Date>();

	public List<Date> getPublicHolidays() {
		return publicHolidays;
	}

	public void setPublicHolidays(Date publicHoliday) {
		this.publicHolidays.add(publicHoliday);
	}
	
	public void printAllPublicHolidays() {
		System.out.println(this.publicHolidays.toString());
	}
	
	// Generiert 36-Zeichen; brauchen aber 40-Zeichen
	public String randomStringUUID() {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        System.out.println("UUID=" + randomUUIDString);
        
        return randomUUIDString;
	}
}
