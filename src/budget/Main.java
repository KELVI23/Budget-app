/**
 * Project: Budget Manager
 * File: Main.java
 * Date: Nov. 29, 2021
 * Time: 11:39:17 p.m.
 */
package budget;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Kelvin Musodza, A01085867
 *
 */
public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static double balance;
	private static HashMap<String, Double> purchases = new HashMap<>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		instructions();
		boolean quit = false;
		do {

			int choice = scanner.nextInt();

			switch (choice) {

			case 0:
				System.out.println("\nBye!");
				quit = true;
				break;

			case 1:
				System.out.println("\n\nEnter income:");
				addIncome();
				instructions();
				break;

			case 2:
				System.out.println("\n\nEnter purchase name:");
				addPurchases();
				instructions();
				break;

			case 3:
				showPurchaseList();
				instructions();
				break;

			case 4:
				if (balance < 0) {
					balance = 0;
				}
				System.out.format("\nBalance: $%.2f\n\n", balance);
				instructions();
				break;

			// default:
			// System.out.println("Unrecognized entry");
			// instructions();
			// quit = true;
			// break;
			}

		} while (!quit);

	}

	public static void instructions() {
		System.out.println("Choose your action:\n"//
				+ "1) Add income\n" //
				+ "2) Add purchase\n" //
				+ "3) Show list of purchases\n"//
				+ "4) Balance\n" //
				+ "0) Exit");

	}

	public static void addIncome() {

		// while (scanner.hasNext()) {
		double money = scanner.nextDouble();
		balance += money;

		// }
		// scanner.close();
		System.out.println("Income was added! \n\n");
	}

	public static void addPurchases() {
		double money = 0;
		String purchaseName = null;

		scanner.nextLine();
		purchaseName = scanner.nextLine();
		System.out.println("Enter its price:");

		money = scanner.nextDouble();
		balance -= money;
		purchases.put(purchaseName, money);

		System.out.println("Purchase was added! \n\n");

	}

	@SuppressWarnings("rawtypes")
	public static void showPurchaseList() {
		double total = 0.0;
		// String items = purchases.susbtring(0, purchases.lastIndexOf("$")));
		// double money = Double.parseDouble(purchases.substring(purchases.lastIndexOf("$") + 1));
		// System.out.println("Income was added! ");

		if (purchases.isEmpty()) {
			System.out.println("\n\nThe purchase list is empty\n\n");
		}

		else {

			for (HashMap.Entry mapElement : purchases.entrySet()) {
				String key = (String) mapElement.getKey();
				double value = ((double) mapElement.getValue());
				System.out.format("\n%s $%.2f", key, value);

				total += value;
			}

			System.out.format("Total sum: $%.2f\n\n", total);
		}
	}
}
