package com.learnclearly.ems.main;

import com.learnclearly.ems.BusinessLogic.ContractEmployeeSalaryCalculator;
import com.learnclearly.ems.BusinessLogic.PermanantEmployeeSalaryCalculator;
import com.learnclearly.ems.dto.Employee;

public class EmployeeSalaryMain {
	public static void main(String[]a) {

	
	PermanantEmployeeSalaryCalculator pe = new PermanantEmployeeSalaryCalculator();
	
	pe.calculateNetSalary(new Employee(1234,"A", "Clerk",28), 30000);
	
	
	System.out.println("*********************");
	ContractEmployeeSalaryCalculator ce = new ContractEmployeeSalaryCalculator();
	ce.calculateNetSalary(new Employee(4321,"B", "Manager",20), 50000);
	
}
}