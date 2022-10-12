package model;

public class CryptoCurrency {
	private Double rp_exchange_rate;
	private String CoinID, coin_name;
	
	
	public CryptoCurrency(Double rp_exchange_rate, String coinID, String coin_name) {
		super();
		this.rp_exchange_rate = rp_exchange_rate;
		CoinID = coinID;
		this.coin_name = coin_name;
	}
	
	public Double getRp_exchange_rate() {
		return rp_exchange_rate;
	}
	public void setRp_exchange_rate(Double rp_exchange_rate) {
		this.rp_exchange_rate = rp_exchange_rate;
	}
	public String getCoinID() {
		return CoinID;
	}
	public void setCoinID(String coinID) {
		CoinID = coinID;
	}
	public String getCoin_name() {
		return coin_name;
	}
	public void setCoin_name(String coin_name) {
		this.coin_name = coin_name;
	}
	
}
