package com.learnclearly.ems.BusinessLogic;

import com.learnclearly.ems.dto.Employee;

 abstract public class SalaryCalculator {

	
	public int getGrossSalary(Employee e, int actualSalary) {
		
		
		
		int grossSalary =0;
		int perDaySalary = actualSalary/30;
		
		grossSalary = perDaySalary * e.getDaysAttended();
		return grossSalary;
	}
	
	
	 abstract public void calculateNetSalary(Employee e , int actualSalary);
}
