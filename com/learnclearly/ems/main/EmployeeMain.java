package com.learnclearly.ems.main;


import java.util.List;

import com.learnclearly.ems.dto.Employee;
import com.learnclearly.ems.exception.EmployeeNotFoundException;
import com.learnclearly.ems.service.EmployeeServiceImpl;
import com.learnclearly.ems.service.IEmployeeService;

public class EmployeeMain {
	
	public static void main(String[]a) {
	
	IEmployeeService eservice = new EmployeeServiceImpl();
	

	eservice.addEmployee(new Employee(1, "Abc" , "Manager",28));
	eservice.addEmployee(new Employee(2, "Bcd" , "Clerk",30));
	eservice.addEmployee(new Employee(3, "Cde" , "Salesman", 29));
	eservice.addEmployee(new Employee(4, "Def" , "Accountant", 30));
	
	System.out.println(" ");
	
	List<Employee> elist = eservice.showAllEmployees();
	for(Employee e :elist ) {
		System.out.println(e.getEmpid()+ " :" +e.getEmpname() + ": "+ e.getDesignation()+ ":"+e.getDaysAttended());
	}

	System.out.println(" ");
	
	
	eservice.deleteEmployee(1);
	
	eservice.updateEmployee(new Employee(2,"updated", "Sr.clerk",29));
	
	try {
		Employee temp = eservice.findEmployee(new Employee (2,"updated","Sr.clerk",29));
		
		System.out.println(temp.getEmpid()+ " " +temp.getEmpname());
	} catch (EmployeeNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}
}