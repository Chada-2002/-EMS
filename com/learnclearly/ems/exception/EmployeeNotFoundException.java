package com.learnclearly.ems.exception;

public class EmployeeNotFoundException extends Exception {

	
	private int empid;
	public EmployeeNotFoundException(int empid) {
		this.empid = empid;
	}
	
	public String toString() {
		
		return "Employee Not Found Exception" + this.empid;
		
	}

}
