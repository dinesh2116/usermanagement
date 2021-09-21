package controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import dao.LoginDAO;
import dao.UserDAO;
import model.Login;
import model.User;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int option,option1;
		
		Login login =new Login();
		LoginDAO logindao = new LoginDAO(); 
		User user =new User();
		UserDAO userdao =new UserDAO();
		
		do {
			System.out.println("1.Admin");
			System.out.println("2.User");
			System.out.println("3.Exit");
			System.out.println("*******************");
			option=Integer.parseInt(br.readLine());
			
			
			
			switch(option) {
			case 1:{
				System.out.println("Welcome to Admin");
				System.out.println("Enter username");
				String username =br.readLine();
				System.out.println("Enter Password");
				String password =br.readLine();
				login.setUsername(username);
				login.setPassword(password);
				
				if(logindao.validate(login)==true) {
					System.out.println("*******************");
					System.out.println("Login successful..!");
					
					do {
						System.out.println("1.Add User");
						System.out.println("2.Edit User");
						System.out.println("3.Delete User");
						System.out.println("4.view User");
						System.out.println("*******************");
						
						option1=Integer.parseInt(br.readLine());
						
						switch(option1) {
						case 1:{
							System.out.println("Welcome to Add User");
							System.out.println("Enter new user name");
							String username1 =br.readLine();
							System.out.println("Enter new password");
							String password1=br.readLine();
							user.setUsername(username1);
							user.setPassword(password1);
							userdao.addUser(user);
							
							System.out.println("User AddeD Successfully....!");
							break;
							
						}
						case 2:{
							System.out.println("Welcome to Edit User");
							System.out.println("Enter old username");
							String oldusername=br.readLine();
							System.out.println("Enter new username");
							String newusername=br.readLine();
							user.setOldusername(oldusername);
							user.setNewusername(newusername);
							userdao.edituser(user);
							System.out.println("Successfully Updated");
							
							break;
							
						}
						
						case 3:{
							System.out.println("Welcome to Delete User");
							System.out.println("Enter the Delete username");
							String deleteuser=br.readLine();
							user.setDeleteuser(deleteuser);
							userdao.deleteuser(user);
							System.out.println("Successfully Deleted");
							break;
							
						}
						case 4:{
							System.out.println("Welcome to view User");
							userdao.display(user);
							break;
							
						}
						}
						
						
						
					}while(option1 !=4);
					
				}
				
			}
			}
			
			
			
		}while(option !=3);

	}

}





