package com.solvd.ta.lab2;

public class Librarian {
	private String name;
	private boolean isRegistered = false;

	public Librarian(String name) {
		this.name = name;
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
		System.out.println("Hi I'm " + this.name + " , I'm the librarian. How can I help you?");
	}

	public void denied() {
		System.out.println("You must register before you can proceed with this action!");
	}
}
