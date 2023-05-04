package com.solvd.ta.lab2.items;

import java.util.EnumSet;
import java.util.Objects;

import com.solvd.ta.lab2.Genre;

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
		return "Title: " + getTitle() + "\nVolume: " + volume + "\nAuthor: " + author + "\nReleased: " + year + "\nChapters:"
				+ startChap + "-" + endChap + "\nGenre(s): " + getGenre() + "\nDemographic: " + demographic + "\nPages: "
				+ pages + "\nSerial Number: " + serialNumber;
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

		Manga m = (Manga) o;
		return (getTitle().equals(m.getTitle()) && year == m.year && getGenre().equals(m.getGenre()) && author.equals(m.author)
				&& pages == m.pages && demographic.equals(m.demographic) && volume == m.volume
				&& startChap == m.startChap && endChap == m.endChap && serialNumber == m.serialNumber);
	}

	@Override
	public int hashCode() {
		int hash = Objects.hash(getTitle(), author, demographic);
		hash = 31 * hash + year;
		hash = 31 * hash + pages;
		hash = 31 * hash + volume;
		hash = 31 * hash + startChap;
		hash = 31 * hash + endChap;
		hash = 31 * hash + serialNumber;
		hash = 31 * hash + getGenre().hashCode();
		return hash;
	}
}
