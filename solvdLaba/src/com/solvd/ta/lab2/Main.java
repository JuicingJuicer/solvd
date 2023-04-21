package com.solvd.ta.lab2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Library library = new Library("Juice Library", "Stockton");
		Librarian librarian = new Librarian("John");
		Storage storage = new Storage();
		Cart cart = new Cart();
		Populate populate = new Populate();
		int input;

		// generates media objects and clones it to storage
		populate.generateItems();
		storage.cloneItems(populate.getArr());

		library.greetings();
		librarian.greet();

		do {
			librarian.printMenu();
			input = sc.nextInt();

			switch (input) {
			case 1:
				storage.printInventory();
				break;
			case 2:
				Member member = new Member();
				librarian.setIsRegistered(true);
				System.out.println("Your id number is " + member.getId());
				System.out.println("Make sure you remember it!");
				break;
			case 3:
				System.out.println("Work in progress!");
				break;
			case 4:
				System.out.println("Work in progress!");
				break;
			case 5:
				System.out.println("Work in progress!");
				break;
			case 6:
				break;
			default:
				System.out.println("Enter a number between 0-6!!!");
			}

		} while (input != 6);

	}
}
