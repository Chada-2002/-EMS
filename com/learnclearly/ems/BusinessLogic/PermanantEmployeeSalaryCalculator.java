package com.learnclearly.ems.BusinessLogic;

import com.learnclearly.ems.dto.Employee;

public class PermanantEmployeeSalaryCalculator extends SalaryCalculator {

	@Override
	public void calculateNetSalary(Employee e, int actualSalary) {
		
		int grossSalary = getGrossSalary(e, actualSalary);
		
		int incomeTax =1000;
		int pf = 800;
		int gratuity = 100;
		
		int netSalary = grossSalary -(incomeTax +pf +gratuity);
		
		System.out.println("Permanent Employee salary Details");
		System.out.println("Empid = " +e.getEmpid());
		System.out.println("Empname = "+e.getEmpname());
		System.out.println("Designation =" + e.getDesignation());
		System.out.println("GrossSalary =" +grossSalary);
		System.out.println("Net Salary =" +netSalary);
		System.out.println("Deductions = " + (pf+incomeTax+gratuity));
		
		
		
	}

	
		
	}

	

