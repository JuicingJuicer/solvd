package com.solvd.ta.lab2;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.ta.lab2.Exceptions.AlreadyRegisteredException;
import com.solvd.ta.lab2.Exceptions.CartIsEmptyException;
import com.solvd.ta.lab2.Exceptions.NotRegisteredException;

public class Main {
	private static final Logger logger = LogManager.getLogger(Main.class);

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
					logger.info("Select an item: ");
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
							logger.info("Adding to cart");
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
							logger.info("Registered!");
							logger.info("Your id number is " + member.getId());
							logger.info("Make sure you remember it!");
						}
					} catch (AlreadyRegisteredException e) {
						logger.error(e);
						logger.info("ID: " + member.getId());
					}
					break;
				case 3:
					try {
						if (member.checkRegistration()) {
							logger.info("Setting up preferences");
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
							logger.info("Checking out ...");
							cart.filteredArr.clear();
//							member.setMyItems(cart.checkout());
						}
					} catch (CartIsEmptyException e) {
						logger.error(e);
					}
					break;
				case 6:
					try {
						if (member.checkRegistration()) {
							logger.info("Your ID: " + member.id);
							logger.info("Your items: ");
							logger.info("Work in progress!!!");
//							member.printMyItems();
						}
					} catch (NotRegisteredException e) {
						logger.error(e);
					}
					break;
				case 7:
					librarian.salutation();
					break;
				default:
					logger.error("Enter a number between 1-7!!!");
				}

			} while (input != 7);
		} catch (Exception e) {
			logger.error(e);
		}
	}
}
