package com.solvd.ta.lab2;

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
		System.out.println(filteredArr.size() + " item(s)");
		this.printInventory();
	}

	public void addToCart(Media media) {
		filteredArr.add(media);
	}
}
