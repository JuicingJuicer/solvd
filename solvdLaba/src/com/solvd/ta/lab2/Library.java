package com.solvd.ta.lab2;

public class Library {
	private String name;
	private String city;

	public Library(String name, String city) {
		this.name = name;
		this.city = city;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return this.name;
	}

	public String getCity() {
		return this.city;
	}

	public void greetings() {
		System.out.println("Hi welcome to " + this.name + " of " + this.city + "!");
	}

	public static void main(String[] args) {
		Library library = new Library("Juice Library", "Stockton");
		library.greetings();
	}
}
