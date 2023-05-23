package com.solvd.ta.lab2.items;

import java.util.EnumSet;
import java.util.Objects;

import com.solvd.ta.lab2.enums.GameMode;
import com.solvd.ta.lab2.enums.GameType;
import com.solvd.ta.lab2.enums.Genre;
import com.solvd.ta.lab2.enums.Platform;

public class Game extends Media {
	private String studio;
	private EnumSet<Platform> platform;
	private EnumSet<GameType> gameType;
	private EnumSet<GameMode> gameMode;

	public Game(String title, int year, EnumSet<Genre> genre, String studio, EnumSet<Platform> platform,
			EnumSet<GameType> gameType, EnumSet<GameMode> gameMode) {
		super(title, year, genre);
		this.studio = studio;
		this.platform = platform;
		this.gameType = gameType;
		this.gameMode = gameMode;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public void setPlatform(EnumSet<Platform> platform) {
		this.platform = platform;
	}

	public void setGameType(EnumSet<GameType> gameType) {
		this.gameType = gameType;
	}

	public void setGameMode(EnumSet<GameMode> gameMode) {
		this.gameMode = gameMode;
	}

	public String getStudio() {
		return studio;
	}

	public EnumSet<Platform> getPlatform() {
		return platform;
	}

	public EnumSet<GameType> getGameType() {
		return gameType;
	}

	public EnumSet<GameMode> getGameMode() {
		return gameMode;
	}

	@Override
	public String toString() {
		return "\nTitle: " + getTitle() + "\nStudio: " + studio + "\nYear Released: " + getYear() + "\nGenre: "
				+ getGenre() + "\nGame Type: " + gameType + "\nPlatforms: " + platform + "\nSerial Number: "
				+ serialNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (null == o) {
			return false;
		}
		if (this == o) {
			return true;
		}
		if (getClass() != o.getClass()) {
			return false;
		}

		Game m = (Game) o;
		return (getTitle().equals(m.getTitle()) && getYear() == m.getYear() && getGenre().equals(m.getGenre())
				&& studio.equals(m.studio) && gameType.equals(gameType) && platform.equals(platform)
				&& serialNumber == m.serialNumber);
	}

	@Override
	public int hashCode() {
		int hash = Objects.hash(getTitle(), studio);
		hash = 31 * hash + getYear();
		hash = 31 * hash + serialNumber;
		hash = 31 * hash + getGenre().hashCode();
		hash = 31 * hash + gameType.hashCode();
		hash = 31 * hash + platform.hashCode();
		return hash;
	}
}
