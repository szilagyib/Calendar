package cal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEventDialog extends EventDialog {
	private JTextField eventField;
	
	public AddEventDialog(JFrame o, EventList el) {
		super(o, el);
		init();
		eventField = new JTextField(10);

		JLabel yearLabel = new JLabel("Year: ");
		JLabel monthLabel = new JLabel("Month: ");
		JLabel dayLabel = new JLabel("Day: ");
		JLabel eventLabel = new JLabel("Event: ");
		
		button.setText("ADD");
		button.addActionListener(new ButtonListener());
		
		add(yearLabel);
		add(yearBox);
		add(monthLabel);
		add(monthBox);
		add(dayLabel);
		add(dayBox);
		add(eventLabel);
		add(eventField);
		add(button);
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			int y = (int)yearBox.getSelectedItem();
			int m = (int)monthBox.getSelectedItem();
			int d = (int)dayBox.getSelectedItem();
			String n = eventField.getText();
			evs.addEvent(new Event(y, m, d, n));
			owner.revalidate();
			setVisible(false);
		} 	
	}
	
}
