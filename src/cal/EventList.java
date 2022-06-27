package cal;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class EventList
{
	protected List<Event> events;
	
	public EventList()
	{
		events = new ArrayList<>();
	}
	
	public void addEvent(Event e)
	{
		deleteEvent(e);
		events.add(e);
	}
	
	//for-each ciklussal ConcurrentModificationException
	public void deleteEvent(Event e)
	{
		Iterator<Event> iter = events.iterator();
		while(iter.hasNext())
		{
		    Event i = iter.next();
		    if( i.equals(e))
		        iter.remove();
		}
	}
	
	public String shareEvent(Event e)
	{
		for (Event i : events)
		{
			if (i.equals(e))
				return i.getName();
		}
		return null;
	}
}
