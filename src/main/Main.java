package main;

import java.util.Scanner;

import facade.TransactionFacade;

public class Main {

	Scanner scan = new Scanner(System.in);
	
	public Main() {
		// TODO Auto-generated constructor stub
		
		int input = 0;
		
		do {
			System.out.println("");
			System.out.println("CRYPTO TRANSACTION");
			System.out.println("=============================");
			System.out.println("1. View User Transaction");
			System.out.println("2. View Sum Transaction");
			System.out.println("3. Process Transactions");
			System.out.println("4. Calculate and View Wealth");
			System.out.println("=============================");
			System.out.print(">> ");
			
			try {
				input = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				System.out.println("Please enter a valid number!");
				scan.nextLine();
			}
			
			switch (input) {
			case 1:
				TransactionFacade.viewUserTransaction();
				break;
			case 2:
				TransactionFacade.viewSumTransaction();
				break;
			case 3:
				TransactionFacade.getProcessTransaction();
				break;
			case 4:
				TransactionFacade.calculateandViewWealth();
				break;
			default:
				break;
			}
			
		} while (input!=5);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
