package com.solvd.ta.lab2;

public class Main {
	public static void main(String[] args) {
		Library library = new Library("Juice Library", "Stockton");
		Librarian librarian = new Librarian("John");
		Storage storage = new Storage();
		Cart cart = new Cart();
		Populate populate = new Populate();

		// generates media objects and clones it to storage
		populate.generateItems();
		storage.cloneItems(populate.getArr());

		library.greetings();
		
	}
}
