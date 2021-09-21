package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectionManager.ConnectionManager;
import model.User;

public class UserDAO {
	
	public void addUser(User user) throws ClassNotFoundException, SQLException {
		String username= user.getUsername();
		String password= user.getPassword();
		
		ConnectionManager conn =new ConnectionManager();
		Connection con= conn.establishConnection();
		String sql="insert into user(username,password) values(?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,username);
		ps.setString(2, password);
		ps.executeUpdate();
		con.close();
	}
	
	public void edituser(User user) throws ClassNotFoundException, SQLException {
		
		String oldusername=user.getOldusername();
		String newusername=user.getNewusername();
		ConnectionManager conn =new ConnectionManager();
		Connection con= conn.establishConnection();
		String sql="update user set username=? where username=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,newusername );
		ps.setString(2, oldusername);
		ps.executeUpdate();
		con.close();
		
	}
	public void deleteuser(User user) throws ClassNotFoundException, SQLException {
		String deleteuser=user.getDeleteuser();
		ConnectionManager conn =new ConnectionManager();
		Connection con= conn.establishConnection();
		String sql="delete from user where username=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, deleteuser);
		ps.executeUpdate();
		con.close();
		
	}
	public void display(User user) throws ClassNotFoundException, SQLException {
		ConnectionManager conn =new ConnectionManager();
		Connection con= conn.establishConnection();
		Statement st =con.createStatement();
		ResultSet rs= st.executeQuery("select * from user");
		
		while(rs.next()) {
			System.out.println(rs.getString("username")+ " "+ rs.getString("password"));
		}
		con.close();
		
	}
	

}








