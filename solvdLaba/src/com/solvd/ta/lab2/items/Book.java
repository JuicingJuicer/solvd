package com.solvd.ta.lab2.items;

import java.util.EnumSet;
import java.util.Objects;

import com.solvd.ta.lab2.enums.Genre;

public class Book extends Media {
	protected String author;
	int pages;

	public Book(String title, int year, EnumSet<Genre> genre, String author, int pages) {
		super(title, year, genre);
		this.author = author;
		this.pages = pages;
	}

	public String getAuthor() {
		return author;
	}

	public int getPages() {
		return pages;
	}

	@Override
	public String toString() {
		return "\nTitle: " + getTitle() + "\nAuthor: " + author + "\nPublished: " + getYear() + "\nGenre(s): " + getGenre()
				+ "\nPages: " + pages + "\nSerial Number: " + serialNumber;
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

		Book b = (Book) o;
		return (getTitle().equals(b.getTitle()) && getYear() == b.getYear() && getGenre().equals(b.getGenre())
				&& author.equals(b.author) && pages == b.pages && serialNumber == b.serialNumber);
	}

	@Override
	public int hashCode() {
		int hash = Objects.hash(getTitle(), author);
		hash = 31 * hash + getYear();
		hash = 31 * hash + pages;
		hash = 31 * hash + serialNumber;
		hash = 31 * hash + getGenre().hashCode();
		return hash;
	}
}
