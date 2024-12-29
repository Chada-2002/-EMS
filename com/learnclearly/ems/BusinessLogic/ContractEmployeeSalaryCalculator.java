package com.learnclearly.ems.BusinessLogic;

import com.learnclearly.ems.dto.Employee;

public class ContractEmployeeSalaryCalculator extends SalaryCalculator {

	@Override
	public void calculateNetSalary(Employee e, int actualSalary) {
		
		
int grossSalary = getGrossSalary(e, actualSalary);
		
		int tds = 2000;
		
		int netSalary = grossSalary -tds;
		
		System.out.println("Contract Employee salary Details");
		System.out.println("Empid = " +e.getEmpid());
		System.out.println("Empname = "+e.getEmpname());
		System.out.println("Designation =" + e.getDesignation());
		System.out.println("GrossSalary =" +grossSalary);
		System.out.println("Net Salary =" +netSalary);
		System.out.println("Deductions = " + tds);
		
	}

}
