package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.Employee;

public class EmployeeDAO {
	public ArrayList<Employee> listEmployees() {
		try {
			ArrayList<Employee> result = new ArrayList<Employee>();
			ResultSet resultSet = new DBConn().queryDB("SELECT * FROM employee");
			while (resultSet.next()) {
				result.add(new Employee(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getDate("dob"), resultSet.getString("gioitinh"), resultSet.getString("chucvu")));
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Employee>();
	}
	public void addEmployee(Employee employee) {
		try {
			new DBConn().updateDB("INSERT INTO employee(name, dob, gioitinh, chucvu) VALUES('"+employee.getName()+"', '"+employee.getDateOfBirth()+"', '"+employee.getGioiTinh()+"','"+employee.getPosition()+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void editEmployee(Employee employee) {
		try {
			new DBConn().updateDB("UPDATE employee SET name = '"+employee.getName()+"', dob = '"+employee.getDateOfBirth()+"', gioitinh = '"+employee.getGioiTinh()+"', chucvu = '"+employee.getPosition()+"' WHERE id = '"+employee.getId()+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean isExist(Employee employee) {
		ResultSet resultSet = null;
		try {
			resultSet = new DBConn().queryDB("SELECT * FROM employee WHERE id = '"+employee.getId()+"'");
			if (resultSet.next()) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public void deleteEmployee(Employee employee) {
		try {
			new DBConn().updateDB("DELETE FROM employee WHERE id = '"+employee.getId()+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
