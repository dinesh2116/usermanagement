package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectionManager.ConnectionManager;
import model.Login;

public class LoginDAO {
	
	public boolean validate(Login login) throws ClassNotFoundException, SQLException {
		String username=login.getUsername();
		String password=login.getPassword();
		
		ConnectionManager conn= new ConnectionManager();
		Connection con= conn.establishConnection();
		Statement st =con.createStatement();
		ResultSet rs = st.executeQuery("select username,password from login");
		
		while(rs.next()) {
			if(username.equals(rs.getString("username"))&& password.equals(rs.getString("password"))) {
				conn.closeConnection();
				return true;
			}
		}
		
		conn.closeConnection();
		return false;
		
	}

}
