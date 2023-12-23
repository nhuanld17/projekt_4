package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.EmployeeGUI;

public class EmployeeController implements ActionListener{
	private EmployeeGUI employeeGUI;

	public EmployeeController(EmployeeGUI employeeGUI) {
		this.employeeGUI = employeeGUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		
		if (name.equals("THÊM")) {
			employeeGUI.setEmptyForm();
		}
		if (name.equals("LƯU")) {
			employeeGUI.save();
		}
		if (name.equals("SỬA")) {
			employeeGUI.edit();
		}
		if (name.equals("CẬP NHẬT")) {
			employeeGUI.update();
		}
		if (name.equals("XÓA")) {
			employeeGUI.delete();
		}
	}
}
