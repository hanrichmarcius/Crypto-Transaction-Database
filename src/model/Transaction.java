package model;

public class Transaction {
	private int transacctionID;
	private String userID, coinID, transaction;
	private float noc;
	
	public Transaction(int transacctionID, String userID, String coinID, String transaction, float noc) {
		super();
		this.transacctionID = transacctionID;
		this.userID = userID;
		this.coinID = coinID;
		this.transaction = transaction;
		this.noc = noc;
	}
	
	public int getTransacctionID() {
		return transacctionID;
	}
	public void setTransacctionID(int transacctionID) {
		this.transacctionID = transacctionID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getCoinID() {
		return coinID;
	}
	public void setCoinID(String coinID) {
		this.coinID = coinID;
	}
	public String getTransaction() {
		return transaction;
	}
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
	public float getNoc() {
		return noc;
	}
	public void setNoc(float noc) {
		this.noc = noc;
	}
	
}
