package com.solvd.ta.lab2.items;

import java.util.EnumSet;
import java.util.Objects;

import com.solvd.ta.lab2.enums.Genre;
import com.solvd.ta.lab2.enums.MangaType;

public class Manga extends Book {
	private EnumSet<MangaType> demographic;
	private int volume;
	private int startChap;
	private int endChap;

	public Manga(String title, int year, EnumSet<Genre> genre, String author, int pages, EnumSet<MangaType> demographic,
			int volume, int startChap, int endChap) {
		super(title, year, genre, author, pages);
		this.demographic = demographic;
		this.volume = volume;
		this.startChap = startChap;
		this.endChap = endChap;
	}

	public void setDemographic(EnumSet<MangaType> demographic) {
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

	public EnumSet<MangaType> getDemographic() {
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
		return "\nTitle: " + getTitle() + "\nVolume: " + volume + "\nAuthor: " + author + "\nReleased: " + getYear()
				+ "\nChapters:" + startChap + "-" + endChap + "\nGenre(s): " + getGenre() + "\nDemographic: "
				+ demographic + "\nPages: " + pages + "\nSerial Number: " + serialNumber;
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
		return (getTitle().equals(m.getTitle()) && getYear() == m.getYear() && getGenre().equals(m.getGenre())
				&& author.equals(m.author) && pages == m.pages && demographic.equals(m.demographic)
				&& volume == m.volume && startChap == m.startChap && endChap == m.endChap
				&& serialNumber == m.serialNumber);
	}

	@Override
	public int hashCode() {
		int hash = Objects.hash(getTitle(), author);
		hash = 31 * hash + getYear();
		hash = 31 * hash + pages;
		hash = 31 * hash + volume;
		hash = 31 * hash + startChap;
		hash = 31 * hash + endChap;
		hash = 31 * hash + serialNumber;
		hash = 31 * hash + getGenre().hashCode();
		hash = 31 * hash + demographic.hashCode();
		return hash;
	}
}
