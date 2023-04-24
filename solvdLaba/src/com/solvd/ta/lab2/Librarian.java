package com.solvd.ta.lab2;

import java.util.Scanner;

public class Librarian {
	Scanner sc = new Scanner(System.in);
	private String name;

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

	public void denied() {
		System.out.println("You must register before you can proceed with this action!");
	}

	public void printMenu() {
		System.out.println("Enter a number");
		System.out.println("1. View Collection");
		System.out.println("2. Register");
		System.out.println("3. Set preferences");
		System.out.println("4. Still deciding");
		System.out.println("5. Still deciding");
		System.out.println("6. Exit");
	}

	public void printDenial() {
		System.out.println("You must register first!\n");
	}
	
	// input validation where it would continue to loop if the input is outside 0 - max
	public int inputCheck(int input, int max) {
		while (input <= 0 || input > max) {
			System.out.println("Input invalid! Try again!");
			input = sc.nextInt();
		}
		return input;
	}
	
	public void printPrefMenu() {
		System.out.println("Enter a number");
		System.out.println("1. Add Genre");
		System.out.println("2. Remove Genre");
		System.out.println("3. Exit");
	}
}
