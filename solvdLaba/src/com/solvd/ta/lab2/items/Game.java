package com.solvd.ta.lab2.items;

import java.util.EnumSet;

import com.solvd.ta.lab2.enums.GameGenre;
import com.solvd.ta.lab2.enums.Genre;
import com.solvd.ta.lab2.enums.Platform;

public class Game extends Media {
	EnumSet<Platform> platform;
	EnumSet<GameGenre> gameGenre;

	public Game(String title, int year, EnumSet<Genre> genre, EnumSet<Platform> platform,
			EnumSet<GameGenre> gameGenre) {
		super(title, year, genre);
		this.platform = platform;
		this.gameGenre = gameGenre;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
