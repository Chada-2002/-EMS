package com.learnclearly.ems.service;

import java.util.List;

import com.learnclearly.ems.dao.EmployeeDAOmysqlImpl;
import com.learnclearly.ems.dao.IEmployeeDAO;
import com.learnclearly.ems.dto.Employee;
import com.learnclearly.ems.exception.EmployeeNotFoundException;

public class EmployeeServiceImpl implements IEmployeeService {
	
	private IEmployeeDAO empDao = new EmployeeDAOmysqlImpl();

	public void addEmployee(Employee e) {
		empDao.addEmployee(e);
		
	}

	public void deleteEmployee(int empid) {
	empDao.deleteEmployee(empid);
		
	}

	public void updateEmployee(Employee e) {
		empDao.updateEmployee(e);
		
	}

	public Employee findEmployee(Employee e) throws EmployeeNotFoundException {
		
		return empDao.findEmployee(e);
	}

	public List<Employee> showAllEmployees() {
		
		return empDao.showAllEmployees();
	}

}
