package cal;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyCalendar extends JFrame
{
	private FileManager fm;
	private EventList evs;
	private EventDialog adderDialog;
	private EventDialog delDialog;
	private JLabel label;
	private JLabel[] calLabels;
	private int month = Calendar.getInstance().get(Calendar.MONTH);
    private int year = Calendar.getInstance().get(Calendar.YEAR);

	public MyCalendar()
	{
		super("My Calendar");
		setSize(800, 350);
		fm = new FileManager("events.txt");
		evs = fm.deserialize();
        addWindowListener(new MyWindowAdapter());
        
		adderDialog = new AddEventDialog(this, evs);
		delDialog = new DeleteEventDialog(this, evs);
		
		//Menü és menüpontok
		JMenuBar menu = new JMenuBar();
		JMenu m1 = new JMenu("Manage events");
		JMenuItem mi1 = new JMenuItem("Add event");
		mi1.addActionListener(new AddEventListener());
		m1.add(mi1);
		m1.addSeparator();
		JMenuItem mi2 = new JMenuItem("Delete event");
		mi2.addActionListener(new DeleteEventListener());
		m1.add(mi2);
	    menu.add(m1);

	    //Nyilak és aktuális hónap)
		JPanel panel1 = new JPanel(new GridLayout(1,3));
		label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		JButton left = new JButton("<");
		left.setBackground(Color.white);
		left.addActionListener(new LeftButtonListener());
	    JButton right = new JButton(">");
		right.setBackground(Color.white);
		right.addActionListener(new RightButtonListener());
		panel1.add(left, BorderLayout.WEST);
	    panel1.add(label, BorderLayout.CENTER);
		panel1.add(right, BorderLayout.EAST);
	    
		//A naptár napjai
	    JPanel panel2 = new JPanel(new GridLayout(7, 7));
	    calLabels = new JLabel[49];
	    String[] header = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
	    for (int i=0; i<calLabels.length; i++)
	    {		
	    	calLabels[i] = new JLabel();
	    	calLabels[i].setOpaque(true);
	    	calLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
	    	calLabels[i].setBorder(BorderFactory.createLineBorder(Color.black));
	    	calLabels[i].setBackground(Color.white);
	    	calLabels[i].setPreferredSize(new Dimension(35, 35));
	    	panel2.add(calLabels[i]);
	    	if (i<7)
	    	{
	    		calLabels[i].setText(header[i]);
	    		calLabels[i].setBackground(Color.pink);
	    	}
	    }
	    
	    add(menu, BorderLayout.NORTH);
		add(panel1, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);
		setCalendar();
	}

	private class MyWindowAdapter extends WindowAdapter
	{
		@Override
        public void windowClosing(WindowEvent e)
        {
        	fm.serialize(evs);
        }
	}
	
	private class LeftButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			if (month == 0)
			{
				year--;
				month = 11;
			}
			else
				month--;
		    setCalendar();
		}
	}
	  
	private class RightButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			if (month == 11)
			{
				year++;
				month = 0;
			}
			else
				month++;
		    setCalendar();
		}
	}
  
	private class AddEventListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			adderDialog.setVisible(true);
		}
	}
  
	private class DeleteEventListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			delDialog.setVisible(true);
		}
	}
  
	private void setCalendar()
	{
	      for (int i = 7; i < calLabels.length; i++)
	      {
	    	  calLabels[i].setBackground(Color.WHITE);
	    	  calLabels[i].setText("");
	      }
	      java.util.Calendar cal = java.util.Calendar.getInstance();
	      cal.set(year, month, 1);
	      int i=5+cal.get(java.util.Calendar.DAY_OF_WEEK);
	      if (i < 7)
	    	  i+=7;
	      for (int day = 1; day <= cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH); day++)
	      {
	    	  String currentEvent = evs.shareEvent(new Event(year, month+1, day));
	    	  if (currentEvent != null)
	    	  {
	    		  calLabels[i].setBackground(Color.LIGHT_GRAY);
	    		  calLabels[i].setText("<html>" + day + "<br>" + currentEvent + "</html>");
	    	  }
	    	  else
	    		  calLabels[i].setText("" + day);
	    	  i++;
	      }
	      label.setText(new java.text.SimpleDateFormat("MMMM yyyy").format(cal.getTime()));
	}
  
	@Override
	public void revalidate()
	{
		setCalendar();
	}
}