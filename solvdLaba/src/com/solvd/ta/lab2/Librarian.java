package com.solvd.ta.lab2;

import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.ta.lab2.interfaces.CustomerService;

public class Librarian implements CustomerService {
	Scanner sc = new Scanner(System.in);
	private String name;
	private static final Logger LOGGER = LogManager.getLogger(Librarian.class.getName());
	BiPredicate<Integer, Integer> greaterThanMax = (x, max) -> x > max;
	Predicate<Integer> lessThanZero = x -> x <= 0;

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

	// input validation where it would continue to loop if the input is outside 0 -
	// max
	public int inputCheck(int input, int max) {
		while (lessThanZero.test(input) || greaterThanMax.test(input, max)) {
			System.out.println("Input invalid! Try again!");
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
		LOGGER.info("7. Exit");
	}

	public void printPrefMenu() {
		LOGGER.info("Enter a number");
		LOGGER.info("1. Add Genre");
		LOGGER.info("2. Remove Genre");
		LOGGER.info("3. Exit");
	}

	public void printCartMenu() {
		LOGGER.info("Enter a number");
		LOGGER.info("1. Checkout");
		LOGGER.info("2. Work in progress");
		LOGGER.info("3. Exit");
	}
}
