package com.solvd.ta.lab2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Library library = new Library("Juice Library", "Stockton");
		Librarian librarian = new Librarian("John");
		Member member = new Member();
		Storage storage = new Storage();
		Cart cart = new Cart();
		int input, selection, choice;
		String option;

		// generates media objects and clones it to storage
		storage.cloneItems(Populate.generateItems());

		library.greetings();
		librarian.greet();

		do {
			librarian.printMenu();
			input = sc.nextInt();

			switch (input) {
			case 1:
				storage.printInventory();

				// item selection
				System.out.println("Select an item: ");
				selection = sc.nextInt();
				selection = librarian.inputCheck(selection, storage.arr.size());

				// item actions
				storage.selectionMenu(selection);
				choice = sc.nextInt();
				choice = librarian.inputCheck(choice, 3);

				// view details
				if (choice == 1) {
					storage.printDetails(selection);
					break;
				}
				// add to cart
				if (choice == 2 && member.getIsRegistered()) {
					System.out.println("Adding to cart");
				} else {
					librarian.printDenial();
				}
				break;
			case 2:
				member.setIsRegistered(true);
				System.out.println("Registered!");
				System.out.println("Your id number is " + member.getId());
				System.out.println("Make sure you remember it!");
				break;
			case 3:
				if (member.getIsRegistered()) {
					System.out.println("Setting up preferences");
					member.firstTimeSetup();
					// preference adding and removing loop
					do {
						// print and ask for genre to add/remove
						member.printBothSets();
						librarian.printPrefMenu();
						selection = sc.nextInt();

						// adding/removing options refactor later
						if (selection == 1) {
							System.out.println("Input the genre to add!");
							sc.nextLine();
							option = sc.nextLine();
							try {
								member.addPreference(option);
							} catch (Exception e) {
								System.out.println("Input the genre correctly!");
							}

						} else if (selection == 2) {
							System.out.println("Input the genre to remove!");
							sc.nextLine();
							option = sc.nextLine();
							try {
								member.removePreference(option);
							} catch (Exception e) {
								System.out.println("Input the genre correctly!");
							}
						}
					} while (selection != 3);
				} else {
					librarian.printDenial();
				}
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
