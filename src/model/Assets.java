package model;

public class Assets {
	private int assetID;
	private String userID, coinID;
	private Float soa;
	
	public Assets(int assetID, String userID, String coinID, Float soa) {
		super();
		this.assetID = assetID;
		this.userID = userID;
		this.coinID = coinID;
		this.soa = soa;
	}

	public int getAssetID() {
		return assetID;
	}

	public void setAssetID(int assetID) {
		this.assetID = assetID;
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

	public Float getSoa() {
		return soa;
	}

	public void setSoa(Float soa) {
		this.soa = soa;
	}
	
}
