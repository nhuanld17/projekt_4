package DTO;

import java.sql.Date;

public class Employee {
	private int id;
	private String name;
	private Date dateOfBirth;
	private String gioiTinh;
	private String position;
	
	public Employee(int id, String name, Date dateOfBirth, String gioiTinh, String position) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gioiTinh = gioiTinh;
		this.position = position;
	}
	
	

	public Employee(String name, Date dateOfBirth, String gioiTinh, String position) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gioiTinh = gioiTinh;
		this.position = position;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	public Object[] toObject() {
        return new Object[]{""+id,name,dateOfBirth,gioiTinh,position};
    }
}
