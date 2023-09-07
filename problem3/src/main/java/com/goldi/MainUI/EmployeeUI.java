package com.goldi.MainUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeUI {
	
	
	public void getAllEmployee(Scanner sc) {
		try {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","user1","Singh@851127");
			String query="select * from employee";
			
			
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet resultset=ps.executeQuery();
			if(!resultset.isBeforeFirst() && resultset.getRow() == 0) {
				//System.out.println("NO result found");
				throw new RuntimeException("No result found");
			}
			List<Employee> emplist=new ArrayList<>();
			
			while(resultset.next()) {
				Employee emp = new Employee();
				emp.setName(resultset.getString(1));
				emp.setAge(resultset.getInt(2));
				emplist.add(emp);
			}
			emplist.forEach(s -> System.out.println(s));
			
		   
			
		} catch (SQLException | RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		EmployeeUI empUi = new EmployeeUI();
		empUi.getAllEmployee(new Scanner(System.in));
		
		
	}

}
