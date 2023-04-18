package com.solvd.ta.lab2;

import java.util.ArrayList;
import java.util.EnumSet;

public class Storage {
	protected ArrayList<Media> arr = new ArrayList<Media>();
	protected int capacity;

	public Storage(int capacity) {
		this.capacity = capacity;
	}

	public Storage() {
		this.capacity = 100;
	}

	public void addMedia(Media media) {
		arr.add(media);
	}

	public void removeMedia(Media media) {
		arr.remove(media);
	}

	public void printInventory() {
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Storage storage = new Storage();
		Book dune = new Book("Dune", 1965, EnumSet.of(Genre.SCIFI, Genre.FANTASY), "Frank Herbert", 896);
		Manga demon = new Manga("Demon Slayer: Kimetsu no Yaiba", 2018, EnumSet.of(Genre.ADVENTURE), "Koyoharu Gotouge",
				192, "Shonen", 1, 1, 7);
		Movie batman = new Movie("The Dark Knight", 2008, EnumSet.of(Genre.ACTION, Genre.THRILLER), "Christopher Nolan",
				152, 9.0);
		storage.addMedia(dune);
		storage.addMedia(demon);
		storage.addMedia(batman);
		storage.printInventory();
		storage.removeMedia(batman);
		storage.printInventory();
	}
}
