package com.solvd.ta.lab2;

interface ShoppingCart {
	public void addToCart(Media media);

	public void removeFromCart(Media media);

	public void checkout();

	public void printCart();

	public int getCartSize();
}

public class Cart extends Storage implements ShoppingCart {

	public Cart(int capacity) {
		super(capacity);
	}

	public Cart() {
		super();
	}

	public void addToCart(Media media) {
		filteredArr.add(media);
	}

	public void removeFromCart(Media media) {
		filteredArr.remove(media);
	}

	public void checkout() {
		System.out.println("Checking out ...");
		filteredArr.clear();
	}

	public void printCart() {
		System.out.println("Cart: ");
		System.out.println(getCartSize() + " item(s)");
		this.printInventory();
	}

	public int getCartSize() {
		return filteredArr.size();
	}

}
