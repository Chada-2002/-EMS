package com.learnclearly.ems.service;

import java.util.List;

import com.learnclearly.ems.dto.Employee;
import com.learnclearly.ems.exception.EmployeeNotFoundException;

public interface IEmployeeService {
	
public abstract void addEmployee(Employee e);
	
    public abstract void deleteEmployee( int empid);
    
    public abstract void updateEmployee(Employee e);
    
    public abstract Employee findEmployee(Employee e) throws EmployeeNotFoundException;
    
    public List<Employee> showAllEmployees();

}
