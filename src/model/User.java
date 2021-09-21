package model;

public class User {
	private String username;
	private String password;
	private String oldusername;
	private String newusername;
	private String deleteuser;
	
	
	public String getDeleteuser() {
		return deleteuser;
	}
	public void setDeleteuser(String deleteuser) {
		this.deleteuser = deleteuser;
	}
	public String getOldusername() {
		return oldusername;
	}
	public void setOldusername(String oldusername) {
		this.oldusername = oldusername;
	}
	public String getNewusername() {
		return newusername;
	}
	public void setNewusername(String newusername) {
		this.newusername = newusername;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
