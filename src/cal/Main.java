package cal;
import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		JFrame calendar = new MyCalendar();
		calendar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calendar.setVisible(true);
		calendar.setResizable(false);
  	}
}
