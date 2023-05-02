package com.solvd.ta.lab2;

import java.util.EnumSet;

import com.solvd.ta.lab2.interfaces.Item;

// Base class for classes like books, movies, etc
public abstract class Media implements Item {
	protected String title;
	protected int year;
	protected EnumSet<Genre> genre;
	protected static int numberOfMedia;
	protected int serialNumber;

	public Media(String title, int year, EnumSet<Genre> genre) {
		this.title = title;
		this.year = year;
		this.genre = genre;
		numberOfMedia++;
		this.serialNumber = this.numberOfMedia;
	}

	static {
		numberOfMedia = 0;
	}

	public abstract String toString();

	public int getSerialNumber() {
		return this.serialNumber;
	}
}
