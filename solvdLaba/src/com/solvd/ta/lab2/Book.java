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

	public void printDetails() {
		System.out.println("Title: " + this.getTitle());
		System.out.println("Author: " + this.getAuthor());
		System.out.println("Published: " + this.getYear());
		System.out.println("Genre(s): " + this.getGenre());
		System.out.println("Pages: " + this.getPages());
	}

	public static void main(String[] args) {
		Book dune = new Book("Dune", 1965, EnumSet.of(Genre.SCIFI), "Frank Herbert", 896);
		dune.printDetails();

	}

}
