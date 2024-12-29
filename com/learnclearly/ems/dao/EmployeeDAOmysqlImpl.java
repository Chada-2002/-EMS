package com.learnclearly.ems.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.LinkedList;
import java.util.List;

import com.learnclearly.ems.dto.Employee;
import com.learnclearly.ems.exception.EmployeeNotFoundException;

public class EmployeeDAOmysqlImpl implements IEmployeeDAO {

	
	private Connection cn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	public static  final String INSERT_COMMAND = "INSERT INTO employee VALUES(?,?,?,?)";
	public static final String UPDATE_COMMAND = "UPDATE employee SET  empname=?,designation=?, dayattendance=? WHERE empid=?";
	public static final String DELETE_COMMAND ="DELETE FROM employee WHERE empid =?";
	public static final String FIND_COMMAND = "SELECT * FROM employee WHERE empid=?";
	public static final String SELECT_ALL ="SELECT *FROM employee";
	
	public EmployeeDAOmysqlImpl() {
		try {
			cn = DriverManager.getConnection(IEmployeeDAO.url, IEmployeeDAO.username, IEmployeeDAO.password);
		} catch (SQLException e) {
			System.out.println("Unable to establish connection with database");
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void addEmployee(Employee e) {
		
		    int rowsAffected = 0;
		    try {
		        // Prepare the SQL command for insertion
		        pst = cn.prepareStatement(INSERT_COMMAND);
		        pst.setInt(1, e.getEmpid());
		        pst.setString(2, e.getEmpname());
		        pst.setString(3, e.getDesignation());
		        pst.setInt(4, e.getDaysAttended());
		        
		        // Execute the insert command
		        rowsAffected = pst.executeUpdate();
		        
		        if (rowsAffected > 0) {
		            System.out.println("Record added successfully.");
		        } else {
		            System.out.println("No records added.");
		        }
		    } catch (SQLIntegrityConstraintViolationException ex) {
		        // Handle duplicate key error
		        System.out.println("Error: Employee with empid " + e.getEmpid() + " already exists.");
		        ex.printStackTrace();
		    } catch (SQLException ex) {
		        // Handle other SQL exceptions
		        System.out.println("Adding record failed. Unable to execute INSERT_COMMAND.");
		        ex.printStackTrace();
		    } finally {
		        // Ensure resources are closed properly
		        if (pst != null) {
		            try {
		                pst.close();
		            } catch (SQLException ex) {
		                System.out.println("Failed to close PreparedStatement.");
		                ex.printStackTrace();
		            }
		        }
		    }
		}

	/*
	 * int i =0; try { pst = cn.prepareStatement(INSERT_COMMAND); pst.setInt(1,
	 * e.getEmpid()); pst.setString(2, e.getEmpname()); pst.setString(3,
	 * e.getDesignation()); pst.setInt(4, e.getDaysAttended()); i =
	 * pst.executeUpdate();
	 * 
	 * 
	 * 
	 * 
	 * 
	 * } catch (SQLException e1) {
	 * System.out.println("Adding record failed.. Unable to execute INSERT_COMMAND"
	 * ); e1.printStackTrace(); }finally { try { pst.close(); } catch (SQLException
	 * e1) { // TODO Auto-generated catch block e1.printStackTrace(); } }
	 * 
	 * if(i>0) { System.out.println("record added...");
	 * 
	 * } }
	 */

	@Override
	public void deleteEmployee(int empid) {
	
		int i=0;
		
		try {
			pst = cn.prepareStatement(DELETE_COMMAND);
			pst.setInt(1, empid);
			i = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("delete operation failed..unable to execute delete command");
			
			e.printStackTrace();
		}finally {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(i>0) {
			System.out.println("Record deleted successfully");
		}
		
	}

	@Override
	public void updateEmployee(Employee e) {
		
		int i =0;
		try {
			pst = cn.prepareStatement(UPDATE_COMMAND);
			pst.setInt(4, e.getEmpid());
			pst.setString(1, e.getEmpname());
			pst.setString(2, e.getDesignation());
			pst.setInt(3, e.getDaysAttended());
			 i = pst.executeUpdate();
		} catch (SQLException e1) {
			System.out.println("Update opeartion failed..unableto execute update command ");
			e1.printStackTrace();
		}finally {
			try {
				pst.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(i>0) {
				System.out.println("Record updated successfully");
			}
		}
		
		
		 
		
	}

	@Override
	public Employee findEmployee(Employee e) throws EmployeeNotFoundException {
		
		Employee findTemp = null;
		try {
			pst = cn.prepareStatement(FIND_COMMAND);
			pst.setInt(1,e.getEmpid());
			rs = pst.executeQuery();
			
			if(!rs.next()) {
				throw new EmployeeNotFoundException(e.getEmpid());
				
						
			}
			findTemp = new Employee();
			findTemp.setEmpname(rs.getString("empname"));
			findTemp.setDesignation(rs.getString("designation"));
			findTemp.setDaysAttended(rs.getInt("dayattendance"));
			findTemp.setEmpid(e.getEmpid());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (EmployeeNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
		try {
			pst.close();
			rs.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		
		return findTemp;
	}

	@Override
	public List<Employee> showAllEmployees() {
		
		Employee selectAllTemp = null;
		List<Employee> elist = new LinkedList<>();
		
		try {
			pst = cn.prepareStatement(SELECT_ALL);
			rs=pst.executeQuery();
			while(rs.next()) {
				selectAllTemp = new Employee();
				selectAllTemp.setEmpid(rs.getInt("empid"));
				selectAllTemp.setEmpname(rs.getString("empname"));
				selectAllTemp.setDesignation(rs.getString("designation"));
				selectAllTemp.setDaysAttended(rs.getInt("dayattendance"));
				elist.add(selectAllTemp);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return elist;
	}
	
	

}
