package facade;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import database.Connect;

public class TransactionFacade {
	
	static Scanner scan = new Scanner(System.in);
	
	//1
	public static void viewUserTransaction() {
		System.out.println("");
		System.out.println("VIEW USER TRANSACTIONS");
		System.out.println("=========================================================");
		System.out.println("| User name | Transaction | Coin Name | Number of coins |");
		System.out.println("=========================================================");
		
		Connect con = Connect.getConnection();
		String query = "SELECT u.user_name, t.transaction, c.coin_name, t.num_of_coins FROM transaction t JOIN user u ON u.UserID = t.UserID JOIN cryptocurrency c ON c.CoinID = t.CoinID";
		
		ResultSet rs = con.executeQuery(query);
	
		try {
			while(rs.next()) {
				System.out.printf("| %-10s| %-12s| %-10s| %-16.3f|\n", rs.getString("user_name"), rs.getString("transaction"), rs.getString("coin_name"), rs.getFloat("num_of_coins"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("=========================================================\n");
		System.out.println("Press enter to continue ...");
		scan.nextLine();
	}
	
	
	//2
	public static void viewSumTransaction() {
		
	System.out.println("");
	System.out.println("VIEW SUM TRANSACTIONS");
	System.out.println("============================================================================================");
	System.out.println("| Coin name | Rp. Exchange Rate | Asset Sold | Asset Bought |     Rp Sold     | Rp Bought  |");
	System.out.println("============================================================================================");
	
	Connect con = Connect.getConnection();
	String query = "SELECT c.coin_name, c.rp_exchange_rate, CASE WHEN t.transaction = 'buy' THEN t.num_of_coins END AS asset_bought, CASE WHEN t.transaction = 'sell' THEN t.num_of_coins END AS asset_sold, CASE WHEN t.transaction = 'buy' THEN t.num_of_coins * C.rp_exchange_rate END AS Rp_bought, CASE WHEN t.transaction = 'sell' THEN t.num_of_coins * c.rp_exchange_rate END AS Rp_sold FROM cryptocurrency c JOIN transaction t ON c.CoinID = t.CoinID GROUP BY c.coin_name";
	
	ResultSet rs = con.executeQuery(query);

	try {
		while(rs.next()) {
			System.out.printf("| %-9s | %-17f | %-10f | %-12f | %-15f | %-10.1f |\n", rs.getString("coin_name"), rs.getFloat("rp_exchange_rate"), rs.getFloat("asset_bought"), rs.getFloat("asset_sold"), rs.getFloat("rp_bought"), rs.getFloat("rp_sold"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("============================================================================================\n");
	System.out.println("Press enter to continue ...");
	scan.nextLine();
}
	
	
	//3
	public static void getProcessTransaction() {
		
		  Connect con = Connect.getConnection();
		  String query = "SELECT u.user_name, t.transaction, c.coin_name, t.num_of_coins, c.rp_exchange_rate, u.rupiah_balance, c.rp_exchange_rate * t.num_of_coins AS value, u.rupiah_balance - (c.rp_exchange_rate * t.num_of_coins) AS remain FROM transaction t JOIN user u ON u.UserID = t.UserID JOIN cryptocurrency c ON c.CoinID = t.CoinID";
		  ResultSet rs = con.executeQuery(query);
		  
		  try {
			  
		   while(rs.next()) {
			   
		    String transaction = rs.getString("transaction");
		    float remain = rs.getFloat("remain");
		    
		    	if(transaction.equals("buy")) {
		    		if(remain < 0) {
		    			System.out.println("buy transaction unsuccessful. ");
		    		} else if (remain > 0) {
		    			
		    			System.out.println("buy transaction successful. ");
		    		}
		    	} else if(transaction.equals("sell")) {
		    		if(remain < 0) {
		    			System.out.println("sell transaction unsuccessful. ");
		    		} else if (remain > 0) {
		    			System.out.println("sell transaction successful. ");
		    		}
		    	}
		   }
		   
		  } catch (SQLException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  	}
	}

	
	//4
	public static void calculateandViewWealth() {
		
		  Connect con = Connect.getConnection();
		  String query = "SELECT u.user_name, SUM(a.sum_of_assets) AS sum_of_assets FROM user u JOIN assets a ON u.UserID = a.UserID";
		  ResultSet rs = con.executeQuery(query);
		  
		  System.out.println("===========================");
		  System.out.println("| Name     | Assets in Rp |");
		  System.out.println("===========================");
		  
		  try {
		   while(rs.next()) {
		    String username = rs.getString("user_name");
		    float number = rs.getFloat("sum_of_assets");
		    
		    System.out.printf("| %-9s| %-13.3f|\n", username, number);
		   }
		  } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		  
		  System.out.println("===========================");
		 }
}
