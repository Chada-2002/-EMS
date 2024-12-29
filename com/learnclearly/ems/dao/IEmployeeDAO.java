package com.learnclearly.ems.dao;

import java.util.List;

import com.learnclearly.ems.dto.Employee;
import com.learnclearly.ems.exception.EmployeeNotFoundException;

public interface IEmployeeDAO {
	
	public abstract void addEmployee(Employee e);
	
    public abstract void deleteEmployee( int empid);
    
    public abstract void updateEmployee(Employee e);
    
    public abstract Employee findEmployee(Employee e) throws EmployeeNotFoundException;
    
    public List<Employee> showAllEmployees();
    
    public static final String url = "jdbc:mysql://localhost:3306/sys";
    
    public static final String username = "root";
    
    public static final String  password = "1234";
    
   // public static final DRIVER_CLASSNAME = "com.mysql.jdbc.Driver";
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
