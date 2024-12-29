package com.learnclearly.ems.dto;

public class Employee {
	
	    private int empid;
		private String empname;
		private String designation;
		private int dayattendance;
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Employee(int empid, String empname, String designation, int dayattendance) {
			super();
			this.empid = empid;
			this.empname = empname;
			this.designation = designation;
			this.dayattendance = dayattendance;
		}
		public int getEmpid() {
			return empid;
		}
		public void setEmpid(int empid) {
			this.empid = empid;
		}
		public String getEmpname() {
			return empname;
		}
		public void setEmpname(String empname) {
			this.empname = empname;
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		public int getDaysAttended() {
			return dayattendance;
		}
		public void setDaysAttended(int daysAttended) {
			this.dayattendance = daysAttended;
		}
		
		
		
	}

 
