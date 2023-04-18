package com.solvd.ta.lab2;

import java.util.ArrayList;
import java.util.EnumSet;

public class Populate {
	private ArrayList<Media> arr = new ArrayList<Media>();

	public ArrayList<Media> getArr() {
		return arr;
	}

	public void generateBooks() {
		Book dune = new Book("Dune", 1965, EnumSet.of(Genre.SCIFI), "Frank Herbert", 896);
		Manga demon = new Manga("Demon Slayer: Kimetsu no Yaiba", 2018, EnumSet.of(Genre.ADVENTURE), "Koyoharu Gotouge",
				192, "Shonen", 1, 1, 7);
		arr.add(dune);
		arr.add(demon);
	}

	public static void main(String[] args) {
		Populate pop = new Populate();
		pop.generateBooks();
	}
}
