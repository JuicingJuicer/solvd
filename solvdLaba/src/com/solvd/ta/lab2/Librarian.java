package com.solvd.ta.lab2;

import java.util.Scanner;
import java.util.function.BiPredicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.ta.lab2.interfaces.CustomerService;

public class Librarian implements CustomerService {
	Scanner sc = new Scanner(System.in);
	private String name;
	private static final Logger LOGGER = LogManager.getLogger(Librarian.class.getName());

	public Librarian(String name) {
		this.setName(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void greet() {
		LOGGER.info("Hi I'm " + this.name + ", I'm the librarian. How can I help you?");
	}

	public void salutation() {
		LOGGER.info("I hope you found what you are looking for! Take care and goodbye!");
	}

	// input validation where it would continue to loop based on the lambda
	public int inputCheck(int input, int max, BiPredicate<Integer, Integer> rules) {
		while (rules.test(input, max)) {
			LOGGER.info("Input invalid! Try again!");
			input = sc.nextInt();
		}
		return input;
	}

	public void printMenu() {
		LOGGER.info("Enter a number");
		LOGGER.info("1. View Items");
		LOGGER.info("2. Register");
		LOGGER.info("3. Set preferences");
		LOGGER.info("4. View Cart");
		LOGGER.info("5. Check Out");
		LOGGER.info("6. View My Profile");
		LOGGER.info("7. Search");
		LOGGER.info("8. Random Stats");
		LOGGER.info("9. Exit");
	}

	public void printPrefMenu() {
		LOGGER.info("Enter a number");
		LOGGER.info("1. Add Genre");
		LOGGER.info("2. Remove Genre");
		LOGGER.info("3. Exit");
	}

	public void printSearchMenu() {
		LOGGER.info(
				"Enter a number\nSearch via ... \n1. via Serial number\n2. via Title\n3. via Type\n4. via Author\n5. via Books over x pages\n6. via Movies over x IMDb rating\n7. Movies over x minutes");
	}

	public void printStatsMenu() {
		LOGGER.info(
				"Enter a number\n1. Average number of pages of all books\n2. Movie with the highest IMDb score\n3. Total runtime of all movies");
	}
}
