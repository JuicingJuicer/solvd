package com.solvd.ta.lab2;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.ta.lab2.Interfaces.CustomerService;

public class Librarian implements CustomerService {
	Scanner sc = new Scanner(System.in);
	private String name;
	private static final Logger logger = LogManager.getLogger(Librarian.class.getName());

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
		logger.info("Hi I'm " + this.name + ", I'm the librarian. How can I help you?");
	}

	public void salutation() {
		logger.info("I hope you found what you are looking for! Take care and goodbye!");
	}

	// input validation where it would continue to loop if the input is outside 0 -
	// max
	public int inputCheck(int input, int max) {
		while (input <= 0 || input > max) {
			System.out.println("Input invalid! Try again!");
			input = sc.nextInt();
		}
		return input;
	}

	public void printMenu() {
		logger.info("Enter a number");
		logger.info("1. View Collection");
		logger.info("2. Register");
		logger.info("3. Set preferences");
		logger.info("4. View Cart");
		logger.info("5. Check Out");
		logger.info("6. Exit");
	}

	public void printPrefMenu() {
		logger.info("Enter a number");
		logger.info("1. Add Genre");
		logger.info("2. Remove Genre");
		logger.info("3. Exit");
	}

	public void printCartMenu() {
		logger.info("Enter a number");
		logger.info("1. Checkout");
		logger.info("2. Work in progress");
		logger.info("3. Exit");
	}
}
