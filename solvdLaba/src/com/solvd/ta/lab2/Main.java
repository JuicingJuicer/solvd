package com.solvd.ta.lab2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.ta.lab2.exceptions.AlreadyRegisteredException;
import com.solvd.ta.lab2.exceptions.CartIsEmptyException;
import com.solvd.ta.lab2.exceptions.NotRegisteredException;
import com.solvd.ta.lab2.exceptions.OutOfRangeException;

public class Main {
	private static final Logger LOGGER = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
//		Library library = new Library("Juice Library", "Stockton");
		Library library = Library.class.getConstructor(String.class, String.class).newInstance("Juice Library",
				"Stockton");
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
					LOGGER.info("Select an item: ");
					selection = sc.nextInt();
					selection = librarian.inputCheck(selection, storage.filteredArr.size(), (x, y) -> x > y || x <= 0);

					// media actions
					storage.selectionMenu(selection);
					choice = sc.nextInt();
					choice = librarian.inputCheck(choice, 3, (x, y) -> x > y || x <= 0);

					// view details/add to cart
					if (choice == 1) {
						storage.printDetails(selection);
						break;
					}
					try {
						if (choice == 2 && member.checkRegistration()) {
							LOGGER.info("Adding to cart");
							cart.addToCart(storage.filteredArr.get(selection - 1));
							storage.removeFromBoth(storage.filteredArr.get(selection - 1));
							cart.printCart();
						}
					} catch (NotRegisteredException e) {
						LOGGER.error(e);
					}
					break;
				case 2:
					try {
						if (member.checkNewMember()) {
							Class classM = Class.forName("com.solvd.ta.lab2.Member");
							Method setRegisterationMethod = classM.getDeclaredMethod("setIsRegistered", boolean.class);
							setRegisterationMethod.invoke(member, true);
							LOGGER.info("Registered!\nYour ID number is: " + member.getId()
									+ "\nMake sure you remember it!");
						}
					} catch (AlreadyRegisteredException e) {
						LOGGER.error(e);
						LOGGER.info("ID: " + member.getId());
					}
					break;
				case 3:
					try {
						if (member.checkRegistration()) {
							LOGGER.info("Setting up preferences");
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
						LOGGER.error(e);
					}
					break;
				case 4:
					cart.printCart();
					break;
				case 5:
					try {
						if (cart.checkNotEmpty()) {
							member.addMyItems(cart.checkout());
						}
					} catch (CartIsEmptyException e) {
						LOGGER.error(e);
					}
					break;
				case 6:
					try {
						if (member.checkRegistration()) {
							LOGGER.info("Your ID: " + member.id);
							LOGGER.info("Your items: ");
							member.printMyItems();
						}
					} catch (NotRegisteredException e) {
						LOGGER.error(e);
					}
					break;
				case 7:
					librarian.printSearchMenu();
					choice = sc.nextInt();
					storage.search(choice);
					break;
				case 8:
					librarian.printStatsMenu();
					choice = sc.nextInt();
					storage.stats(choice);
					break;
				case 9:
					librarian.salutation();
					break;
				default:
					throw new OutOfRangeException("Enter a number between 1-8!");
//					LOGGER.error("Enter a number between 1-8!");
				}
			} while (input != 8);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}
}
