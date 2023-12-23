package Exception;

import javax.swing.JOptionPane;

public class DateException extends Exception{
	public DateException(String str) {
		JOptionPane.showMessageDialog(null, str);
	}
}
