package com.solvd.ta.lab2;

import java.util.EnumSet;

public class Manga extends Book {
	private String demographic;
	private int volume;
	private int startChap;
	private int endChap;

	public Manga(String title, int year, EnumSet<Genre> genre, String author, int pages, String demographic, int volume,
			int startChap, int endChap) {
		super(title, year, genre, author, pages);
		this.setDemographic(demographic);
		this.setVolume(volume);
		this.setStartChap(startChap);
		this.setEndChap(endChap);
	}

	public void setDemographic(String demographic) {
		this.demographic = demographic;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public void setStartChap(int startChap) {
		this.startChap = startChap;
	}

	public void setEndChap(int endChap) {
		this.endChap = endChap;
	}

	public String getDemographic() {
		return demographic;
	}

	public int getVolume() {
		return volume;
	}

	public int getStartChap() {
		return startChap;
	}

	public int getEndChap() {
		return endChap;
	}

	@Override
	public String toString() {
		return "Title: " + title + "\nVolume: " + volume + "\nAuthor: " + author + "\nReleased: " + year + "\nChapters:"
				+ startChap + "-" + endChap + "\nGenre(s): " + genre + "\nDemographic: " + demographic + "\nPages: "
				+ pages;
	}

	public static void main(String[] args) {
		Manga demon = new Manga("Demon Slayer: Kimetsu no Yaiba", 2018, EnumSet.of(Genre.ADVENTURE), "Koyoharu Gotouge",
				192, "Shonen", 1, 1, 7);
		System.out.println(demon);
	}
}
