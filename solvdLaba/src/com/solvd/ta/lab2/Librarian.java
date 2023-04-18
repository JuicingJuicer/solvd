package com.solvd.ta.lab2;

public class Librarian {
	private String name;
	private boolean isRegistered = false;

	public Librarian(String name) {
		this.setName(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIsRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}

	public String getName() {
		return this.name;
	}

	public boolean getIsRegistered() {
		return this.isRegistered;
	}

	public void greet() {
		System.out.println("Hi I'm " + this.name + ", I'm the librarian. How can I help you?");
		printMenu();
	}

	public void denied() {
		System.out.println("You must register before you can proceed with this action!");
	}

	public void printMenu() {
		System.out.println("Enter a number");
		System.out.println("1. Register");
		System.out.println("2. ");
		System.out.println("3. ");
		System.out.println("4. ");
		System.out.println("5. ");
	}

	public static void main(String[] args) {
		Librarian librarian = new Librarian("Jason");
		librarian.greet();
	}
}
