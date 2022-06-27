package cal;
import java.io.Serializable;

public class Event implements Serializable {
	private int year;
	private int month;
	private int day;
	private String name;
	
	public Event(int y, int m, int d, String n) {
		year = y;
		month = m;
		day = d;
		name = n;
	}
	
	public Event(int y, int m, int d) {
		year = y;
		month = m;
		day = d;
		name = null;
	}
	
	@Override
	public boolean equals(Object o) {
	    if (o == this) 
	    	return true;
	    if (o == null || !(o instanceof Event))
	    	return false;
	    Event e = (Event)o;
		return e.getYear()==year && e.getMonth()==month && e.getDay()==day;
	}
	
    	@Override
    	public int hashCode() {
		int result = 17;
		result = 31 * result + year;
		result = 31 * result + month;
		result = 31 * result + day;
		result = 31 * result + name.hashCode();
		return result;
    	}
	
	public int getYear() {
		return year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
	
	public String getName() {
		return name;
	}
}
