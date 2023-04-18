package com.solvd.ta.lab2;

import java.util.EnumSet;

public class Book extends Media {
	private String author;
	private int pages;

	public Book(String title, int year, EnumSet<Genre> genre, String author, int pages) {
		super(title, year, genre);
		this.author = author;
		this.pages = pages;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getAuthor() {
		return this.author;
	}

	public int getPages() {
		return this.pages;
	}

	@Override
	public String toString() {
		return "Title: " + this.title + "\nAuthor: " + this.author + "\nPublished: " + this.year + "\nGenre(s): "
				+ this.genre + "\nPages: " + this.pages;
	}

	public static void main(String[] args) {
		Book dune = new Book("Dune", 1965, EnumSet.of(Genre.SCIFI, Genre.FANTASY), "Frank Herbert", 896);
		System.out.println(dune);
	}

}
