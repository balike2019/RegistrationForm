package za.co.register.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import za.co.register.dao.JdbcConnection;
import za.co.register.models.Staff;
import za.co.register.models.User;

public class StaffService {
	private List<User>users=new ArrayList<User>();
	int userRowsAffected=0;
    int staffRowsAffected=0;
	private User User;
	//ResultSet resultset;
	//JdbcConnection jdbc=new JdbcConnection();
	public  int registerStaff(Staff staff,User user) {
		
String staffQuery = "INSERT INTO staff(first_name, last_name, email, phone_number)"
				+ "VALUES('" + staff.getFirstName() + "','" + staff.getLastName() + "','"
				+ staff.getEmail() + "','" + staff.getPhoneNumber() + "')";
	
	String userQuery="INSERT INTO users(username,password)VALUES("
	+ "'" +user.getUsername()+"','"+user.getPassword() + "')";
		this.User=user;
		
		try {
		userRowsAffected=JdbcConnection.executeQuery(userQuery);
		staffRowsAffected=JdbcConnection.executeQuery(staffQuery);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return staffRowsAffected + userRowsAffected;
		
}
public boolean login(User user) {
	
	String username;
	String password;
	boolean status=false;
	//String loginquery="SELECT * FROM users"; 
	try {
		String loginquery="SELECT * FROM users"; 
	 ResultSet resultset=JdbcConnection.getResultSet(loginquery);
	
	while(resultset.next()) {
		
	username =resultset.getString("username");	
	password=resultset.getString("password");	
		
		this.User=new User(username,password);
		this.users.add(this.User);
	}
	for(User userdetail:this.users){
	if(User.equals(userdetail)) {
		status=true;
		System.out.println("you have successfully login");
		break;
	
		
	
		
	}
		
	}
	}catch(SQLException e) {
		e.printStackTrace();
		
	}
	return status;
		
		
	}		
		
}	
		
		
		
	
		
		
		
		
		
	
		
		
		

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


