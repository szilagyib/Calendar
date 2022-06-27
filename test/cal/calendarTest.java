package cal;
import static org.junit.Assert.*;
import org.junit.Test;
import javax.swing.*;
import java.io.FileNotFoundException;

public class calendarTest
{
	@Test
	public void test1()
	{
		Event e = new Event(2018, 11, 11);
		assertEquals(2018, e.getYear());
	}
	@Test
	public void test2()
	{
		Event e = new Event(2018, 11, 11);
		assertEquals(11, e.getMonth());
	}
	@Test
	public void test3()
	{
		Event e = new Event(2018, 11, 11);
		assertEquals(11, e.getDay());
	}
	@Test
	public void test4()
	{
		Event e = new Event(2018, 11, 11, "yoga");
		assertEquals("yoga", e.getName());
	}
	@Test
	public void test5()
	{
		EventList el = new EventList();
		Event e = new Event(2018, 11, 11, "yoga");
		el.addEvent(e);
		assertEquals("yoga", el.shareEvent(e));
	}
	@Test
	public void test6()
	{
		EventList el = new EventList();
		Event e = new Event(2018, 11, 11, "yoga");
		el.addEvent(e);
		assertNotEquals("adatb", el.shareEvent(e));
	}
	@Test
	public void test7()
	{
		Event e1 = new Event(1, 1, 1);
		Event e2 = new Event (1, 1, 1, "valami");
		Event e3 = new Event(1, 2, 3);
		assertTrue(e1.equals(e2));
		assertFalse(e1.equals(e3));
	}
	@Test
	public void test8()
	{
		EventList el = new EventList();
		Event e = new Event(2018, 11, 11, "yoga");
		el.addEvent(e);
		assertEquals("yoga", el.shareEvent(e));
		el.deleteEvent(e);
		assertNotEquals("yoga", el.shareEvent(e));
	}
	@Test
	//excepted = no exception
	public void test9()
	{
		JFrame calendar = new MyCalendar();
		calendar.revalidate();
		
	}
	@Test(expected = FileNotFoundException.class)
	public void test10()
	{
		FileManager fm = new FileManager("sonka.dat");
		fm.deserialize();
	}
	@Test
	//expected = no exception
	public void test11()
	{
		FileManager fm = new FileManager("events.txt");
		EventList el = new EventList();
		fm.deserialize();
		fm.serialize(el);
	}
	
}
