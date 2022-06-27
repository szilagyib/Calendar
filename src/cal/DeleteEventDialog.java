package cal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class DeleteEventDialog extends EventDialog {	
	public DeleteEventDialog(JFrame o, EventList el) {
		super(o, el);
		init();
		
		JLabel yearLabel = new JLabel("Year: ");
		JLabel monthLabel = new JLabel("Month: ");
		JLabel dayLabel = new JLabel("Day: ");
		
		button.setText("DELETE");
		button.addActionListener(new ButtonListener());
		
		add(yearLabel);
		add(yearBox);
		add(monthLabel);
		add(monthBox);
		add(dayLabel);
		add(dayBox);
		add(button);
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			int y = (int)yearBox.getSelectedItem();
			int m = (int)monthBox.getSelectedItem();
			int d = (int)dayBox.getSelectedItem();
			evs.deleteEvent(new Event(y, m, d));
			owner.revalidate();
			setVisible(false);
		} 	
	}
	
}
