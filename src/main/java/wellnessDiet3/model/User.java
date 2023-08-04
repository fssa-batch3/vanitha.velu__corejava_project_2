package wellnessDiet3.model;

public class User {

	private int userID;
	private String username;
	public String email;
	public String password;
	
	public User(String username, String email, String password) {
		super();
		this.userID = userID;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public String toString() {
		return "UserID: " + userID + "username: " + username +  "Email: " + email + " Password: " + password;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
