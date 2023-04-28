package com.solvd.ta.lab2;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private static Logger logger = LogManager.getLogger(Main.class.getName());

	public static void main(String[] args) {
		Library library = new Library("Juice Library", "Stockton");
		Librarian librarian = new Librarian("John");
		Member member = new Member("Kawhi");
		Storage storage = new Storage();
		Cart cart = new Cart();
		int input, selection, choice;

		// generates media objects and clones it to storage
		storage.cloneItems(Populate.generateItems());

		library.greetings();
		librarian.greet();

		// try-catch with resources
		try (Scanner sc = new Scanner(System.in)) {
			do {
				librarian.printMenu();
				input = sc.nextInt();

				switch (input) {
				case 1:
					storage.printInventory();

					// media selection
					System.out.println("Select an item: ");
					selection = sc.nextInt();
					selection = librarian.inputCheck(selection, storage.filteredArr.size());

					// media actions
					storage.selectionMenu(selection);
					choice = sc.nextInt();
					choice = librarian.inputCheck(choice, 3);

					// view details/add to cart
					if (choice == 1) {
						storage.printDetails(selection);
						break;
					}
					try {
						if (choice == 2 && member.checkRegistration()) {
							System.out.println("Adding to cart");
							cart.addToCart(storage.filteredArr.get(selection - 1));
							storage.removeFromBoth(storage.filteredArr.get(selection - 1));
							cart.printCart();
						}
					} catch (NotRegisteredException e) {
						logger.error(e);
					}
					break;
				case 2:
					try {
						if (member.checkNewMember()) {
							member.setIsRegistered(true);
							System.out.println("Registered!");
							System.out.println("Your id number is " + member.getId());
							System.out.println("Make sure you remember it!");
						}
					} catch (AlreadyRegisteredException e) {
						logger.error(e);
						System.out.println("ID: " + member.getId());
					}
					break;
				case 3:
					try {
						if (member.checkRegistration()) {
							System.out.println("Setting up preferences");
							member.firstTimeSetup();
							// preference adding and removing loop
							do {
								// print and ask for genre to add/remove
								member.printBothSets();
								librarian.printPrefMenu();
								selection = sc.nextInt();

								// adding, removing, exit
								if (selection == 1 || selection == 2) {
									member.addRemoveSwitch(selection);
								} else if (selection == 3) {
									storage.filterItems(member.getPreferences());
								}
							} while (selection != 3);
						}
					} catch (NotRegisteredException e) {
						logger.error(e);
					}
					break;
				case 4:
					cart.printCart();
					break;
				case 5:
					try {
						if (cart.checkNotEmpty()) {
							cart.checkout();
						}
					} catch (CartIsEmptyException e) {
						logger.error(e);
					}
					break;
				case 6:
					librarian.salutation();
					break;
				default:
					System.out.println("Enter a number between 1-6!!!");
				}

			} while (input != 6);
		} catch (Exception e) {
			logger.error(e);
		}
	}
}
