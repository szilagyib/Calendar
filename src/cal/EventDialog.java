package cal;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public abstract class EventDialog extends JDialog {
	protected JFrame owner;
	protected EventList evs;
	protected JComboBox yearBox;
	protected JComboBox monthBox;
	protected JComboBox dayBox;
	protected JButton button;
	
	public EventDialog(JFrame o, EventList el) {
		super(o);
		owner = o;
		evs = el;
		setSize(300, 120);
		setLayout(new FlowLayout());
		setResizable(false);
		setVisible(false);
	}
	
	protected void init() {		
		Object[] years = new Object[10];
	    	int actualYear = Calendar.getInstance().get(Calendar.YEAR);
		for (int i=0; i<10; i++) {
			years[i] = actualYear;
			actualYear++;
		}
		
		Object[] months = new Object[12];
		int m = 0;
		while (m < 12) {
			months[m] = ++m;
		}

		Object[] days = new Object[31];
		int d = 0;
		while (d < 31) {
			days[d] = ++d;
		}
		
		yearBox = new JComboBox(years);
		monthBox = new JComboBox(months);
		dayBox = new JComboBox(days);
		button = new JButton();
		button.setBackground(Color.PINK);
	}
}
