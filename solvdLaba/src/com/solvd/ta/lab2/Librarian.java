package com.solvd.ta.lab2;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

interface CustomerService {
	public void greet();

	public void salutation();
}

public class Librarian {
	Scanner sc = new Scanner(System.in);
	private String name;
	private static Logger logger = LogManager.getLogger(Librarian.class.getName());

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
		System.out.println("Hi I'm " + this.name + ", I'm the librarian. How can I help you?");
	}

	public void salutation() {
		System.out.println("I hope you found what you are looking for! Take care and goodbye!");
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
		logger.info("Testing");
		System.out.println("Enter a number");
		System.out.println("1. View Collection");
		System.out.println("2. Register");
		System.out.println("3. Set preferences");
		System.out.println("4. View Cart");
		System.out.println("5. Check Out");
		System.out.println("6. Exit");
	}

	public void printPrefMenu() {
		System.out.println("Enter a number");
		System.out.println("1. Add Genre");
		System.out.println("2. Remove Genre");
		System.out.println("3. Exit");
	}

	public void printCartMenu() {
		System.out.println("Enter a number");
		System.out.println("1. Checkout");
		System.out.println("2. Work in progress");
		System.out.println("3. Exit");
	}
}
