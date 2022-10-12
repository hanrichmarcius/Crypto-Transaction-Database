package model;

public class User {
	private String userID, name;
	private int balance;
 
	public User(String userID, String name, int balance) {
		super();
		this.userID = userID;
		this.name = name;
		this.balance = balance;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
