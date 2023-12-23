package BUS;

import java.util.ArrayList;

import DAO.EmployeeDAO;
import DTO.Employee;

public class EmployeeBUS {
	public ArrayList<Employee> listEmployees() {
		return new EmployeeDAO().listEmployees();
	}
	public void addEmployee(Employee employee) {
		new EmployeeDAO().addEmployee(employee);
	}
	public void edit(Employee employee) {
		new EmployeeDAO().editEmployee(employee);
	}
	public void delete(Employee employee) {
		new EmployeeDAO().deleteEmployee(employee);
	}
}
