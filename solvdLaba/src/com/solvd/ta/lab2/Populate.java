package com.solvd.ta.lab2;

import java.util.ArrayList;
import java.util.EnumSet;

public class Populate {

	public static ArrayList<Media> generateBooks() {
		ArrayList<Media> arr = new ArrayList<>();
		arr.add(new Book("Dune", 1965, EnumSet.of(Genre.SCIFI), "Frank Herbert", 896));
		arr.add(new Book("Brave New World", 1932, EnumSet.of(Genre.SCIFI), "Aldous Huxley", 311));
		arr.add(new Book("The Help", 2009, EnumSet.of(Genre.FICTION), "Kathryn Stockett", 311));
		arr.add(new Book("Pride and Prejudice", 1813, EnumSet.of(Genre.ROMANCE), "Jane Austen", 432));
		arr.add(new Book("Lock In", 2014, EnumSet.of(Genre.SCIFI), "John Scalzi", 336));
		return arr;
	}

	public static ArrayList<Media> generateMovies() {
		ArrayList<Media> arr = new ArrayList<>();
		arr.add(new Movie("The Dark Knight", 2008, EnumSet.of(Genre.ACTION, Genre.THRILLER), "Christopher Nolan", 152,
				9.0));
		arr.add(new Movie("Se7en", 1995, EnumSet.of(Genre.CRIME, Genre.DRAMA), "David Fincher", 127, 8.6));
		arr.add(new Movie("The Martian", 2015, EnumSet.of(Genre.ADVENTURE, Genre.SCIFI), "Ridley Scott", 144, 8.0));
		arr.add(new Movie("Forrest Gump", 1994, EnumSet.of(Genre.COMEDY, Genre.DRAMA), "Robert Zemeckis", 142, 8.8));
		arr.add(new Movie("The Shawshank Redemption", 1994, EnumSet.of(Genre.DRAMA, Genre.CRIME), "Frank Darabont", 142,
				9.3));
		return arr;
	}

	public static ArrayList<Media> generateManga() {
		ArrayList<Media> arr = new ArrayList<>();
		arr.add(new Manga("Demon Slayer: Kimetsu no Yaiba", 2018, EnumSet.of(Genre.ADVENTURE), "Koyoharu Gotouge", 192,
				"Shonen", 1, 1, 7));
		arr.add(new Manga("Mob Psycho 100", 2018, EnumSet.of(Genre.ACTION, Genre.COMEDY), "One", 200, "Shonen", 1, 1,
				9));
		arr.add(new Manga("Vinland Saga", 2005, EnumSet.of(Genre.ACTION, Genre.ADVENTURE), "Makoto Yukimura", 220,
				"Shonen", 1, 1, 5));
		arr.add(new Manga("Death Note", 2005, EnumSet.of(Genre.THRILLER), "Tsugumi Ohba", 195, "Shonen", 1, 1, 7));
		arr.add(new Manga("Fullmetal Alchemist", 2005, EnumSet.of(Genre.ADVENTURE), "Hiromu Arakawa", 192, "Shonen", 1,
				1, 4));
		return arr;
	}

	public static ArrayList<Media> generateItems() {
		ArrayList<Media> arr = new ArrayList<>();
		arr.addAll(Populate.generateBooks());
		arr.addAll(Populate.generateMovies());
		arr.addAll(Populate.generateManga());
		return arr;
	}
}
