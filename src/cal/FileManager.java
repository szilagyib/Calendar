package cal;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.io.File;

public class FileManager
{
	private String file_name;
	
	public FileManager(String f) {
		file_name = f;
	}
	
	public void serialize(EventList evs) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file_name));
		    	oos.writeObject(evs.events);
		    	oos.close();
		} catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public EventList deserialize() {
		EventList evs = new EventList();
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file_name));
			evs.events = (List<Event>)ois.readObject();
			ois.close();
	    	} catch(Exception exc) {
	        	exc.printStackTrace();
		}
		return evs;
	}
}
