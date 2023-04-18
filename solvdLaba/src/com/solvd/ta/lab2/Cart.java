package com.solvd.ta.lab2;

import java.util.EnumSet;

public class Cart extends Storage {

	public Cart(int capacity) {
		super(capacity);
	}

	public Cart() {
		super();
	}

	public void checkout() {
		System.out.println("Checking out ...");
		arr.clear();
	}

	public void printCart() {
		System.out.println("Cart: ");
		System.out.println(arr.size() + " item(s)");
		this.printInventory();
	}

	public static void main(String[] args) {
		Cart cart = new Cart();
		Book dune = new Book("Dune", 1965, EnumSet.of(Genre.SCIFI, Genre.FANTASY), "Frank Herbert", 896);
		Manga demon = new Manga("Demon Slayer: Kimetsu no Yaiba", 2018, EnumSet.of(Genre.ADVENTURE), "Koyoharu Gotouge",
				192, "Shonen", 1, 1, 7);
		Movie batman = new Movie("The Dark Knight", 2008, EnumSet.of(Genre.ACTION, Genre.THRILLER), "Christopher Nolan",
				152, 9.0);
		cart.addMedia(dune);
		cart.addMedia(demon);
		cart.addMedia(batman);
		cart.printCart();
		cart.checkout();
		cart.printCart();
	}
}
