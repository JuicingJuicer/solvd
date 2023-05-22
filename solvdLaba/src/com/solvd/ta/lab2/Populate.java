package com.solvd.ta.lab2;

import java.util.ArrayList;
import java.util.EnumSet;

import com.solvd.ta.lab2.enums.GameMode;
import com.solvd.ta.lab2.enums.GameType;
import com.solvd.ta.lab2.enums.Genre;
import com.solvd.ta.lab2.enums.Platform;
import com.solvd.ta.lab2.items.Book;
import com.solvd.ta.lab2.items.Game;
import com.solvd.ta.lab2.items.Manga;
import com.solvd.ta.lab2.items.Media;
import com.solvd.ta.lab2.items.Movie;

public class Populate {

	public static ArrayList<Media> generateBooks() {
		ArrayList<Media> arr = new ArrayList<>();
		arr.add(new Book("Dune", 1965, EnumSet.of(Genre.SCIFI), "Frank Herbert", 896));
		arr.add(new Book("Brave New World", 1932, EnumSet.of(Genre.SCIFI), "Aldous Huxley", 311));
		arr.add(new Book("The Help", 2009, EnumSet.of(Genre.FICTION), "Kathryn Stockett", 311));
		arr.add(new Book("Pride and Prejudice", 1813, EnumSet.of(Genre.ROMANCE), "Jane Austen", 432));
		arr.add(new Book("Lock In", 2014, EnumSet.of(Genre.SCIFI), "John Scalzi", 336));
		arr.add(new Book("The Hunger Games", 2008, EnumSet.of(Genre.SCIFI, Genre.THRILLER), "Suzanne Collins", 374));
		arr.add(new Book("The Handmaid's Tale", 1985, EnumSet.of(Genre.SCIFI), "Margaret Atwood", 311));
		arr.add(new Book("Macbeth", 1623, EnumSet.of(Genre.SCIFI), "William Shakespeare", 132));
		arr.add(new Book("The Hobbbit", 1937, EnumSet.of(Genre.FANTASY), "J. R. R. Tolkien", 310));
		arr.add(new Book("The Grapes of Wrath", 1939, EnumSet.of(Genre.FICTION), "John Steinbeck", 464));
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
		arr.add(new Movie("The Terminator", 1984, EnumSet.of(Genre.ACTION, Genre.ADVENTURE), "James Cameron", 107,
				8.1));
		arr.add(new Movie("Prisoners", 2013, EnumSet.of(Genre.THRILLER, Genre.DRAMA), "Denis Villeneuve", 153, 8.1));
		arr.add(new Movie("Toy Story 3", 2010, EnumSet.of(Genre.COMEDY, Genre.ADVENTURE), "Lee Unkrich", 103, 8.3));
		arr.add(new Movie("Fight Club", 1999, EnumSet.of(Genre.ACTION, Genre.THRILLER), "David Fincher", 139, 8.8));
		arr.add(new Movie("The Truman Show", 1998, EnumSet.of(Genre.SATIRE, Genre.COMEDY), "Peter Weir", 103, 8.2));
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

	public static ArrayList<Media> generateGame() {
		ArrayList<Media> arr = new ArrayList<>();
		arr.add(new Game("The Last of Us", 2013, EnumSet.of(Genre.ACTION), "Naughty Dog", EnumSet.of(Platform.PS3),
				EnumSet.of(GameType.ADVENTURE), EnumSet.of(GameMode.SINGLEPLAYER, GameMode.MULTIPLAYER)));
		arr.add(new Game("God of War", 2018, EnumSet.of(Genre.ACTION), "Santa Monica Studio",
				EnumSet.of(Platform.PS4, Platform.PC), EnumSet.of(GameType.ADVENTURE, GameType.HACKANDSLASH),
				EnumSet.of(GameMode.SINGLEPLAYER)));
		arr.add(new Game("Call of Duty: Black Ops II", 2012, EnumSet.of(Genre.ACTION), "Treyarch",
				EnumSet.of(Platform.PS3, Platform.XBOX360, Platform.WIIU), EnumSet.of(GameType.FPS),
				EnumSet.of(GameMode.SINGLEPLAYER, GameMode.MULTIPLAYER)));
		arr.add(new Game("Grand Theft Auto IV", 2008, EnumSet.of(Genre.ACTION), "Rockstar North",
				EnumSet.of(Platform.PS3, Platform.XBOX360, Platform.PC), EnumSet.of(GameType.ADVENTURE),
				EnumSet.of(GameMode.SINGLEPLAYER, GameMode.MULTIPLAYER)));
		arr.add(new Game("Valheim", 2021, EnumSet.of(Genre.ACTION), "Iron Gate Studio",
				EnumSet.of(Platform.PC, Platform.XBOXONE, Platform.XBOXSERIESX),
				EnumSet.of(GameType.SANDBOX, GameType.SURVIVAL),
				EnumSet.of(GameMode.SINGLEPLAYER, GameMode.MULTIPLAYER)));
		return arr;
	}

	public static ArrayList<Media> generateItems() {
		ArrayList<Media> arr = new ArrayList<>();
		arr.addAll(Populate.generateBooks());
		arr.addAll(Populate.generateMovies());
		arr.addAll(Populate.generateManga());
		arr.addAll(Populate.generateGame());
		return arr;
	}
}
