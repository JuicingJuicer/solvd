package com.solvd.ta.lab2;

import java.util.ArrayList;
import java.util.EnumSet;

public class Populate {
	ArrayList<Media> arr = new ArrayList<Media>();

	public void generateBooks() {
		Book dune = new Book("Dune", 1965, EnumSet.of(Genre.SCIFI), "Frank Herbert", 896);
		addBooks(dune);
		if (arr.get(0) instanceof Book) {
			Book book = (Book) arr.get(0);
			// book.printDetails();
		}
	}

	public void addBooks(Media m) {
		arr.add(m);
	}

	public static void main(String[] args) {
		Populate a = new Populate();
		a.generateBooks();
	}
}
